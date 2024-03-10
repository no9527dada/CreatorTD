package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;

public class CreatorTowerDefenseMaps {
    public static SectorPreset TD教程,草原1,草原2,草原3,
           fhgf ;

    public static void load() {
        TD教程 = new SectorPreset("TD教程",DTPlanet1, 1) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 2;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            localizedName = Core.bundle.format("maps.TD教程");
        }};
     草原1 = new SectorPreset("TD草原1",DTPlanet1, 0) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 31;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
         localizedName = Core.bundle.format("maps.TD草原1");
        }};
        草原2 = new SectorPreset("TD草原2",DTPlanet1, 2) {{
            captureWave = 51;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原2");
        }};
        草原3 = new SectorPreset("TD草原3",DTPlanet1, 3) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原3");
        }};
    }
}
