package CreatorTowerDefense.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.environment.OreBlock;

import static ct.content.ItemX.物品;

//方块
public class CreatorTowerDefenseItems {
    public static final Seq<Item>
            CreatorTowerDefenseItems显示 = new Seq<>();
    public static OreBlock xgdh;
    public static Item
    魄, 魂,星辰,星越星辰,无尽星辰;

    public static Liquid 制冷剂;
    public static void load() {
        魂 = new Item("魂", Color.valueOf("9bccfe"));
        魄 = new Item("魄", Color.valueOf("fb7069"));
        星辰 =new Item("星辰", Color.valueOf("e187ff")) {{
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        星越星辰 = new Item("星越星辰", Color.valueOf("cc3dfb"))
        {{
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        无尽星辰 = new Item("无尽星辰", Color.valueOf("cc3dfb"))
        {{
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        CreatorTowerDefenseItems显示.addAll(
                物品,魄, 魂,星辰,星越星辰,无尽星辰
        );
        制冷剂 = new Liquid("cryofluid", Color.valueOf("6ecdec")){{
            heatCapacity = 0.9f;
            temperature = 0.25f;
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("c1e8f5");
        }};

    }
}