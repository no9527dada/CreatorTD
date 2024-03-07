package CreatorTowerDefense.content;

import arc.Core;
import mindustry.content.Blocks;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;

import static CreatorTowerDefense.content.CreatorTowerDefenseType.*;

//地形
public class CreatorTowerDefenseTerrain {
    public static Block TD地板a
            ;

    public static void load() {
        new TDFloor("TD地板1");
        TD地板a= new Floor("TD地板a"){{
            variants = 0;
            localizedName = Core.bundle.getOrNull("block.Floor");
        }};

    }
}