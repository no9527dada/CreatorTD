package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet1;
//PlanetDialog.debugSelect = true;调试模式
public class CreatorTowerDefenseMaps {
    public static SectorPreset TD教程,草原1,草原2,草原3,草原4,草原5,红地6,红地7,红地8,红地9,碧云10,镀银11,
            湖泊12,雪地13,雪地14,红冰15,草原16,碧云17,雪地18,森林19,菌湖20,紫湖21,紫湖22,黄地23,梦幻24,泥地25,
            红地26,迷幻27,灰域28,草原29,红冰30,沙漠31,雪原32,星浮33,浮星34,黑域35,黑域36,黑沙37,
           fhgf ;
    public static SectorPreset 交错10_1,次元壁10_2;
    public static SectorPreset 黑石28_1,孢地28_2;
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
            localizedName = Core.bundle.format("maps.TD碧云10");//TD次元壁10-2
        }};
        交错10_1= new SectorPreset("TD交错10-1",DTPlanet1, 171) {{//81 130 170 210
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD交错10-1");
        }};
        次元壁10_2= new SectorPreset("TD次元壁10-2",DTPlanet1, 179) {{//81 130 170 210
            captureWave = 121;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD交错10-1");
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
       雪地18= new SectorPreset("TD雪地18",DTPlanet1, 155) {{//61-BOSS 120 180-BOSS 250-BOSS 1000
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD雪地18");
        }};
       森林19= new SectorPreset("TD森林19",DTPlanet1, 12) {{
            captureWave = 91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD森林19");
        }};
        菌湖20= new SectorPreset("TD菌湖20",DTPlanet1, 153) {{//81 130-boss 190-boss
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD菌湖20");
        }};
        紫湖21= new SectorPreset("TD紫湖21",DTPlanet1, 161) {{
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD紫湖21");
        }};
        紫湖22= new SectorPreset("TD紫湖22",DTPlanet1, 13) {{
            captureWave = 121;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD紫湖22");
        }};
        黄地23= new SectorPreset("TD黄地23",DTPlanet1, 159) {{
            captureWave = 91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD黄地23");
        }};
            梦幻24= new SectorPreset("TD梦幻24",DTPlanet1, 167) {{
            captureWave = 141;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD梦幻24");
        }};
          泥地25= new SectorPreset("TD泥地25",DTPlanet1, 162) {{
            captureWave = 51;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD泥地25");
        }};

          红地26= new SectorPreset("TD红地26",DTPlanet1, 180) {{
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红地26");
        }};
          迷幻27= new SectorPreset("TD迷幻27",DTPlanet1, 181) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD迷幻27");
        }};
        灰域28= new SectorPreset("TD灰域28",DTPlanet1, 176) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD灰域28");
        }};
        黑石28_1= new SectorPreset("TD黑石28-1",DTPlanet1, 152) {{
            captureWave =91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD黑石28-1");
        }};
        孢地28_2= new SectorPreset("TD孢地28-2",DTPlanet1, 81) {{
            captureWave =91;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD孢地28-2");
        }};

        草原29= new SectorPreset("TD草原29",DTPlanet1, 91) {{
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD29草原");
        }};
            红冰30= new SectorPreset("TD红冰30",DTPlanet1, 156) {{
            captureWave = 51;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD红冰30");
        }};
        沙漠31= new SectorPreset("TD沙漠31",DTPlanet1, 157) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD沙漠31");
        }};
        雪原32= new SectorPreset("TD雪原32",DTPlanet1, 158) {{
            captureWave = 81;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD雪原32");
        }};
           星浮33= new SectorPreset("TD星浮33",DTPlanet1, 163) {{
            captureWave = 61;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD星浮33");
        }};
           浮星34= new SectorPreset("TD浮星34",DTPlanet1, 52) {{
            captureWave = 71;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD浮星34");
        }};
            黑域35= new SectorPreset("TD黑域35",DTPlanet1, 168) {{
            captureWave = 121;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD黑域35");
        }};
            黑域36= new SectorPreset("TD黑域36",DTPlanet1, 14) {{
            captureWave = 101;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD黑域36");
        }};


        //38解锁噬魂单位
           黑沙37= new SectorPreset("TD黑沙37",DTPlanet1, 165) {{
            captureWave = 201;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD黑沙37");
        }};
            /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 173) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
            /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 15) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
    /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 170) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
           /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 63) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
        */






















           /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 22) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 214) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 213) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
        }};
                   /*  哈哈= new SectorPreset("TD哈哈",DTPlanet1, 212) {{
            captureWave = 哈哈;//始终要比地图中设置的终结波次要+1
            difficulty = 7;
            addStartingItems = true;
            localizedName = Core.bundle.format("maps.TD哈哈");
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
