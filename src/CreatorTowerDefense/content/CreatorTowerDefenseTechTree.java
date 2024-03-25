package CreatorTowerDefense.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static CreatorTowerDefense.content.CreatorTowerDefenseBlocks.无限;
import static CreatorTowerDefense.content.CreatorTowerDefenseCore.DTcore0;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseMaps.*;
import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;
import static CreatorTowerDefense.content.CreatorTowerDefensePower.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTurrets.*;
import static CreatorTowerDefense.content.Sundry.光圈.*;
import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.ItemX.物品;


public class CreatorTowerDefenseTechTree {
    public static void load() {
        DTPlanet1.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree"), DTcore0, true, () -> {
            //地图
            addToTree(草原1, DTcore0, null);
            addToTree(TD教程, 草原1, null);
            addToTree(草原2, 草原1, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(草原3, 草原2, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(草原4, 草原3, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(草原5, 草原4, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(红地6, 草原5, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(红地7, 红地6, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(红地8, 红地7, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(红地9, 红地8, ItemStack.with(
                    星越星辰, 1)
            );
            //炮塔
            addToTree(双管1, DTcore0, ItemStack.with(
                            星辰, 1)
                    //, Seq.with(new Objectives.Research(XXX))//研究资源或方块
            );
            addToTree(双管2, 双管1, ItemStack.with(
                            星辰, 1000), Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(双管3, 双管2, ItemStack.with(
                            星辰, 4300, 星越星辰, 5), Seq.with(
                            new Objectives.SectorComplete(草原4)
                    )
            );
            addToTree(黏黏炮1, DTcore0, ItemStack.with(
                            星辰, 1700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原4)
                    )
            );
            addToTree(黏黏炮2, 黏黏炮1, ItemStack.with(
                            星辰, 3200, 星越星辰, 6), Seq.with(
                            new Objectives.SectorComplete(红地8)
                    )
            );
            addToTree(光圈1, DTcore0, ItemStack.with(
                            星辰, 1700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(红地6)
                    )
            );
            addToTree(激光炮1, DTcore0, ItemStack.with(
                            星辰, 2000, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(红地9)
                    )
            );
            addToTree(蓝瑟1, DTcore0, ItemStack.with(
                            星辰, 700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(蓝瑟2, 蓝瑟1, ItemStack.with(
                            星辰, 2800, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(无限, DTcore0, ItemStack.with(
                            星辰, 2000, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原2)
                    )
            );

            //电力
            addToTree(节点小, DTcore0, ItemStack.with(
                    星辰, 1)
            );
            addToTree(节点大, 节点小, ItemStack.with(
                    星辰, 3300, 星越星辰, 4),Seq.with(
                            new Objectives.SectorComplete(红地6)
                    )
            );
            addToTree(初始电力产生器, 节点小, ItemStack.with(
                    星辰, 1)
            );
            addToTree(电力产生器, 初始电力产生器, ItemStack.with(
                            星辰, 1800, 星越星辰, 3),
                    Seq.with(
                            new Objectives.SectorComplete(草原4)
                    )
            );

        });
    }
}
