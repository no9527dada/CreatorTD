package CreatorTowerDefense.content;

import ct.Asystem.type.BlockDestroyReward;
import mindustry.world.blocks.defense.Wall;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDWall;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseWall {

    public static void load() {
        Wall 铜墙 = new TDWall("dt铜墙",300);
        Wall 铅墙 = new TDWall("dt铅墙",300);
        Wall 钛墙 = new TDWall("dt钛墙",1000);
        Wall 钍墙 = new TDWall("dt钍墙",3000);
        Wall 塑钢墙 = new TDWall("dt塑钢墙",5000);
        Wall 布墙 = new TDWall("dt布墙",5000);
        Wall 合金墙 = new TDWall("dt合金墙",50000);

        BlockDestroyReward.getInstance().apply()
                . add(铜墙, with(魂, 30))
                . add(铅墙, with(魄, 8))
                . add(钛墙, with(魂, 300,魄, 70))
                . add(钍墙, with(魂, 500,魄, 140))
                . add(塑钢墙, with(魂, 1200))
                . add(布墙, with(魄, 500))
                . add(合金墙, with(魂, 5000,魄, 1200,星辰, 30));
    }
}