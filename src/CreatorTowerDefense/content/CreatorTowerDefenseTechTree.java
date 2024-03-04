package CreatorTowerDefense.content;

import arc.Core;
import mindustry.content.TechTree;
import mindustry.type.ItemStack;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseMaps.*;
import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;
import static CreatorTowerDefense.content.CreatorTowerDefensePower.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTurrets.*;
import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.CT3CoreBlocks.P5Core;


public class CreatorTowerDefenseTechTree {


    public static void load() {
        DTPlanet1.techTree = TechTree.nodeRoot(Core.bundle.format("CTTD"), P5Core, true, () -> {
            //地图
          //  addToTree(草原1, P5Core,null);

            //炮塔
            addToTree(双管1, P5Core, ItemStack.with(
                            魂, 1)
                    //, Seq.with(new Objectives.Research(筑基丹))
            );
            addToTree(双管2, 双管1, ItemStack.with(
                            魂, 200)
            );
            addToTree(双管3, 双管2, ItemStack.with(
                            魂, 1000,魄,300)
            );
            //电力
            addToTree(节点小, P5Core, ItemStack.with(
                    魂, 10)
            );
            addToTree(节点大, 节点小, ItemStack.with(
                    魂, 25000,魄,3500,星辰,50)
            );
        });
    }
}
