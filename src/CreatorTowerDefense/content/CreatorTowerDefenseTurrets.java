package CreatorTowerDefense.content;

import CreatorTowerDefense.content.Sundry.光圈;
import arc.Core;
import arc.graphics.Color;
import ct.Asystem.type.TDTyep.BombTurret;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;
import mindustry.type.StatusEffect;
import mindustry.world.Block;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDPowerTurret;
import static ct.Asystem.type.CTColor.C;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class CreatorTowerDefenseTurrets {
    public static Block 双管1, 双管2, 双管3, 冰冻炸弹1, 冰冻炸弹2, 冰冻炸弹3, 冰冻炸弹4,
            黏黏炮1,黏黏炮2,蓝瑟2,蓝瑟1,蓝瑟3,光圈1,
            激光炮1,激光炮2,激光炮3,激光炮4,

            炮塔aaa;

    public static void load() {
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
                width = 7f;
                height = 9f;
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
            requirements(Category.turret, with(魂, 60));
        }};
        双管3 = new TDPowerTurret("双管3", 25, 22) {{
            shootType = new BasicBulletType(4f, 12) {{
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
            }};
            升级前置 = 双管2;
            consumePower(200 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 200, 魄, 40,星辰,15));
        }};
        StatusEffect  黏黏=  new StatusEffect("mucus"){{
            speedMultiplier = 0.5f;
            localizedName= Core.bundle.format("status.cttd-mucus.name", 100*speedMultiplier);
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
                splashDamageRadius = 2*8;
                splashDamage = 0.01F;
                status=  黏黏;
                statusDuration = 5*60f;
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
                splashDamageRadius = 3*8;
                splashDamage = 0.01F;
                status=  黏黏;
                statusDuration = 12*60f;
                shootCone = 90F;//瞄准角度
            }};
            升级前置 = 黏黏炮2;
            consumePower(400 / 60f);
            requirements(Category.turret, with(魂, 150,魄,20));
        }};
        蓝瑟1 = new TDPowerTurret("蓝瑟1", 70, 14) {{
            shootType = new LaserBulletType(3){{
                colors = new Color[]{C("fab02d").cpy().a(0.4f), C("fab02d"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 14*8;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            consumePower(30 / 60f);
            requirements(Category.turret, with(魂, 50));
        }};
        蓝瑟2 = new TDPowerTurret("蓝瑟2", 50, 17) {{
            shootType = new LaserBulletType(7){{
                colors = new Color[]{C("fab02d").cpy().a(0.4f), C("fab02d"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 17*8f;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            升级前置 = 蓝瑟1;
            consumePower(80 / 60f);
            requirements(Category.turret, with(魂, 180,魄,20));
        }};
        蓝瑟3 = new TDPowerTurret("蓝瑟3", 45, 22) {{
            shootType = new LaserBulletType(17){{
                colors = new Color[]{C("fab02d").cpy().a(0.4f), C("fab02d"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 22*8f;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            升级前置 = 蓝瑟2;
            consumePower(200 / 60f);
            requirements(Category.turret, with(魂, 800,魄,30,星辰,10));
        }};
        冰冻炸弹1 = new BombTurret("冰冻炸弹1", 14 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation1", 0.7f)) {{
            requirements(Category.turret, with(魂, 10));
        }};
        冰冻炸弹2 = new BombTurret("冰冻炸弹2", 20 * 8, 15 * 60,
                new Buff.BuffStatusEffect("gelivation2", 0.4f)) {{
            requirements(Category.turret, with(魂, 150, 魄, 5));
        }};
        冰冻炸弹3 = new BombTurret("冰冻炸弹3", 33 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation3",0.7f,0f)) {{
            requirements(Category.turret, with(魂, 320, 魄, 20));
        }};
        激光炮1 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮1",9,15){{
            consumePower(20f/60);
            requirements(Category.turret, with(魂, 35));
        }};
        激光炮2 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮2",16,19){{
            consumePower(90f/60);升级前置 = 激光炮1;
            requirements(Category.turret, with(魂, 220,魄,15));
        }};
        激光炮3 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮3",37,25){{
            升级前置 = 激光炮2;
            consumePower(500f/60);
            requirements(Category.turret, with(魂, 800,魄,40,星辰,50));
        }};
        激光炮4 = new CreatorTowerDefenseType.TDTractorBeamTurret("激光炮4",220,35){{
            size = 5;升级前置 = 激光炮3;
            consumePower(7000f/60);
            requirements(Category.turret, with(魂, 18000,魄,800,星辰,300));
        }};
        光圈.load();


    }
}



















