package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.struct.ObjectMap;
import arc.util.Nullable;
import arc.util.Tmp;
import ct.Asystem.type.EU_healthDisplay;
import ct.Asystem.type.OnlyAttackCoreAI;
import ct.Asystem.type.VXV.EntityDraw;
import ct.Asystem.type.factory.CoreGenericCrafter;
import ct.Asystem.type.factory.CreatorsUnitFactory;
import ct.content.Effect.NewEffect;
import ct.content.NewColor;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.defense.turrets.TractorBeamTurret;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatValues;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
import static arc.graphics.g2d.Draw.alpha;
import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
import static ct.Asystem.WorldDifficulty.cheat;
import static ct.content.ItemX.物品;
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


        }
    }

    public static class TDCoreGenericCrafter extends CoreGenericCrafter {
        public TDCoreGenericCrafter(String name) {

            super(name);
        }

        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }

        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);
            super.drawPlace(x, y, rotation, valid);
        }


        public class TDCoreGenericCrafterBuild extends CoreGenericCrafterBuilding {

            @Override
            public void craft() {
                super.craft();
                if (outputItems != null) {
                    for (ItemStack output : outputItems) {
                        EntityDraw.addItemIcon(x, y, output.item.fullIcon, output.amount, 0.3f);
                    }
                }
            }

        }

    }

    public static class TDWall extends Wall {//敌方的资源墙

        public TDWall(String name, int 血量) {
            super(name);
            requirements(Category.defense, with(魂, 0));
            health = 血量;
            size = 3;
            armor = 0;
            createRubble = false;//被破坏后的黑色残留
            requirements(Category.defense, BuildVisibility.sandboxOnly, with(物品, 0));
        }
    }

    //无限波次的方块
    public static class infiniteWall extends Wall {
        public infiniteWall(String name) {
            super(name);
            health = 100;
            solid = false;//固体
            buildType = Build::new;
        }

        /**
         * 通用地板限制
         */
        public Floor floor;//需要的地板

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor()) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return !tempTiles.contains(o -> o.floor() != floor);
        }

        class Build extends Wall.WallBuild {//不会受到伤害

            @Override
            public void damage(float damage) {
            }
        }
    }

    //塔防的统一炮塔
    public static class TDPowerTurret extends PowerTurret {
        public TDPowerTurret(String name, float 射速, float 范围) {
            super(name);
            targetable = false;//被单位攻击？
            health = 100;
            inaccuracy = 0f;
            rotateSpeed = 3f;
            armor = 500;
            // buildType = Build::new;
            coolantMultiplier = 0f; //液体冷却倍率
            liquidCapacity = 0; //液体容量
            hasLiquids = false;
            reload = 射速;
            range = 范围 * 8;
            size = 2;
            shootCone = 90;//射击锁定角度
            buildCostMultiplier = 3;//建造时间倍
        }

        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }

        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
         /*   if ( (player.team().core() != null && player.team().core().items.has(requirements, Vars.state.rules.buildCostMultiplier)) || Vars.state.rules.infiniteResources ) {
                this.drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
            }*/
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);

            super.drawPlace(x, y, rotation, valid);

/*        //免伤
    class Build extends PowerTurret.PowerTurretBuild {
            @Override
            public void damage(float damage) {
            }
        }*/
        }
    }

    //融汇类炮塔
    public static class TDLaserTurret extends LaserTurret {
        public TDLaserTurret(String name, float 射速, float 范围) {
            super(name);
            targetable = false;//被单位攻击？
            health = 100;
            inaccuracy = 0f;
            rotateSpeed = 3f;
            armor = 500;
            // buildType = Build::new;
            coolantMultiplier = 0f; //液体冷却倍率
            liquidCapacity = 0; //液体容量
            coolant =null;
            hasLiquids = false;
            reload = 射速;
            range = 范围 * 8;
            size = 3;
            shootCone = 90;//射击锁定角度
            buildCostMultiplier = 2.5f;//建造时间倍
        }

        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }

        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
         /*   if ( (player.team().core() != null && player.team().core().items.has(requirements, Vars.state.rules.buildCostMultiplier)) || Vars.state.rules.infiniteResources ) {
                this.drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
            }*/
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);

            super.drawPlace(x, y, rotation, valid);

