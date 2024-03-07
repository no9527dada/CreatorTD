package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import ct.Asystem.type.EU_healthDisplay;
import ct.Asystem.type.OnlyAttackCoreAI;
import ct.Asystem.type.UnitDeathReward;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.Damage;
import mindustry.entities.Units;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.meta.BlockFlag;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
import static ct.content.chapter1.Item1.陶;
import static mindustry.Vars.indexer;
import static mindustry.Vars.player;
import static mindustry.type.ItemStack.with;

//
public class CreatorTowerDefenseType {
    public static class TDFloor extends Floor {
        public TDFloor(String name) {
            super(name);
            solid = false;
            hasShadow = false;
            variants = 0;
            placeableOn = false;
            localizedName = Core.bundle.getOrNull("block.Floor");
        }
    }

    public static class TDWall extends Wall {//敌方的资源墙

        public TDWall(String name, int 血量) {
            super(name);
            requirements(Category.defense, with(魂, 0));
            health = 血量;
            size = 3;
            armor = 2;
        }
    }

    public static class DamageWall extends Wall {//己方的掉血墙
        /**伤害百分比*/
        public float damagePercent = 1f;
        /**固定数值伤害*/
        public float damageAmount = 0f;
        /**伤害间隔*/
        public float damageTime = 120f;

        public DamageWall(String name) {
            super(name);
            update = true;
            health = 10000;
            //  floor=(Floor) Blocks.slag;//需要的地板
        }

        public class DamageWallBuild extends WallBuild {
            @Override
            public void updateTile() {
                if (timer().get(damageTime)) {
                    damage(damageAmount);
                    damage(damagePercent * maxHealth / 100);
                }
            }

        }

        /**通用地板限制*/
        public Floor floor = (Floor) Blocks.slag;//需要的地板
        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor()) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return !tempTiles.contains(o -> o.floor() != floor);
        }

        /**不可拆*/
        @Override
        public boolean  canBreak(Tile tile) { return false; }
    }

    public static class TDPowerTurret extends PowerTurret {
        public TDPowerTurret(String name, float 射速, float 范围) {
            super(name);
            targetable = false;//被单位攻击？
            health = 100;
            inaccuracy = 0f;
            rotateSpeed = 3f;
            buildType = Build::new;
            coolantMultiplier = 0f; //液体冷却倍率
            liquidCapacity = 0; //液体容量
            hasLiquids = false;
            reload = 射速;
            range = 范围 * 8;
            size = 2;
            shootCone=90;//射击锁定角度

        }

        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
         /*   if ( (player.team().core() != null && player.team().core().items.has(requirements, Vars.state.rules.buildCostMultiplier)) || Vars.state.rules.infiniteResources ) {
                this.drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
            }*/
            if(!valid && 升级前置 != null)drawPlaceText("需覆盖前置方块:[#ffdb6e]" + 升级前置.localizedName, x, y, false);

            super.drawPlace(x, y, rotation, valid);
        }


        class Build extends PowerTurret.PowerTurretBuild {
            @Override
            public void damage(float damage) {
            }
        }
    }

    /**修复器*/
    public static class TDMendProjector extends MendProjector {
        public float healAmount = 40f;//修复的数值
        public TDMendProjector(String name) {
            super(name);
            healPercent = 0;//这个接口无用，不要动他
            phaseBoost = 40;//是加入（相织布）提升的数值
            reload=5*60;//5秒1次加血
        }

        public class TDMendBuild extends MendBuild {
            @Override
            public void updateTile(){
                boolean canHeal = !checkSuppression();

                smoothEfficiency = Mathf.lerpDelta(smoothEfficiency, efficiency, 0.08f);
                heat = Mathf.lerpDelta(heat, efficiency > 0 && canHeal ? 1f : 0f, 0.08f);
                charge += heat * delta();

                phaseHeat = Mathf.lerpDelta(phaseHeat, optionalEfficiency, 0.1f);

                if(optionalEfficiency > 0 && timer(timerUse, useTime) && canHeal){
                    consume();
                }

                if(charge >= reload && canHeal){
                    float realRange = range + phaseHeat * phaseRangeBoost;
                    charge = 0f;

                    indexer.eachBlock(this, realRange, b -> b.damaged() && !b.isHealSuppressed(), other -> {
                        other.heal((healAmount + phaseHeat * phaseBoost) * efficiency);
                        other.recentlyHealed();
                        Fx.healBlockFull.at(other.x, other.y, other.block.size, baseColor, other.block);
                    });
                }
            }
        }
    }

    public static class TDUnitType extends UnitType {
        public TDUnitType(String name, float 伤害, float 血量, float 移速) {
            super(name);
            controller = u -> new OnlyAttackCoreAI();//单位的AI 塔防AI
            //legCount=0;//没有脚
            // hovering = true;//悬停
            alwaysUnlocked = true;//默认解锁
            flying = false;
            hitSize = 10;
            armor = 0;
            speed = 移速;
            health = 血量;
            drawCell = false;//不显示队伍指示贴图
            targetFlags = new BlockFlag[]{BlockFlag.core};
            constructor = UnitTypes.elude.constructor;
            ammoType = new ItemAmmoType(魂);
            abilities.add(new EU_healthDisplay.TDhealthDisplay(14, 22, 3));
            weapons.add(new Weapon() {{
                autoTarget = true;//被动开火?
                shootOnDeath = true;//当它的主人死后，这把武器是否应该开火
                reload = 30;
                shootCone = 180;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                inaccuracy = 0;
                x = 0;
                shootY = 0;
                mirror = false;
                bullet = new BasicBulletType(9, 0, "ctdt-透明") {{
                    width = 0.1f;
                    height = 0.1f;
                    collidesAir = false;
                    collidesGround = true;
                    lifetime = 3;
                    collides = collidesTiles = true;
                    hitSound = Sounds.explosion;
                    hitEffect = Fx.none;
                    killShooter = true;//射击后死亡
                    hittable = false;//这颗子弹能否被点防击中
                    homingPower = 1;
                    fragBullet = new BasicBulletType(2f, 伤害, "ctdt-透明")//分裂的子弹
                    {{
                        homingPower = 1;
                        width = 0.1f;
                        height = 0.1f;
                        lifetime = 20f;
                        shrinkY = 0;
                        shrinkX = 0;
                        despawnEffect = Fx.none;
                    }};
                    fragBullets = 1;//分裂的数量
                    fragRandomSpread = 0f;//分裂的角度
                }};
               /*  bullet = new BombBulletType(){{
                    splashDamage = 伤害;
                    lifetime = 9;
                    speed = 1;
                    splashDamageRadius = 30;
                    killShooter = true;
                   collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;

                    rangeOverride = 30f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 55f;
                    instantDisappear = true;
                    splashDamage = 90f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                }};*/
            }});
        }
    }
}
