package CreatorTowerDefense.content2;

import arc.Core;
import mindustry.type.SectorPreset;


import static CreatorTowerDefense.content2.CreatorTowerDefenseTow.塔防星球2;

public class CreatorTowerDefenseTowMaps {
    public static SectorPreset T;
    public static void load(){

        T=new SectorPreset("TD2-1",塔防星球2, 0) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 999999999;
            difficulty = 0;
            localizedName = Core.bundle.format("maps.TD2Maps");
        }};



    }
}
