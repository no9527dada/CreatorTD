package cttd.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static cttd.content.CreatorTowerDefenseBlocks.无限;
import static cttd.content.CreatorTowerDefenseCore.DTcore0;
import static cttd.content.CreatorTowerDefenseItems.*;
import static cttd.content.CreatorTowerDefenseMaps.*;
import static cttd.content.CreatorTowerDefensePlanet.DTPlanet1;
import static cttd.content.CreatorTowerDefensePower.*;
import static cttd.content.CreatorTowerDefenseTurrets.*;
import static ct.Asystem.type.CTTechTree.addToTree;


public class CreatorTowerDefenseTechTree {
    public static void load() {
        DTPlanet1.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree"), DTcore0, true, () -> {
            //地图
            addToTree(草原1, DTcore0,null);
            addToTree(草原2, 草原1,ItemStack.with(
                            星辰, 1),  Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(草原3, 草原2,ItemStack.with(
                            星辰, 1),  Seq.with(
                            new Objectives.SectorComplete(草原2)
                    )
            );
            //炮塔
            addToTree(双管1, DTcore0, ItemStack.with(
                            魂, 1)
                    //, Seq.with(new Objectives.Research(筑基丹))
            );
            addToTree(双管2, 双管1, ItemStack.with(
                            魂, 3000),  Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(无限, DTcore0, ItemStack.with(
                            魄,2000,星辰,1),  Seq.with(
                            new Objectives.SectorComplete(草原2)
                    )
            );
      /*      addToTree(双管3, 双管2, ItemStack.with(
                            魂, 1000,魄,300)
            );*/
            //电力
            addToTree(节点小, DTcore0, ItemStack.with(
                    魂, 10)
            );
      /*      addToTree(节点大, 节点小, ItemStack.with(
                    魂, 25000,魄,3500,星辰,50)
            );*/
            addToTree(初始电力产生器, 节点小, ItemStack.with(
                    魂, 10)
            );
  /*          addToTree(电力产生器, 初始电力产生器, ItemStack.with(
                    魂, 10),
                    Seq.with(
                              new Objectives.SectorComplete(草原1)
                    )
            );*/

        });
    }
}
