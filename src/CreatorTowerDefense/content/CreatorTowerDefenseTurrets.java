package CreatorTowerDefense.content;

import CreatorTowerDefense.content.Sundry.三叶;
import CreatorTowerDefense.content.Sundry.光圈;
import CreatorTowerDefense.knapsack;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import ct.Asystem.type.TDTyep.BombTurret;
import ct.Asystem.type.TDTyep.CTMineCell;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.UnitSorts;
import mindustry.entities.Units;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.StatusEffect;
import mindustry.world.Block;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDPowerTurret;
import static CreatorTowerDefense.knapsack.*;
import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;
import static ct.Asystem.type.CTColor.C;

import static ct.content.chapter1.Item1.翠;
import static mindustry.content.Fx.none;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class CreatorTowerDefenseTurrets {
    public static Effect 火焰(int lifetime, int clipsize, int 数量, int 长度) {
        return new Effect(lifetime, clipsize, e -> {
            color(Pal.lightFlame, Pal.darkFlame, Color.gray, e.fin());
            randLenVectors(e.id, 数量, e.finpow() * 长度, e.rotation, 10, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 0.65f + e.fout() * 1.5f);
            });
        });
    }

    public static Block 双管1, 双管2, 双管3, 双管4, 双管5,
            冰霜塔1, 冰霜塔2, 冰霜塔3,
            黏黏炮1, 黏黏炮2, 蓝瑟2, 蓝瑟1, 蓝瑟3,
            激光炮1, 激光炮2, 激光炮3, 激光炮4,激光炮5,
            火焰喷射器1, 火焰喷射器2, 火焰喷射器3,
            钉钉塔,钉刺塔,地刺塔,地刺雷,
            繁花1,


    炮塔aaa;

    public static void load() {
        Buff.load();
        双管1 = new TDPowerTurret("双管1", 60, 8) {{
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};

            consumePower(10 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 4));
        }};
        双管2 = new TDPowerTurret("双管2", 40, 14) {{
            shootType = new BasicBulletType(4f, 6) {{
                width = 7 + 2f;
                height = 9 + 2f;
                lifetime = 30f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("fff96f");
            }};
            升级前置 = 双管1;
            consumePower(60 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 60, 魄, 5));
        }};
        双管3 = new TDPowerTurret("双管3", 35, 22) {{
            shootType = new BasicBulletType(4f, 13) {{
                width = 7 + 4f;
                height = 9 + 4f;
                lifetime = 65f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
            }};
            升级前置 = 双管2;
            consumePower(300 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 850, 魄, 330));
        }};
        双管4 = new TDPowerTurret("双管4", 25, 26) {{
            shootType = new BasicBulletType(4f, 20) {{
                width = 7 + 4f;
                height = 9 + 4f;
                lifetime = 60f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
                splashDamage = 40;
                splashDamageRadius = 3.5f * 8f;
                hitEffect = Fx.blastExplosion;
            }};
            升级前置 = 双管3;
            consumePower(3500 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 2600, 魄, 320, 星辰, 20));
        }};
        双管5 = new TDPowerTurret("双管5", 5, 35) {{
            size=4;
            shootSound = Sounds.shootBig;shoot = new ShootAlternate(16f);ammoUseEffect = Fx.casing3;
            shootType = new BasicBulletType(9f, 40) {{
                width = 14 + 4f;
                height = 17 + 4f;
                lifetime = 40f;
                ammoMultiplier = 1;
                inaccuracy = 4;//精准
                homingPower = 0.02F;
                hitEffect = Fx.blastExplosion;
                trailLength = 11;
                trailWidth = 4;
                trailColor = C("B8DCAA");
                splashDamage = 180;
                splashDamageRadius = 5f * 8f;
                lightning = 4; //闪电根数
                lightningLength = 15; //闪电长度
                lightningDamage = 15;//闪电伤害
                lightningColor = C("B8DCAA");//闪电颜色
            }};
            升级前置 = 双管4;
            consumePower(3500 / 60f);
            requirements(Category.turret, with(魂, 35000, 魄, 15000, 星辰, 80));
        }};
        StatusEffect 黏黏 = new StatusEffect("mucus") {{
            speedMultiplier = 0.5f;
            show = false;
            localizedName = Core.bundle.format("status.cttd-mucus.name", 100 * speedMultiplier);
        }};
        黏黏炮1 = new TDPowerTurret("黏黏炮1", 120, 14) {{
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
                splashDamageRadius = 2 * 8;
                splashDamage = 0.01F;
                status = 黏黏;
                statusDuration = 5 * 60f;
                shootCone = 90F;//瞄准角度
            }};
            consumePower(30 / 60f);
            requirements(Category.turret, with(魂, 40));
        }};
        黏黏炮2 = new TDPowerTurret("黏黏炮2", 80, 23) {{
            shootType = new BasicBulletType(4f, 6) {{
                width = 7f;
                height = 9f;
                lifetime = 70f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
                splashDamageRadius = 3 * 8;
                splashDamage = 0.01F;
                status = 黏黏;
                statusDuration = 12 * 60f;
                shootCone = 90F;//瞄准角度
            }};
            升级前置 = 黏黏炮1;
            consumePower(400 / 60f);
            requirements(Category.turret, with(魂, 560, 魄, 90));
        }};
        蓝瑟1 = new TDPowerTurret("蓝瑟1", 70, 14) {{
            shootSound = Sounds.laser;
            shootType = new LaserBulletType(5) {{
                colors = new Color[]{C("fab02d").cpy().a(0.4f), C("fab02d"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 14 * 8;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            consumePower(30 / 60f);
            requirements(Category.turret, with(魂, 50, 魄, 10));
        }};
        蓝瑟2 = new TDPowerTurret("蓝瑟2", 50, 17) {{
            shootSound = Sounds.laser;
            shootType = new LaserBulletType(15) {{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 20 * 8f;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            升级前置 = 蓝瑟1;
            consumePower(180 / 60f);
            requirements(Category.turret, with(魂, 220, 魄, 60));
        }};
        蓝瑟3 = new TDPowerTurret("蓝瑟3", 30, 22) {{
            shootSound = Sounds.laser;
            shootType = new LaserBulletType(33) {{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                fragOnHit=false;
                length = 30 * 8f;
                ammoMultiplier = 1f;
                shoot = new ShootSpread(4, 3);

            }};
            升级前置 = 蓝瑟2;
            consumePower(700 / 60f);
            requirements(Category.turret, with(魂, 6500, 魄, 560, 星辰, 4));
        }};
        繁花1=new TDPowerTurret("繁花1", 130, 25) {{
            //shootSound = Sounds.laser;
         unitSort = UnitSorts.farthest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
         size=3;
         shootCone = 40F;//瞄准角度
         shoot = new ShootSpread(2, 10f);
         shootType =new CreatorTowerDefenseType.CTTDBasicBulletType(2, 12, "cttd-bu3") {
             {
                 width = 25f;
                 height = 25f;
                 lifetime = 60f;
                 ammoMultiplier = 1;//装弹倍率
                 spin = 12;  fragOnHit=false;
                 pierce = true; //穿透
                 trailLength = 8;
                 trailWidth = 2;
                 //trailColor = 翠.color;
                 frontColor = C("ff93fa"); //前面颜色
                 fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(2, 12, "cttd-bu3")//分裂的子弹
                 {{
                     width = 25f;
                     height = 25f;
                     lifetime = 300f;
                     spin = 12;
                     fragOnHit=false;
                      backColor = Color.valueOf("ffffff"); //背景颜色
                     frontColor = C("ff93fa"); //前面颜色
                     pierce = true;
                     despawnEffect = Fx.none;
                     fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(3.5f, 12, "cttd-bu3")//分裂的子弹
                     {{
                         width = 25f;
                         height = 25f;
                         lifetime = 300f;
                         spin = 18;  fragOnHit=false;
                          backColor = Color.valueOf("ffffff"); //背景颜色
                         frontColor = C("ff93fa"); //前面颜色
                         pierce = true;       homingPower = 1;homingRange=150*8;
                         despawnEffect = Fx.none;
                     }};
                     fragBullets = 1;//分裂的数量
                     fragRandomSpread = 15f;//分裂的角度
                     fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                     fragVelocityMin = 1f;//随机范围的破片速度最小0。
                     fragVelocityMax = 1f;//随机范围的破片速度最大1。
                     fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                     fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                     despawnEffect = Fx.none;
                     hitEffect = Fx.none;
                 }};
                 fragBullets = 1;//分裂的数量
                 fragRandomSpread = 15f;//分裂的角度
                 fragAngle = 0f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                 fragVelocityMin = 1f;//随机范围的破片速度最小0。
                 fragVelocityMax = 1f;//随机范围的破片速度最大1。
                 fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                 fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                 despawnEffect = Fx.none;
                 hitEffect = Fx.none;
             }
         };
           // 升级前置 = 蓝瑟2;
            consumePower(400 / 60f);
            requirements(Category.turret, with(魂, 1000,魄,350));
        }};
        冰霜塔1 = new CreatorTowerDefenseType.TDItemTurret("冰霜塔1", 14 * 8, 8 * 60,
                new Buff.BuffStatusEffect("gelivation1", 0.7f), 1) {{

            reload = 11 * 60f;
            itemStacks = ItemStack.with(魂, 15);
            consumePower(120 / 60f);
            requirements(Category.turret, with(魂, 100));
        }};
        冰霜塔2 = new CreatorTowerDefenseType.TDItemTurret("冰霜塔2", 20 * 8, 20 * 60,
                new Buff.BuffStatusEffect("gelivation2", 0.4f), 1) {{
            reload = 20 * 60f;升级前置 = 冰霜塔1;
            itemStacks = ItemStack.with(魂, 30, 魄, 5);
            consumePower(500 / 60f);
            requirements(Category.turret, with(魂, 800, 魄, 230));
        }};
        冰霜塔3 = new CreatorTowerDefenseType.TDItemTurret("冰霜塔3", 33 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation3", 0.7f, 0f), 5) {{
            reload = 10 * 60f;升级前置 = 冰霜塔2;
            itemStacks = ItemStack.with(星辰, 1);
            consumePower(120 / 60f);
            requirements(Category.turret, with(魂, 1130, 魄, 130));
        }};
        激光炮1 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮1", 9, 15) {{
            shootCone = 360;
            rotateSpeed = 0;
            consumePower(20f / 60);
            requirements(Category.turret, with(魂, 35));
        }};
        激光炮2 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮2", 24, 19) {{
            shootCone = 360;
            rotateSpeed = 0;
            consumePower(180f / 60);
            升级前置 = 激光炮1;
            requirements(Category.turret, with(魂, 310, 魄, 20));
        }};
        激光炮3 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮3", 37, 25) {{
            shootCone = 360;
            rotateSpeed = 0;
            升级前置 = 激光炮2;
            consumePower(500f / 60);
            requirements(Category.turret, with(魂, 6800, 魄, 1400, 星辰, 6));
        }};
        激光炮4 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮4", 220, 35) {{
            shootCone = 360;
            rotateSpeed = 0;
            size = 5;
            升级前置 = 激光炮3;
            consumePower(7000f / 60);
            requirements(Category.turret, with(魂, 76000, 魄, 4800, 星辰, 20));
        }};
        光圈.load();
        火焰喷射器1 = new TDPowerTurret("火焰喷射器1", 200, 10) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.flame;
            shoot.shots = 70 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 4f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 20f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 100, 12, 105);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = Buff.TDburning;
            }};
            consumePower(130 / 60f);
            requirements(Category.turret, with(魂, 230, 魄, 35));
        }};
        火焰喷射器2 = new TDPowerTurret("火焰喷射器2", 240, 10) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.flame;
            shoot.shots = 90 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 9f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 22f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 100, 12, 100);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = Buff.TDburning;
            }};
            升级前置 = 火焰喷射器1;
            consumePower(400 / 60f);
            requirements(Category.turret, with(魂, 520, 魄, 50));
        }};
        火焰喷射器3 = new TDPowerTurret("火焰喷射器3", 360, 13) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.flame;
            shoot.shots = 110 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 22f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 29f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 130, 22, 120);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = Buff.TDburning;
            }};
            升级前置 = 火焰喷射器2;
            consumePower(2000 / 60f);
            requirements(Category.turret, with(魂, 2300, 魄, 220, 星辰, 8));
        }};
        new CreatorTowerDefenseType.TDItemTurret("资源炮") {{
            itemStacks = ItemStack.with(魂, 6, 魄, 2);
            consumePower(2000 / 60f);
            requirements(Category.turret, with(魂, 0, 魄, 0, 星辰, 0));
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        钉钉塔= new CTMineCell("钉钉塔") {
            {size=4;
                consumePower(500 / 60f);
                requirements(Category.turret, with(魂, 900, 魄, 400));
                mines = 1;
                floors = TD地板;
                mineConsumes = with(魂, 2);
                mine = new 钉钉子弹(mines,5);
            }
        };
        钉刺塔= new CTMineCell("钉刺塔") {
            {size=4;
                consumePower(2000 / 60f);
                requirements(Category.turret, with(魂, 1500, 魄, 2200));
                mines = 2;
                floors = TD地板;
                mineConsumes = with(魂, 4);
                mine = new 钉钉子弹(mines,30);
            }
        };
        地刺塔= new CTMineCell("地刺塔") {
            {size=5;
                consumePower(6000 / 60f);
                requirements(Category.turret, with(魂, 2800, 魄, 5000, 星辰, 50));
                mines = 2;
                floors = TD地板;
                mineConsumes = with(魄, 3);
                mine = new 钉钉子弹(mines,15);
            }
        };
        地刺雷= new CTMineCell("地刺雷") {
            {size=5;
                consumePower(14000 / 60f);
                requirements(Category.turret, with(魂, 7000, 魄, 15000, 星辰, 100));
                mines = 1;
                floors = TD地板;    mineConsumes = with(魄, 5);
                mine = new 钉雷子弹(mines,10,30,3);
            }
        };

    }
}



















