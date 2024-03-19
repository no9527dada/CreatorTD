package CreatorTowerDefense.content;

import ct.Asystem.type.BlockDestroyReward;

import ct.Asystem.type.waveRule;
import mindustry.type.Category;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;

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
        new Wall("dt地图墙"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with(物品, 1));
        }};
        new Wall("dt地图墙2"){{size=7;
            requirements(Category.defense, BuildVisibility.sandboxOnly,with(物品, 1));
        }};












        Wall 铜墙 = new CreatorTowerDefenseType.TDWall("dt铜墙", 1000);
        Wall 铅墙 = new CreatorTowerDefenseType.TDWall("dt铅墙", 1000);
        Wall 钛墙 = new CreatorTowerDefenseType.TDWall("dt钛墙", 3000);
        Wall 钍墙 = new CreatorTowerDefenseType.TDWall("dt钍墙", 5000);
        Wall 塑钢墙 = new CreatorTowerDefenseType.TDWall("dt塑钢墙", 7000);
        Wall 布墙 = new CreatorTowerDefenseType.TDWall("dt布墙", 7000);
        Wall 合金墙 = new CreatorTowerDefenseType.TDWall("dt合金墙", 20000){{armor=15;}};

        BlockDestroyReward.getInstance().apply()
                .add(铜墙, with(魂, 50))
                .add(铅墙, with(魂, 50,魄, 20))
                .add(钛墙, with(魂, 500, 魄, 70))
                .add(钍墙, with(魂, 1200, 魄, 140))
                .add(塑钢墙, with(魂, 3000))
                .add(布墙, with(魄, 5000))
                .add(合金墙, with(魂, 25000, 魄, 1200, 星辰, 30));
    }

}
