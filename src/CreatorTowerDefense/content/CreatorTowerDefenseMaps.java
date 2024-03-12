package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;

public class CreatorTowerDefenseMaps {
    public static SectorPreset TD教程,草原1,草原2,草原3,草原4,
           fhgf ;

    public static void load() {
        TD教程 = new SectorPreset("TD教程",DTPlanet1, 92) {{
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
        草原2 = new SectorPreset("TD草原2",DTPlanet1, 96) {{
            captureWave = 51;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原2");
        }};
        草原3 = new SectorPreset("TD草原3",DTPlanet1, 95) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原3");
        }};
        草原4= new SectorPreset("TD草原4",DTPlanet1, 94) {{
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原4");
        }};
      /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 93) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 178) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 32) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 154) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 33) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 160) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 34) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 166) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 35) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 172) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 36) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 16) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 177) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 155) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 12) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 153) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 161) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        哈哈= new SectorPreset("TD哈哈",DTPlanet1, 13) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};

*/
    }
}