/*        //免伤
    class Build extends PowerTurret.PowerTurretBuild {
            @Override
            public void damage(float damage) {
            }
        }*/
        }
    }
    //扣核心资源的炮塔
    public static class TDItemTurret extends Turret {
        public TDItemTurret(String name, float 范围, float 时间, StatusEffect 状态,float 装弹倍率) {
            super(name);
            size = 3;
            armor = 500;
            health = 100;
            destroyEffect = Fx.reactorExplosion;
            range = 范围;
            shootEffect=Fx.none;
            shootWarmupSpeed = 0.01F;
            minWarmup = 1f;
            linearWarmup = true;

            rotateSpeed = 0;//武器旋转速度
            shootCone = 360;//射击瞄准角度
            //createRubble = true;//被破坏后的黑色残留
            //rebuildable = false;//不会自动重建，不会留下残影 星球规则里同：ghostBlocks= false
            shootY = 0;
            shootType = new BasicBulletType(0, 1) {{
                lifetime = 0f;
                ammoMultiplier = 装弹倍率;//装弹倍率
                splashDamageRadius = 范围;
                splashDamage = 0;
                status = 状态;
                statusDuration = 时间;
                maxAmmo=1;
                despawnEffect=hitEffect=new WaveEffect() {{//一个空心圈，适用子弹击中效果
                    sizeFrom = 0f;
                    sizeTo = 范围;
                    //持续时间
                    lifetime = 60;
                    strokeFrom = 4f;
                    strokeTo = 1f;
                    colorFrom = NewColor.光棱塔Bullet1;
                    colorTo = NewColor.光棱塔Bullet2;
                }};
            }};
        }

        public ItemStack[] itemStacks;
        public BulletType shootType;
        public TDItemTurret(String name) {
            super(name);
        }
        @Override
        public void setStats(){
            super.setStats();
            stats.add(Stat.ammo, StatValues.items(false, itemStacks));//显示子弹种类
            stats.add(Stat.ammo, StatValues.ammo(ObjectMap.of(this, shootType)));//显示伤害数字

        }
        public Block 升级前置 = null;
        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }
        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;
            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);
            super.drawPlace(x, y, rotation, valid);
        }
        public class TDItemTurretBuild extends TurretBuild{
            @Override
            public void updateTile(){
                unit.ammo((float)unit.type().ammoCapacity * totalAmmo / maxAmmo);

                if(totalAmmo < maxAmmo){
                    Building core = Vars.state.teams.get(team).core();
                    if(core != null && core.items.has(itemStacks)){
                        core.items.remove(itemStacks);
                        totalAmmo ++;
                    }
                }
                super.updateTile();
            }            @Override
            public BulletType useAmmo(){
                totalAmmo --;
                return shootType;
            }            @Override
            public boolean hasAmmo(){
                return totalAmmo > 0;
            }
            @Override
            public BulletType peekAmmo(){
                return shootType;
            }

        }
    }

    //塔防的激光炮 实则差扰改的
    public static class TDTractorBeamTurret extends TractorBeamTurret {
        public TDTractorBeamTurret(String name, float 伤害, float 范围) {
            super(name);
            range = 范围 * 8f;
            damage = 伤害 / 60f;
            health = 100;
            targetGround = true;
            hasPower = true;
            size = 3;
            force = 0;
            scaledForce = 6f;
            rotateSpeed = 10;
            armor = 500;
        }

        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }

        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
         /*   if ( (player.team().core() != null && player.team().core().items.has(requirements, Vars.state.rules.buildCostMultiplier)) || Vars.state.rules.infiniteResources ) {
                this.drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
            }*/
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);

            super.drawPlace(x, y, rotation, valid);
        }
    }
    public static class TDCreatorsUnitFactory extends CreatorsUnitFactory {
        public TDCreatorsUnitFactory(String name) {
            super(name);
        }
        public Block 升级前置 = null;

        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (tile == null) return false;
            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;

            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置);
        }

        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
         /*   if ( (player.team().core() != null && player.team().core().items.has(requirements, Vars.state.rules.buildCostMultiplier)) || Vars.state.rules.infiniteResources ) {
                this.drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
            }*/
            if (!valid && 升级前置 != null)
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);

            super.drawPlace(x, y, rotation, valid);
        }
    }
        public static class  CTTDBasicBulletType extends BulletType{
            public Color backColor = Pal.bulletYellowBack, frontColor = Pal.bulletYellow;
            public Color mixColorFrom = new Color(1f, 1f, 1f, 0f), mixColorTo = new Color(1f, 1f, 1f, 0f);
            public float width = 5f, height = 7f;
            public float shrinkX = 0f, shrinkY = 0f;
            public Interp shrinkInterp = Interp.linear;
            public float spin = 0, rotationOffset = 0f;
            public String sprite;
            public @Nullable String backSprite;

            public TextureRegion backRegion;
            public TextureRegion frontRegion;

            public CTTDBasicBulletType(float speed, float damage, String bulletSprite){
                super(speed, damage);
                this.sprite = bulletSprite;
            }

            public CTTDBasicBulletType(float speed, float damage){
                this(speed, damage, "bullet");
            }

            /** For mods. */
            public CTTDBasicBulletType(){
                this(1f, 1f, "bullet");
            }

            @Override
            public void load(){
                super.load();

                backRegion = Core.atlas.find(backSprite == null ? (sprite + "-back") : backSprite);
                frontRegion = Core.atlas.find(sprite);
            }

            @Override
            public void draw(Bullet b){
                super.draw(b);
               // float shrink = shrinkInterp.apply(b.fout());
                float height = this.height * ((1f - shrinkY) + shrinkY );
                float width = this.width * ((1f - shrinkX) + shrinkX );
                float offset = -90 + (spin != 0 ? Mathf.randomSeed(b.id, 360f) + b.time * spin : 0f) + rotationOffset;

                Color mix = Tmp.c1.set(mixColorFrom).lerp(mixColorTo, b.fin());

                Draw.mixcol(mix, mix.a);

                if(backRegion.found()){
                    Draw.color(backColor);
                    Draw.rect(backRegion, b.x, b.y, width, height, b.rotation() + offset);
                }

                Draw.color(frontColor);
                Draw.rect(frontRegion, b.x, b.y, width, height, b.rotation() + offset);

                Draw.reset();
            }
        }



    //塔防敌人的统一单位类
    public static class TDUnitType extends UnitType {
        public TDUnitType(String name, float 伤害, float 血量, float 移速) {
            super(name);
            controller = u -> new OnlyAttackCoreAI.GroundOnlyAttackCoreAI();//单位的AI 塔防AI
            //legCount=0;//没有脚
            // hovering = true;//悬停
            alwaysUnlocked = true;//默认解锁
            immunities.addAll(cheat);//免疫难度修改的BUFF
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
                bullet = new BasicBulletType(3, 0, "ctdt-透明") {{
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
                    fragBullet = new BasicBulletType(0f, 伤害, "ctdt-透明")//分裂的子弹
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
            }});
        }
    }
}
