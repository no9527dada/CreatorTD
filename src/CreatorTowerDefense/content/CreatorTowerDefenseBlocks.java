package CreatorTowerDefense.content;

import arc.struct.Seq;
import ct.Asystem.type.BlockDestroyReward;
import ct.Asystem.type.TDTyep.TDMendProjector;
import ct.Asystem.type.TDTyep.TDUnitFactory;
import ct.Asystem.type.TDTyep.TDsuicideWall;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.BuildVisibility;

import static ct.content.ItemX.物品;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTerrain.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDWall;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.*;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseBlocks {
    public static Block 魔力石墙, 修复器, 无限;
    public static Block 星尘单位工厂,星灵单位工厂,凝蓝单位工厂,蚀魂单位工厂
            ;
    public static void load() {
        星尘单位工厂 = new UnitFactory("星尘单位工厂") {{
            requirements(Category.units, with(
                    魂, 300, 魄, 5
            ));
            plans = Seq.with(
                    new UnitPlan(星尘单位, 60f * 20, with())
            );
            size = 3;
            consumePower(200 / 60f);
            floating = true;
        }};
        星灵单位工厂 = new UnitFactory("星灵单位工厂") {{
            requirements(Category.units, with(
                    魂, 120
            ));
            plans = Seq.with(
                    new UnitPlan(星灵单位, 60f * 40, with())
            );
            size = 3;
            consumePower(200 / 60f);
            floating = true;
        }};
        凝蓝单位工厂 = new TDUnitFactory("凝蓝单位工厂") {{
            requirements(Category.units, with(
                    魂, 350, 魄, 15
            ));

            plans = Seq.with(
                    new UnitPlan(凝蓝单位, 60f * 100, with())
            );
            size = 5;
            consumePower(800 / 60f);
            floating = true;
            升级前置=星灵单位工厂;
        }};
        蚀魂单位工厂 = new TDUnitFactory("蚀魂单位工厂") {{
            requirements(Category.units, with(
                    魂, 1400, 魄, 180
            ));
            plans = Seq.with(
                    new UnitPlan(蚀魂单位, 60f * 240, with())
            );
            size = 7;
            consumePower(2200 / 60f);
            floating = true;
           升级前置=凝蓝单位工厂;
        }};
        /**掉血墙，主类在主篇里面*/
        魔力石墙 = new TDsuicideWall("TD魔力石墙") {{
            requirements(Category.defense, with(魂, 600));
            floor = (Floor) TD地板a;
            createRubble = false;//被破坏后的黑色残留
        }};
        修复器 = new TDMendProjector("修复器a") {{
            requirements(Category.defense, with(魂, 600));
            floor = (Floor) TD地板b;
        }};
        无限 = new CreatorTowerDefenseType.infiniteWall("TD无限") {{
            floor = (Floor) TD地板d;
            requirements(Category.defense, with(星辰, 1));
        }};




    }
}