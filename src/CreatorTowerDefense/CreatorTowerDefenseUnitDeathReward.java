package CreatorTowerDefense;

import CtCoreSystem.CoreSystem.type.UnitDeathReward;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.*;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowUnits.TD2尖刀;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefenseUnitDeathReward {

    public static void load() {
        UnitDeathReward.getInstance().init()
                .add(U星辰, with(星越星辰, 1))
                .add(W星辰, with(无尽星辰, 1))
                .add(沙, with(魂, 1))
                .add(铜, with(魂, 1))
                .add(铅, with(魂, 1))
                .add(煤炭, with(魂, 2, 魄, 1))
                .add(玻璃, with(魂, 3, 魄, 1))
                .add(碳板, with(魂, 4, 魄, 3))
                .add(石墨, with(魂, 4, 魄, 2))
                .add(石墨烯, with(魂, 6, 魄, 2))
                .add(硅, with(魂, 2, 魄, 4))
                .add(硅晶体, with(魂, 4, 魄, 4))
                .add(石英, with(魂, 3, 魄, 2))
                .add(钛, with(魂, 10, 魄, 5))
                .add(硫化物, with(魂, 7, 魄, 3))
                .add(钍, with(魂, 13, 魄, 7))
                .add(塑钢, with(魂, 20, 魄, 9))
                .add(相织布, with(魂, 22, 魄, 8))
                .add(金, with(魂, 30, 魄, 7))
                .add(冷却液, with(魂, 35, 魄, 8, 星辰, 1))
                .add(液氮, with(魂, 75, 魄, 22, 星辰, 2))
                .add(紫晶, with(魂, 50, 魄, 15, 星辰, 2))
                .add(电池, with(魂, 45, 魄, 13, 星辰, 1))
                .add(钛合金, with(魂, 60, 魄, 18, 星辰, 2))
                .add(钻石, with(魂, 90, 魄, 25, 星辰, 3))
                //boss
                .add(巨浪合金, with(魂, 200, 魄, 80, 星辰, 40))
                .add(魔力石, with(魂, 150, 魄, 130, 星辰, 60))
                .add(微晶, with(魂, 500, 魄, 200, 星辰, 100))
                .add(粒子, with(魂, 10000, 魄, 10000, 星辰, 500,无尽星辰,5))
                .add(创世之星, with(魂, 50000, 魄, 50000, 星辰, 2000,无尽星辰,50))

                .add(爆混, with( 星越星辰, 1,星辰,500))
                .add(孢子荚, with( 星越星辰, 1,星辰,500))









                .add(TD2尖刀, with(TD蔚蓝星辰, 1))
        ;
    }
}
