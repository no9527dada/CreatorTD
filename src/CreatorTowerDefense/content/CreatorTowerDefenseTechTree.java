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
import static CreatorTowerDefense.content.CreatorTowerDefenseMaps2.*;
import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;
import static CreatorTowerDefense.content.CreatorTowerDefensePower.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseTurrets.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.*;
import static CreatorTowerDefense.content.Sundry.光圈.*;
import static CreatorTowerDefense.content.Sundry.光圈.光圈3;
import static CtCoreSystem.CoreSystem.type.CTTechTree.addToTree;


public class CreatorTowerDefenseTechTree {
    public static void load() {
        DTPlanet1.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree"), DTcore0, true, () -> {
            //地图
            addToTree(草原1, DTcore0, null);
            addToTree(TD教程, 草原1, null, Seq.with(
                    new Objectives.SectorComplete(草原1)
            ));
            addToTree(草原2, 草原1, ItemStack.with(
                    星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(草原1)
                    )
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
            addToTree(交错10_1, 碧云10, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(次元壁10_2, 交错10_1, ItemStack.with(
                    星越星辰, 1),
                    Seq.with(new Objectives.SectorComplete(交错10_1))
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
                    星越星辰, 1),
                    Seq.with(new Objectives.Research(魔力石墙))
            );
            addToTree(碧云17, 草原16, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(雪地18, 碧云17, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(森林19, 雪地18, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(菌湖20, 森林19, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(紫湖21, DTcore0, ItemStack.with(
                    星越星辰, 1),
                    Seq.with(new Objectives.Research(菌湖20))
            );
            addToTree(紫湖22, 紫湖21, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(黄地23, 紫湖22, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(梦幻24, 黄地23, ItemStack.with(
                       星越星辰, 1)
            );
            addToTree(泥地25, 梦幻24, ItemStack.with(
                       星越星辰, 1)
            );
            addToTree(红地26, 泥地25, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(迷幻27, 红地26, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(灰域28, 迷幻27, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(草原29, 灰域28, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(黑石28_1, 灰域28, ItemStack.with(//支线1
                            星越星辰, 1),
                    Seq.with(//Research
                            new Objectives.SectorComplete(灰域28)
                    )
            );
            addToTree(孢地28_2, 黑石28_1, ItemStack.with(//支线2
                    星越星辰, 1)
            );
            addToTree(红冰30, 草原29, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(沙漠31, DTcore0, ItemStack.with(
                    星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(红冰30)
                    )
            );
            addToTree(雪原32, 沙漠31, ItemStack.with(
                            星越星辰, 1)
            );
            addToTree(星浮33, 雪原32, ItemStack.with(
                            星越星辰, 1)
            );
            addToTree(浮星34, 星浮33, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(黑域35, 浮星34, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(黑域36, 黑域35, ItemStack.with(
                    星越星辰, 1)
            );
            addToTree(黑沙37, 黑域36, ItemStack.with(
                    星越星辰, 1)
            );























            addToTree(挑战1, DTcore0, ItemStack.with(
                    星越星辰, 1), Seq.with(
                    Seq.with(new Objectives.Research(双管2))
                    )
            );
            addToTree(挑战2, 挑战1, ItemStack.with(
                            星越星辰, 1), Seq.with(
                    Seq.with(new Objectives.SectorComplete(草原5))
                    )
            );
            addToTree(挑战3, 挑战2, ItemStack.with(
                            星越星辰, 1), Seq.with(
                            Seq.with(new Objectives.SectorComplete(红地6))
                    )
            );
            addToTree(挑战4, 挑战3, ItemStack.with(
                            星越星辰, 1), Seq.with(
                            Seq.with(new Objectives.SectorComplete(红地9))
                    )
            );



























            addToTree(双管1, DTcore0, ItemStack.with(
                            星辰, 1)
                    //, Seq.with(new Objectives.Research(XXX))//研究资源或方块
            );
            addToTree(双管2, 双管1, ItemStack.with(
                            星辰, 1000, 星越星辰, 1), Seq.with(//
                            new Objectives.SectorComplete(草原1)
                    )
            );
            addToTree(双管3, 双管2, ItemStack.with(
                            星辰, 5600, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(红地7)
                    )
            );
            addToTree(双管4, 双管3, ItemStack.with(
                            星辰, 8000, 星越星辰, 3,无尽星辰,1), Seq.with(
                            new Objectives.SectorComplete(迷幻27)
                    )
            );
            addToTree(双管5, 双管4, ItemStack.with(
                            星辰, 10000, 星越星辰, 5,无尽星辰,3), Seq.with(
                            new Objectives.SectorComplete(黑沙37)
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
            addToTree(光圈3, 光圈2, ItemStack.with(
                            星辰, 5200, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(浮星34)
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
            );
            addToTree(激光炮3, 激光炮2, ItemStack.with(
                            星辰, 2300, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(黑域36)
                    )
            );
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
            addToTree(地刺塔, 钉刺塔, ItemStack.with(
                            星辰, 4500, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原29)
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
                            星辰, 4300, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(湖泊12)
                    )
            );
            addToTree(蓝瑟4, 蓝瑟3, ItemStack.with(
                            星辰, 6000, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(黑域35)
                    )
            );
            addToTree(冰霜塔1, DTcore0, ItemStack.with(
                            星辰, 700, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原5)
                    )
            );
            addToTree(冰霜塔2, 冰霜塔1, ItemStack.with(
                            星辰, 3200, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(碧云10)
                    )
            );
            addToTree(冰霜塔3, 冰霜塔2, ItemStack.with(
                            星辰, 5300, 星越星辰, 5), Seq.with(
                            new Objectives.SectorComplete(菌湖20)
                    )
            );
           addToTree(霜冻塔2, 冰霜塔1, ItemStack.with(
                            星辰, 2500, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(交错10_1)
                    )
            );
            addToTree(霜冻塔3, 霜冻塔2, ItemStack.with(
                            星辰, 4600, 星越星辰, 4), Seq.with(
                            new Objectives.SectorComplete(次元壁10_2)
                    )
            );

            addToTree(火焰喷射器1, DTcore0, ItemStack.with(
                            星辰, 2400, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(湖泊12)
                    )
            );
            addToTree(火焰喷射器2, 火焰喷射器1, ItemStack.with(
                            星辰, 4500, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(紫湖21)
                    )
            );
            addToTree(火焰喷射器3, 火焰喷射器2, ItemStack.with(
                            星辰, 9500, 星越星辰, 5,无尽星辰,2), Seq.with(
                            new Objectives.SectorComplete(梦幻24)
                    )
            );
            addToTree(繁花1, DTcore0, ItemStack.with(
                            星辰, 2200, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(碧云17)
                    )
            );
            addToTree(繁花2, 繁花1, ItemStack.with(
                            星辰, 3500, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(沙漠31)
                    )
            );

            addToTree(厄运1, DTcore0, ItemStack.with(
                            星辰, 2500, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(森林19)
                    )
            );
            addToTree(厄运2, 厄运1, ItemStack.with(
                            星辰, 5200, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(灰域28)
                    )
            );
            addToTree(厄运3, 厄运2, ItemStack.with(
                            星辰, 8500, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(星浮33)
                    )
            );

            addToTree(厄梦2, 厄运1, ItemStack.with(
                            星辰, 5200, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(黑石28_1)
                    )
            );
            addToTree(厄梦3, 厄梦2, ItemStack.with(
                            星辰, 8500, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(孢地28_2),
                    new Objectives.Research(厄运3)
                    )
            );
            addToTree(熔毁1, DTcore0, ItemStack.with(
                            星辰, 3500, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(黄地23)
                    )
            );
            addToTree(熔毁2, 熔毁1, ItemStack.with(
                            星辰, 4200, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(雪原32)
                    )
            );


















            addToTree(无限, DTcore0, ItemStack.with(
                            星辰, 2000, 星越星辰, 2), Seq.with(
                            new Objectives.SectorComplete(草原2)
                    )
            );
         addToTree(魔力石墙, 无限, ItemStack.with(
                            星辰, 600, 星越星辰, 1), Seq.with(
                            new Objectives.SectorComplete(雪地14)
                    )
            );
/*         addToTree(修理, 魔力石墙, ItemStack.with(
                 星辰, 3200,星越星辰, 3, 无尽星辰, 1), Seq.with(
                            new Objectives.SectorComplete(TD泥地25)
                    )
            );*/

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
            addToTree(储电器, 节点大, ItemStack.with(
                            星辰, 5000, 星越星辰, 1),
                    Seq.with(
                            new Objectives.SectorComplete(红地26)
                    )
            );
            addToTree(放电器, 储电器, ItemStack.with(
                            星辰, 5000, 星越星辰, 3), Seq.with(
                            new Objectives.SectorComplete(红冰30)
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
            addToTree(四级点辉发电器, 三级极点发电器, ItemStack.with(
                            星辰, 4500, 星越星辰, 6),
                    Seq.with(
                            new Objectives.SectorComplete(紫湖22)
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
            addToTree(凝蓝单位工厂, 星灵单位工厂, ItemStack.with(
                            星辰, 2800, 星越星辰, 2),
                    Seq.with(
                            new Objectives.SectorComplete(雪地18)
                    )
            );
            addToTree(凝蓝单位, 凝蓝单位工厂, ItemStack.with(
                            星辰, 2200, 星越星辰, 4),
                    Seq.with(
                            new Objectives.SectorComplete(雪地18)
                    )
            );
        });
    }
}
