package CreatorTowerDefense.content;

import arc.struct.Seq;
import ct.Asystem.type.TDTyep.TDMendProjector;
import ct.Asystem.type.TDTyep.TDsuicideWall;
import ct.Asystem.type.TDTyep.UnitPortal;
import ct.Asystem.type.VXV.powerShowBlock;
import ct.Asystem.type.factory.CreatorsUnitFactory;
import ct.Asystem.type.factory.DuplexCoreGenericCrafter;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTerrain.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.*;
import static ct.content.ItemX.物品;
import static mindustry.content.UnitTypes.mono;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseBlocks {
    public static Block 初级魂魄凝练器, 中级魂魄凝练器, 高级魂魄凝练器, 超级魂魄凝练器;
    public static Block 魔力石墙, 修复器, 无限, 单位传送门, 电量查看器;
    public static Block 星尘单位工厂, 星灵单位工厂, 凝蓝单位工厂, 蚀魂单位工厂, 测试单位工厂;

    public static void load() {
        电量查看器 = new powerShowBlock("电量查看器") {{
            health = 100;
            armor = 500;
            itemCapacity = 10;
            size = 3;
            requirements(power, with(
                    魂, 50
            ));
        }};
        初级魂魄凝练器 = new TDCoreGenericCrafter("初级魂魄凝练器") {{
            consumePower(120 / 60f);
            outputItem = new ItemStack(魂, 4);
            health = 100;
            armor = 500;
            itemCapacity = 10;
            size = 4;
            craftTime = 60 * 5;
            requirements(crafting, with(
                    魂, 300
            ));
        }};
        中级魂魄凝练器 = new TDCoreGenericCrafter("中级魂魄凝练器") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 6);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 初级魂魄凝练器;
            requirements(crafting, with(
                    魂, 4500
            ));
        }};
        高级魂魄凝练器 = new DuplexCoreGenericCrafter("高级魂魄凝练器") {{
            consumeItems(with(魂, 10));
            consumePower(3200 / 60f);
            outputItems = ItemStack.with(魄, 1);
            health = 100;
            armor = 500;
            itemCapacity = 30;
            size = 4;
            craftTime = 60 * 5;
            requirements(crafting, with(
                    魂, 6600, 魄, 1200
            ));
        }};
        超级魂魄凝练器 = new DuplexCoreGenericCrafter("超级魂魄凝练器") {{
            consumeItems(with(星辰, 1));
            consumePower(9000 / 60f);
            outputItems = ItemStack.with(魄, 500, 魂, 3000);
            health = 100;
            armor = 500;
            itemCapacity = 40;
            size = 4;
            craftTime = 40;
            //升级前置=高级魂魄凝练器;
            requirements(crafting, with(
                    魂, 6600, 魄, 1200, 星辰, 80
            ));
        }};
        测试单位工厂 = new CreatorsUnitFactory("测试单位工厂") {{
            requirements(Category.units, with(
                    魂, 300, 魄, 5
            ));
            plans = Seq.with(
                    new UnitPlan(mono, 60f * 20, with(星辰, 500))
            );
            size = 3;
            //consumePower(200 / 60f);
            floating = true;

        }};


        星尘单位工厂 = new CreatorsUnitFactory("星尘单位工厂") {{
            unitLimit = 2;
            requirements(Category.units, with(
                    魂, 1200, 魄, 120
            ));
            plans = Seq.with(
                    new UnitPlan(星尘单位, 60f * 90, with())
            );
            size = 5;
            consumePower(500 / 60f);
            floating = true;

        }};
        星灵单位工厂 = new UnitFactory("星灵单位工厂") {{
            requirements(Category.units, with(
                    魂, 120
            ));
            plans = Seq.with(
                    new UnitPlan(星灵单位, 60f * 40, with())
            );
            size = 5;
            consumePower(200 / 60f);
            floating = true;
        }};
        凝蓝单位工厂 = new UnitFactory("凝蓝单位工厂") {{
            requirements(Category.units, with(
                    魂, 350, 魄, 15
            ));

            plans = Seq.with(
                    new UnitPlan(凝蓝单位, 60f * 100, with())
            );
            size = 5;
            consumePower(800 / 60f);
            floating = true;
            // 升级前置=星灵单位工厂;
        }};
        蚀魂单位工厂 = new UnitFactory("蚀魂单位工厂") {{
            requirements(Category.units, with(
                    魂, 1400, 魄, 180
            ));
            plans = Seq.with(
                    new UnitPlan(蚀魂单位, 60f * 240, with())
            );
            size = 7;
            consumePower(2200 / 60f);
            floating = true;
            //  升级前置=凝蓝单位工厂;
        }};
        /**掉血墙，主类在主篇里面*/
        魔力石墙 = new TDsuicideWall("TD魔力石墙") {{
            requirements(Category.defense, with(魂, 600));
            floor = (Floor) TD地板a;
            createRubble = false;//被破坏后的黑色残留
        }};
        修复器 = new TDMendProjector("修复器a") {{
            requirements(effect, with(魂, 600));
            floor = (Floor) TD地板b;
        }};
        无限 = new CreatorTowerDefenseType.infiniteWall("TD无限") {{
            floor = (Floor) TD地板d;
            requirements(effect, with(星越星辰, 1));
        }};
        单位传送门 = new UnitPortal("单位传送门") {
            public void setStats() {
                super.setStats();
                this.stats.add(Stat.basePowerGeneration, 1, StatUnit.powerSecond);
            }

            {
                hasPower = true;
                outputsPower = true;
                consumePower(0);
                health = 100;
                targetable = false;//被单位攻击
                UnitRange = 5;
                TransferAll = false;
                TransferType = false;
                size = 1;
                solid = false;
                TransferSpeed = 5;//传送等待时间 60=1秒
                requirements(effect, ItemStack.with(物品, 1));
                buildVisibility = BuildVisibility.sandboxOnly;
                buildType = Build::new;
            }
            class Build extends UnitPortal.UnitPortalBlockBuild {
                @Override
                public void damage(float damage) {
                }
                @Override
                public float getPowerProduction() {
                    return 1f / 60;
                }
            }
        };


    }
}