package CreatorTowerDefense.content;

import ct.Asystem.type.TDTyep.BombTurret;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;
import mindustry.world.Block;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDPowerTurret;
import static ct.Asystem.type.CTColor.C;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class CreatorTowerDefenseTurrets {
    public static Block 双管1, 双管2, 双管3, 冰冻炸弹1, 冰冻炸弹2, 冰冻炸弹3, 冰冻炸弹4,
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
            consumePower(50 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 40));
        }};
        双管3 = new TDPowerTurret("双管3", 25, 22) {{
            shootType = new BasicBulletType(4f, 12) {{
                width = 7f;
                height = 9f;
                lifetime = 45f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
            }};
            升级前置 = 双管2;
            consumePower(200 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 200, 魄, 40));
        }};


        冰冻炸弹1 = new BombTurret("冰冻炸弹1", 14 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation1", 0.7f)) {{
            requirements(Category.turret, with(魂, 50));
        }};
        冰冻炸弹2 = new BombTurret("冰冻炸弹2", 20 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation2", 0.4f)) {{
            requirements(Category.turret, with(魂, 150, 魄, 5));
        }};
        冰冻炸弹3 = new BombTurret("冰冻炸弹3", 33 * 8, 5 * 60,
                new Buff.BuffStatusEffect("gelivation3", 0f, 0.7f)) {{
            requirements(Category.turret, with(魂, 320, 魄, 20));
        }};
    }
}



















