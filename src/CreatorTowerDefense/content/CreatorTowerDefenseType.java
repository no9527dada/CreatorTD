package CreatorTowerDefense.content;

import ct.Asystem.type.EU_healthDisplay;
import ct.Asystem.type.OnlyAttackCoreAI;
import ct.Asystem.type.UnitDeathReward;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.Damage;
import mindustry.entities.Units;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.meta.BlockFlag;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
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

    public static class TDWall extends Wall {
        public TDWall(String name, int 血量) {
            super(name);
            requirements(Category.defense, with(魂,0));
            health = 血量;
            size = 3;
            armor = 2;
        }
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
            size=2;
           // 升级前置=null;
        }
        public static Block 升级前置;
        @Override
        public boolean canReplace(Block other){
            return 升级前置 == other;
        }

        class Build extends PowerTurret.PowerTurretBuild {
            @Override
            public void damage(float damage) {
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
            hitSize = 4;
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
                bullet = new BasicBulletType(9, 伤害, "ctdt-透明") {{
                    collidesAir = false;
                    collidesGround = true;
                    lifetime = 3;
                    collides = collidesTiles = true;
                    hitSound = Sounds.explosion;
                    hitEffect = Fx.pulverize;
                    killShooter = true;//射击后死亡
                    hittable = false;//这颗子弹能否被点防击中
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
