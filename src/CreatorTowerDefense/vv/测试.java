package CreatorTowerDefense.vv;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;

import static mindustry.type.Category.crafting;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.BlockGroup.transportation;

public class 测试 {
    public static Block 幻烬聚宝炉k;
    public static void load() {
        幻烬聚宝炉k = new GenericCrafter("幻烬聚宝炉k") {{
            consumeItems(with(Items.silicon, 5
            ));;
            outputItem = new ItemStack(Items.lead, 3);
            health = 160;
            itemCapacity = 20;
            size = 3;
            craftTime = 40;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    Items.lead,1
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
    }
}
