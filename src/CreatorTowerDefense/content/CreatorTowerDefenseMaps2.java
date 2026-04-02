package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;

//PlanetDialog.debugSelect = true;调试模式
public class CreatorTowerDefenseMaps2 {
    public static SectorPreset 挑战1,挑战2,挑战3,挑战4,挑战5,挑战6,挑战7,挑战8,挑战9,挑战10;
    public static void load() {

        挑战1= new SectorPreset("首领战盐碱地1",DTPlanet1, 22) {{
            captureWave = 30;//始终要比地图中设置的终结波次要+1
            difficulty = 3;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.挑战1");
        }};
        挑战2= new SectorPreset("首领战红地2",DTPlanet1, 214) {{
            captureWave = 50;//始终要比地图中设置的终结波次要+1
            difficulty =3;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.挑战2");
        }};
         挑战3= new SectorPreset("首领战红地3",DTPlanet1, 213) {{
            captureWave = 45;//始终要比地图中设置的终结波次要+1
            difficulty = 3;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.挑战3");
        }};
         挑战4= new SectorPreset("首领战红地4",DTPlanet1, 212) {{
            captureWave = 70;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.挑战4");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 217) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 39) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 100) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 40) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 221) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 86) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};

            */













    }
}
