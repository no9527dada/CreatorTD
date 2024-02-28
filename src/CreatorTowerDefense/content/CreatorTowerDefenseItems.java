package CreatorTowerDefense.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;
import mindustry.world.blocks.environment.OreBlock;

//方块
public class CreatorTowerDefenseItems {
    public static final Seq<Item>
            CreatorTowerDefenseItems显示 = new Seq<>();
    public static OreBlock xgdh;
    public static Item
    魄, 魂,星辰;

    public static void load() {
        魂 = new Item("魂", Color.valueOf("F5F5F5")) {{
            localizedName = "魂";
            description = "重写";
        }};
        魄 = new Item("魄", Color.valueOf("F5F5F5")) {{
            localizedName = "魄";
            description = "重写";
        }};
        星辰 =new Item("星辰", Color.valueOf("F5F5F5")) {{
            localizedName = "星辰";
            description = "重写";
        }};
        CreatorTowerDefenseItems显示.addAll(
                魄, 魂,星辰
        );
    }
}