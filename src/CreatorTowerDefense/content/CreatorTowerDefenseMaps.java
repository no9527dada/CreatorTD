package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;

public class CreatorTowerDefenseMaps {
    public static SectorPreset TD教程,草原1,草原2,草原3,草原4,草原5,红地6,红地7,红地8,红地9,碧云10,镀银11,
            湖泊12,雪地13,雪地14,红冰15,草原16,碧云17,
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
      草原5= new SectorPreset("TD草原5",DTPlanet1, 93) {{//共3阶段 91,140,180
            captureWave = 91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原5");
        }};
       红地6= new SectorPreset("TD红地6",DTPlanet1, 178) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红地6");
        }};
        红地7= new SectorPreset("TD红地7",DTPlanet1, 32) {{
            captureWave = 91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红地7");
        }};
         红地8= new SectorPreset("TD红地8",DTPlanet1, 154) {{//61,110,150,200,1000
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红地8");
        }};
       红地9= new SectorPreset("TD红地9",DTPlanet1, 33) {{
            captureWave = 181;//始终要比地图中设置的终结波次要+1
            difficulty = 15;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红地9");
        }};
        碧云10= new SectorPreset("TD碧云10",DTPlanet1, 160) {{//81 130 170 210
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD碧云10");
        }};
        镀银11= new SectorPreset("TD镀银11",DTPlanet1, 34) {{//91 180
            captureWave = 91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD镀银11");
        }};
        湖泊12= new SectorPreset("TD湖泊12",DTPlanet1, 166) {{//41 80
            captureWave = 41;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD湖泊12");
        }};
     雪地13= new SectorPreset("TD雪地13",DTPlanet1, 35) {{//71-BOSS 110-BOSS 140-BOSS
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD雪地13");
        }};
        雪地14= new SectorPreset("TD雪地14",DTPlanet1, 172) {{//60 100-BOSS 140-BOSS 180-BOSS 1000
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD雪地14");
        }};
      红冰15= new SectorPreset("TD红冰15",DTPlanet1, 36) {{//100 150-BOSS
            captureWave = 101;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红冰15");
        }};
        草原16= new SectorPreset("TD草原16",DTPlanet1, 16) {{//61 100
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD草原16");
        }};
        碧云17= new SectorPreset("TD碧云17",DTPlanet1, 177) {{//101 150-BOSS
            captureWave = 101;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD碧云17");
        }};
         /* 哈哈= new SectorPreset("TD哈哈",DTPlanet1, 155) {{
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
