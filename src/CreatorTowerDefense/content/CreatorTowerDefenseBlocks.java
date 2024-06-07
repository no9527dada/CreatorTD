package CreatorTowerDefense.content;

import arc.Core;
import arc.scene.event.Touchable;
import arc.scene.ui.Label;
import arc.struct.Seq;
import ct.Asystem.type.TDTyep.TDMendProjector;
import ct.Asystem.type.TDTyep.TDsuicideWall;
import ct.Asystem.type.VXV.powerShowBlock;
import ct.Asystem.type.factory.CoreGenericCrafter;
import ct.Asystem.type.factory.CoreLiquidGenericCrafter;
import ct.Asystem.type.factory.CreatorsUnitFactory;
import ct.Asystem.type.factory.DuplexCoreGenericCrafter;
import mindustry.content.Liquids;
import mindustry.core.UI;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import java.util.Iterator;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTerrain.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDCoreGenericCrafter;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.*;
import static mindustry.content.UnitTypes.mono;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseBlocks {
    public static Block 初级魂魄凝练器, 初级魂魄转换器, 高级魂魄凝练器, 高级魂魄转换器;
    public static Block 魔力石墙,  无限, 电量查看器, 制冷机;
    public static Block 星尘单位工厂, 星灵单位工厂, 凝蓝单位工厂, 蚀魂单位工厂, 测试单位工厂;

    public static void load() {
        电量查看器 = new powerShowBlock("电量查看器") {
            public static void loadPowerShow() {
                Core.scene.find("minimap/position").parent.fill((t) -> {
                    Label label = new Label("");
                    label.update(() -> {
                        label.setText(() -> {
                            StringBuilder text = new StringBuilder();
                            Iterator var1 = powerShowBuild.iterator();

                            while(var1.hasNext()) {
                                powerShowBuild build = (powerShowBuild)var1.next();
                                text.append("<").append(build.message.toString()).append("> ").append(Core.bundle.get("category.power") + ": ");
                                text.append(build.power.graph.getPowerBalance() > 0.0F ? "+" : "").append(UI.formatAmount((long)(build.power.graph.getPowerBalance() * 60.0F)));
                               text.append("\n");
                            }

                            return text;
                        });
                    });
                    t.row();
                    t.add(label).touchable(Touchable.disabled).style(Styles.outlineLabel);
                    t.right();
                });
            }{
            health = 100;
            armor = 500;
           // itemCapacity = 10;
            size = 3;
            requirements(power, with(
                    魂, 50
            ));
        }};
        初级魂魄凝练器 = new TDCoreGenericCrafter("初级魂魄凝练器") {{
            consumePower(170 / 60f);
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
        高级魂魄凝练器 = new TDCoreGenericCrafter("高级魂魄凝练器") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 初级魂魄凝练器;
            requirements(crafting, with(
                    魂, 1800
            ));
        }};
        初级魂魄转换器 = new DuplexCoreGenericCrafter("初级魂魄转换器") {{
            consumeItems(with(魂, 15));
            consumePower(1500 / 60f);
            outputItems = ItemStack.with(魄, 4);
            health = 100;
            armor = 500;
            itemCapacity = 30;
            size = 4;
            craftTime = 60 * 2.5F;
            requirements(crafting, with(
                    魂, 3200, 魄, 300
            ));
        }};
        高级魂魄转换器 = new CoreGenericCrafter("高级魂魄转换器") {{
            consumeItems(with(星辰, 1));
            consumePower(9000 / 60f);
            outputItems = ItemStack.with(魄, 500, 魂, 3000);
            health = 100;
            armor = 500;
            itemCapacity = 40;
            size = 4;
            craftTime = 60*20;
            //升级前置=高级魂魄凝练器;
            requirements(crafting, with(
                    魂, 6600, 魄, 1200, 星辰, 80
            ));
        }};
        制冷机 = new CoreLiquidGenericCrafter("制冷机") {

            {
                consumeLiquid(Liquids.water, 12f / 60);
                consumeItems(with(魂, 2));
                consumePower(120 / 60f);
                outputLiquid = new LiquidStack(制冷剂, 6 / 60f);
                health = 100;
                armor = 500;
                liquidCapacity = 48;
                size = 2;
                craftTime = 30;
                hasPower = true;
                hasItems = true;
                hasLiquids = true;
                rotate = false;
                solid = true;
                outputsLiquid = true;
                lightLiquid = Liquids.cryofluid;
                requirements(crafting, with(
                        魂, 210, 魄, 30
                ));
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water),
                        new DrawLiquidTile(Liquids.cryofluid) {{
                            drawLiquidLight = true;
                        }},
                        new DrawDefault());
            }

         /*   class Build extends CoreGenericCrafter.CoreGenericCrafterBuilding {
                @Override
               public void updateTile() {
                    if (power.status > 0 && timer.get(1.2f * 60f)) {
                        float amount = Math.max(liquidCapacity - liquids.get(Liquids.water), 0);
                        liquids.add(Liquids.water, amount/2f);
                    }
                }

            }*/
        };
/*        测试单位工厂 = new CreatorsUnitFactory("测试单位工厂") {{
            requirements(Category.units, with(
                    魂, 300, 魄, 5
            ));
            plans = Seq.with(
                    new UnitPlan(mono, 60f * 20, with(星辰, 500))
            );
            size = 3;
            //consumePower(200 / 60f);
            floating = true;

        }};*/


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
        星灵单位工厂 = new CreatorTowerDefenseType.TDCreatorsUnitFactory("星灵单位工厂") {{
            requirements(Category.units, with(
                    魂, 120
            )); unitLimit = 3;
            plans = Seq.with(
                    new UnitPlan(星灵单位, 60f * 40, with())
            );
            size = 5;
            consumePower(200 / 60f);
            floating = true;
        }};
        凝蓝单位工厂 = new CreatorTowerDefenseType.TDCreatorsUnitFactory("凝蓝单位工厂") {{
            requirements(Category.units, with(
                    魂, 650, 魄, 180
            ));
            unitLimit = 2;
            plans = Seq.with(
                    new UnitPlan(凝蓝单位, 60f * 100, with())
            );
            size = 5;
            consumePower(800 / 60f);
            floating = true;
             升级前置=星灵单位工厂;
        }};
        蚀魂单位工厂 = new CreatorTowerDefenseType.TDCreatorsUnitFactory("蚀魂单位工厂") {{
            requirements(Category.units, with(
                    魂, 1400, 魄, 180
            ));unitLimit = 2;
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
            buildCostMultiplier = 0;
            health = 100000;
            armor = 500;
            rebuildable = true;//自动重建
            requirements(Category.defense, with(魂, 30));
            floor = (Floor) TD地板a;
        }};

        无限 = new CreatorTowerDefenseType.infiniteWall("TD无限") {{
            floor = (Floor) TD地板d;
            requirements(effect, with(星越星辰, 1));
        }};


    }
}