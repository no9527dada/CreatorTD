package CreatorTowerDefense.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static CreatorTowerDefense.content.CreatorTowerDefenseBlocks.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseCore.DTcore0;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseMaps.*;
import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;
import static CreatorTowerDefense.content.CreatorTowerDefensePower.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTurrets.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.星尘单位;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.星灵单位;
import static CreatorTowerDefense.content.Sundry.光圈.*;
import static ct.Asystem.type.CTTechTree.addToTree;


public class CreatorTowerDefenseTechTree {
    public static void load() {
        DTPlanet1.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree"), DTcore0, true, () -> {
            //地图
            addToTree(草原1, DTcore0, null);
            addToTree(TD教程, 草原1, null, Seq.with(
                    new Objectives.SectorComplete(草原1)
            ));
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
            addToTree(碧云10, 红地9, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(镀银11, DTcore0, ItemStack.with(
                    星越星辰, 1),
                    Seq.with(new Objectives.Research(碧云10))
            );
            addToTree(湖泊12, 镀银11, ItemStack.with(
                            星越星辰, 1)
            );
            addToTree(雪地13, 湖泊12, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(雪地14, 雪地13, ItemStack.with(
                    星越星辰, 1)
            );
             addToTree(红冰15 , 雪地14, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(草原16, 红冰15, ItemStack.with(
                    星越星辰, 1), Seq.with(new Objectives.Research(魔力石墙))
            );
            addToTree(碧云17, 草原16, ItemStack.with(
                    星越星辰, 1)
            );
            //炮塔 湖泊12

            addToTree(双管1, DTcore0, ItemStack.with(
                            星辰, 1)
                    //, Seq.with(new Objectives.Research(XXX))//研究资源或方块
            );
            addToTree(双管2, 双管1, ItemStack.with(
                            星辰, 1000, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(双管3, 双管2, ItemStack.with(
                            星辰, 5600, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(红地7)
                    )
            );
            addToTree(黏黏炮1, DTcore0, ItemStack.with(
                            星辰, 1700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原3)
                    )
            );
            addToTree(黏黏炮2, 黏黏炮1, ItemStack.with(
                            星辰, 3200, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(红地9)
                    )
            );
            addToTree(光圈1, DTcore0, ItemStack.with(
                            星辰, 1700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(光圈2, 光圈1, ItemStack.with(
                            星辰, 3200, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(红地8)
                    )
            );
            addToTree(激光炮1, DTcore0, ItemStack.with(
                            星辰, 2000, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(红地8)
                    )
            );
            addToTree(激光炮2, 激光炮1, ItemStack.with(
                            星辰, 2300, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(雪地14)
                    )
            );//
            addToTree(钉钉塔, DTcore0, ItemStack.with(
                            星辰, 1500, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(草原4)
                    )
            );
            addToTree(钉刺塔, 钉钉塔, ItemStack.with(
                            星辰, 2000, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(红冰15)
                    )
            );
            addToTree(蓝瑟1, DTcore0, ItemStack.with(
                            星辰, 700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(蓝瑟2, 蓝瑟1, ItemStack.with(
                            星辰, 2800, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(红地6)
                    )
            );
            addToTree(蓝瑟3, 蓝瑟2, ItemStack.with(
                            星辰, 2800, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(湖泊12)
                    )
            );
            addToTree(冰霜塔1, DTcore0, ItemStack.with(
                            星辰, 700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(冰霜塔2, 冰霜塔1, ItemStack.with(
                            星辰, 4800, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(碧云10)
                    )
            );
            addToTree(火焰喷射器1, DTcore0, ItemStack.with(
                            星辰, 2400, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(湖泊12)
                    )
            );
            addToTree(繁花1, DTcore0, ItemStack.with(
                            星辰, 1800, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(碧云17)
                    )
            );
            addToTree(无限, DTcore0, ItemStack.with(
                            星辰, 2000, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原2)
                    )
            );
         addToTree(魔力石墙, DTcore0, ItemStack.with(
                            星辰, 600, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(雪地14)
                    )
            );
            //电力
            addToTree(节点小, DTcore0, ItemStack.with(
                    星辰, 1)
            );
            addToTree(电量查看器, 节点小, ItemStack.with(
                            星辰, 500), Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(节点大, 节点小, ItemStack.with(
                    星辰, 3300, 星越星辰, 3),Seq.with(
                            new Objectives.SectorComplete(红地7)
                    )
            );
            addToTree(初始电力产生器, 节点小, ItemStack.with(
                    星辰, 1)
            );
            addToTree(电力产生器, 初始电力产生器, ItemStack.with(
                            星辰, 1800, 星越星辰, 3),
                    Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(三级极点发电器, 电力产生器, ItemStack.with(
                            星辰, 3200, 星越星辰, 3),
                    Seq.with(
                            new Objectives.SectorComplete(草原16)
                    )
            );
            addToTree(初级魂魄凝练器, DTcore0, ItemStack.with(
                            星辰, 800, 星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(草原4)
                    )
            );
           addToTree(初级魂魄转换器, DTcore0, ItemStack.with(
                            星辰, 4000, 星越星辰, 2),
                    Seq.with(
                            new Objectives.SectorComplete(镀银11)
                    )
            );
            addToTree(星尘单位工厂, DTcore0, ItemStack.with(
                            星辰, 1000, 星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(红地6)
                    )
            );
            addToTree(星尘单位, 星尘单位工厂, ItemStack.with(
                            星辰, 500, 星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(红地6)
                    )
            );
            addToTree(星灵单位工厂, 星尘单位工厂, ItemStack.with(
                            星辰, 1500, 星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(雪地13)
                    )
            );
            addToTree(星灵单位, 星灵单位工厂, ItemStack.with(
                            星辰, 800, 星越星辰, 2),
                    Seq.with(
                            new Objectives.SectorComplete(雪地13)
                    )
            );
        });
    }
}
