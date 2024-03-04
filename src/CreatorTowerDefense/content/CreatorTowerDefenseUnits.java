package CreatorTowerDefense.content;

import ct.Asystem.type.UnitDeathReward;
import mindustry.entities.abilities.*;
import mindustry.type.StatusEffect;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDUnitType;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseUnits {
    //public static TDUnitType

    public static void load() {


        TDUnitType U星辰 = new TDUnitType("dt星辰", 0, 30, 3f);//奖励单位，没有伤害
        TDUnitType 沙 = new TDUnitType("dt沙", 1, 10, 0.5f);
        TDUnitType 铜 = new TDUnitType("dt铜", 1, 20, 0.5f);
        TDUnitType 铅 = new TDUnitType("dt铅", 1, 10, 1.5f);
        TDUnitType 煤炭 = new TDUnitType("dt煤炭", 1, 30, 0.5f);
        TDUnitType 石英 = new TDUnitType("dt石英", 2, 30, 0.5f) {{
            abilities.add(new SpawnDeathAbility(沙, 1, 8));
        }};
        TDUnitType 玻璃 = new TDUnitType("dt玻璃", 2, 35, 0.8f) {{
            abilities.add(new SpawnDeathAbility(铅, 1, 8));
        }};
        TDUnitType 石墨 = new TDUnitType("dt石墨", 2, 40, 0.5f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 1, 8));
        }};
        TDUnitType 碳板 = new TDUnitType("dt碳板", 2, 50, 0.35f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 1, 8));
        }};
        TDUnitType 硅 = new TDUnitType("dt硅", 3, 30, 2.5f);
        TDUnitType 石墨烯 = new TDUnitType("dt石墨烯", 3, 80, 0.75f) {{
            abilities.add(new SpawnDeathAbility(石墨, 1, 8));
        }};
        TDUnitType 硫化物 = new TDUnitType("dt硫化物", 3, 150, 0.3f) {{
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
        }};
        TDUnitType 硅晶体 = new TDUnitType("dt硅晶体", 4, 220, 0.5f) {{
            abilities.add(new RepairFieldAbility(20f, 60f * 2, 4 * 8f));
        }};//加血
        TDUnitType 钛 = new TDUnitType("dt钛", 4, 200, 0.5f) {{
            abilities.add(new ForceFieldAbility(3 * 8f, 4f, 50f, 60f * 8, 8, 0f));
        }};//力场
        TDUnitType 钍 = new TDUnitType("dt钍", 5, 500, 0.3f) {{
            abilities.add(new UnitSpawnAbility(石墨烯, 60 * 15, 0, 0));
        }};//生产单位
        TDUnitType 塑钢 = new TDUnitType("dt塑钢", 5, 300, 0.5f) {{
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiaxue") {{
                healthMultiplier = 1.5f;//血量倍率
            }}, 60f * 3, 60f * 6f, 4 * 8f));
        }};
        TDUnitType 相织布 = new TDUnitType("dt相织布", 6, 240, 0.5f) {{
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiasu") {{
                speedMultiplier = 2f;//移速
            }}, 60f * 10, 60f * 6f, 4 * 8f));
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
        }};
        TDUnitType 金 = new TDUnitType("dt金", 8, 330, 0.2f) {{
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiasu2") {{
                speedMultiplier = 20f;//移速
            }}, 60f * 5, 90f * 60f, 1f));
            abilities.add(new SpawnDeathAbility(钍, 1, 8));
        }};
        TDUnitType 巨浪合金 = new TDUnitType("dt巨浪合金", 10, 5000, 0.3f);
        TDUnitType 电池 = new TDUnitType("dt电池", 10, 2500, 1f);
        TDUnitType 钛合金 = new TDUnitType("dt钛合金", 15, 8000, 0.3f);
        TDUnitType 钻石 = new TDUnitType("dt钻石", 20, 11000, 0.3f);
        TDUnitType 魔力石 = new TDUnitType("dt魔力石", 30, 3000, 0.3f){{armor=15;}};
        TDUnitType 微晶 = new TDUnitType("dt微晶", 50, 20000, 0.2f){{
            abilities.add(
                    new UnitSpawnAbility(石英, 60 * 2, 0, 0),
                    new UnitSpawnAbility(钍, 60 * 5, 0, 0),
                    new UnitSpawnAbility(钛, 60 * 15, 0, 0));
        }};//生产单位;


        UnitDeathReward.getInstance().init()
                .add(沙, with(魂, 1))
                .add(铜,  with(魂, 1))
                .add(铅, with(魂, 1))
                .add(煤炭, with(魂, 2,魄, 1))
                .add(玻璃, with(魂, 3,魄, 1))
                .add(碳板, with(魂, 4,魄, 3))
                .add(石墨, with(魂, 4,魄, 2))
                .add(石墨烯, with(魂, 6,魄, 2))
                .add(硅, with(魂, 2,魄, 4))
                .add(硅晶体, with(魂, 4,魄, 4))
                .add(石英, with(魂, 3,魄, 2))
                .add(钛, with(魂, 10,魄, 5))
                .add(硫化物, with(魂, 7,魄, 3))
                .add(钍, with(魂, 13,魄, 7))
                .add(塑钢, with(魂, 5,魄, 20))
                .add(相织布, with(魂, 5,魄, 20))
                .add(金, with(魂, 30,魄, 30))
                //boss
                .add(巨浪合金, with(魂, 200,魄, 80,星辰, 10))
                .add(电池, with(魂, 150,魄, 50,星辰, 10))
                .add(钛合金, with(魂, 230,魄, 95,星辰, 20))
                .add(钻石, with(魂, 240,魄, 120,星辰, 25))
                .add(魔力石, with(魂, 150,魄, 130,星辰, 20))
                .add(微晶, with(魂, 500,魄, 200,星辰, 50))
                .add(U星辰, with(星辰, 3));

    }
}