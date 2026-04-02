package CreatorTowerDefense.content2;

import CreatorTowerDefense.content.CreatorTowerDefenseType;
import mindustry.ai.types.GroundAI;
import mindustry.type.UnitType;

public class CreatorTowerDefenseTowUnits {
    public static UnitType TD2尖刀;
    public static void load() {
        TD2尖刀 = new CreatorTowerDefenseType.TD2UnitType("dt2尖刀", 100, 0.25f) {{
            hitSize = 8f;description="";

        }};
    }
}
