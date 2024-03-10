package cttd.content;

import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.power.*;
import mindustry.world.draw.*;


import static cttd.content.CreatorTowerDefenseItems.*;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefensePower {
    public static Block 节点小,节点大,初始电力产生器,电力产生器
            ;
    public static Block 修理            ;
    public static void load() {
        修理 = new MendProjector("mender"){{
            requirements(Category.effect, with(魂, 5000, 魄, 2000));
            consumePower(800/60f);
            size = 1;
            reload = 200f;
            range = 40f;
            healPercent = 4f;
            phaseBoost = 4f;
            phaseRangeBoost = 20f;
            health = 80;
            solid = false;//固体
           // consumeItem(Items.silicon).boost();
        }};

        节点小 = new PowerNode("power-node"){{
            requirements(Category.power, with(魂, 10));
            maxNodes = 6;
            laserRange = 9;
            solid = false;//固体
        }};
        节点大 = new PowerNode("power-node-large"){{
            requirements(Category.power, with(魂, 120, 魄, 5));
            size = 2;
            maxNodes = 30;
            laserRange = 22f;
            solid = false;//固体
        }};
        初始电力产生器=  new ConsumeGenerator("初始电力产生器"){{
            requirements(Category.power, with(魂, 80));
            powerProduction = 1f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 2;
            generateEffect = Fx.none;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            // consume(new ConsumeItemFlammable());
            // consume(new ConsumeItemExplode());
            drawer = new DrawDefault();
        }};
        电力产生器 = new ConsumeGenerator("电力产生器"){{
            requirements(Category.power, with(魂, 30, 魄, 2));
            powerProduction = 6f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 2;
            generateEffect = Fx.generatespark;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
           // consume(new ConsumeItemFlammable());
           // consume(new ConsumeItemExplode());

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawRegion("-turbine"){{
                        rotateSpeed = 2f;
                    }},
                    new DrawRegion("-turbine"){{
                        rotateSpeed = -2f;
                        rotation = 45f;
                    }},
                    new DrawRegion("-cap")

            );
        }};
    }
}
