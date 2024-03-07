package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;

public class CreatorTowerDefenseMaps {
    public static SectorPreset 草原1,草原2,
            战役;

    public static void load() {

     草原1 = new SectorPreset("TD草原1",DTPlanet1, 0) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 31;//始终要比地图中设置的终结波次要+1
            difficulty = 1;
         localizedName = Core.bundle.format("maps.TD草原1");
        }};
        草原2 = new SectorPreset("TD草原2",DTPlanet1, 2) {{
            captureWave = 80;//始终要比地图中设置的终结波次要+1
            difficulty = 1;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原2");
        }};
    }
}
