package CreatorTowerDefense.content;

import arc.graphics.Color;
import mindustry.content.Items;
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
    public static Block 双管1,双管2,双管3,
            炮塔aaa;

    public static void load() {
        双管1 = new TDPowerTurret("双管1", 60, 8) {{
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 2;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;trailColor =C("baee33");
            }};
            consumePower(2 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 5));
        }};
        双管2 = new TDPowerTurret("双管2", 40, 14) {{
            shootType = new BasicBulletType(4f, 5) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor =C("fff96f");
            }};
            升级前置=双管1;
            consumePower(30 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 50));
        }};
        双管3 = new TDPowerTurret("双管3", 25, 22) {{
            shootType = new BasicBulletType(4f, 10) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor =C("ff847d");
            }};
            升级前置=双管2;
            consumePower(100 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 200,魄,20));
        }};
    }
}

