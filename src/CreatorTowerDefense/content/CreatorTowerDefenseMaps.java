package CreatorTowerDefense.content;

import ct.content.chapter1.Planet1;
import mindustry.type.SectorPreset;

import static mindustry.content.Planets.serpulo;

public class CreatorTowerDefenseMaps {
    public static SectorPreset 草原1,
            战役;

    public static void load() {

     草原1 = new SectorPreset("草原1", Planet1.Planet1, 1) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};

    }
}
