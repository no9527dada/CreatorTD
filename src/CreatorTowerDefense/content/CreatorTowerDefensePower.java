package CreatorTowerDefense.content;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.power.PowerNode;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefensePower {
    public static Block 节点小,节点大
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
           // consumeItem(Items.silicon).boost();
        }};

        节点小 = new PowerNode("power-node"){{
            requirements(Category.power, with(魂, 1));
            maxNodes = 5;
            laserRange = 9;
        }};
        节点大 = new PowerNode("power-node-large"){{
            requirements(Category.power, with(魂, 15, 魄, 5));
            size = 2;
            maxNodes = 30;
            laserRange = 25f;
        }};
    }
}
