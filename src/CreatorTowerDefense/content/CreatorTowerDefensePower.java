package CreatorTowerDefense.content;

import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.power.*;
import mindustry.world.draw.*;


import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefensePower {
    public static Block 节点小,节点大,初始电力产生器,电力产生器,三级极点发电器,四级点辉发电器,五级辉灵发电器
            ;
    public static Block 修理            ;
    public static void load() {
        修理 = new MendProjector("mender"){{
            requirements(Category.effect, with(魂, 5000, 魄, 2000));
            consumePower(800/60f);
            size = 1;
            canOverdrive = false;
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
            maxNodes = 7;
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
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 80));
            canOverdrive = false;
            powerProduction = 1f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 3;
            generateEffect = Fx.none;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.02f;
            // consume(new ConsumeItemFlammable());
            // consume(new ConsumeItemExplode());
            drawer = new DrawDefault();
        }};
        电力产生器 = new ConsumeGenerator("电力产生器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 200, 魄, 40));
            canOverdrive = false;
            powerProduction = 360/60f;
            itemDuration = 60f;
            hasLiquids = false;
            size = 3;
            generateEffect = Fx.generatespark;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
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
        三级极点发电器=  new ConsumeGenerator("三级极点发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 320, 魄, 150));
            canOverdrive = false;
            powerProduction = 520/60f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 3;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.04f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }};
        四级点辉发电器=new NuclearReactor("四级点辉发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 580, 魄, 340));
            powerProduction = 1350/60f;
            itemDuration = 220f;
            size = 4;
            ambientSound = Sounds.steam;
            ambientSoundVolume = 0.06f;
            heating = 0f;//不会爆
            consumeItem(魂);
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());

        }};
        五级辉灵发电器=new ImpactReactor("五级辉灵发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 2300, 魄, 1500,星辰,50));
            powerProduction = 7000/60f;
            size = 5;
            itemDuration = 140f;
            ambientSound = Sounds.pulse;
            ambientSoundVolume = 0.03f;
            consumePower(0f);
            consumeItem(魄);
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());

        }};
    }
}
