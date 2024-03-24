package CreatorTowerDefense.content;

import arc.Core;
import ct.Asystem.type.BlockDestroyReward;

import ct.Asystem.type.waveRule;
import mindustry.type.Category;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static ct.content.ItemX.物品;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static mindustry.type.ItemStack.with;
import static ct.Asystem.type.TDTyep.TDBuffChange.*;

public class CreatorTowerDefenseSandbox {
    public static void load(){
        /**波次更改器
         用处理器配置此方块，完成终结波次的修改
         getlink q 0
         control config q 100
         stop
         */
        //终结波次更改器
        new waveRule("waveRule");

        new Buff加盾("Shield");
        new BuffHealth("Health");
        new BuffSpee("Speed");
        new BuffDmage("Damage");

        //地图墙,用于制作地图时使用
        new Wall("dt地图墙2"){{size=7;
            requirements(Category.defense, BuildVisibility.sandboxOnly,with(物品, 1));
        }};
        new Wall("dt地图墙") {
            {
                health = 100;
                size = 1;
                envEnabled = Env.any;
                targetable = false;//被单位攻击？
                requirements(Category.defense, BuildVisibility.sandboxOnly, with(
                        物品, 1
                ));
                buildType = Build::new;
                alwaysUnlocked = true;
            }

            class Build extends Wall.WallBuild {
                @Override
                public void damage(float damage) {

                }
            }
        };











        Wall 铜墙 = new CreatorTowerDefenseType.TDWall("dt铜墙", 1000);
        Wall 铅墙 = new CreatorTowerDefenseType.TDWall("dt铅墙", 1000);
        Wall 钛墙 = new CreatorTowerDefenseType.TDWall("dt钛墙", 2400){{armor=2;}};;
        Wall 钍墙 = new CreatorTowerDefenseType.TDWall("dt钍墙", 4000){{armor=5;}};;
        Wall 塑钢墙 = new CreatorTowerDefenseType.TDWall("dt塑钢墙", 6000){{armor=7;}};;
        Wall 布墙 = new CreatorTowerDefenseType.TDWall("dt布墙", 6000){{armor=7;}};;
        Wall 合金墙 = new CreatorTowerDefenseType.TDWall("dt合金墙", 20000){{armor=15;}};

        BlockDestroyReward.getInstance().apply()
                .add(铜墙, with(魂, 120))
                .add(铅墙, with(魂, 120,魄, 20))
                .add(钛墙, with(魂, 800, 魄, 70))
                .add(钍墙, with(魂, 1800, 魄, 140))
                .add(塑钢墙, with(魂, 7000))
                .add(布墙, with(魄, 9000))
                .add(合金墙, with(魂, 32000, 魄, 1200, 星辰, 30));
    }

}
