package CreatorTowerDefense.content;

import arc.Core;
import mindustry.content.TechTree;
import mindustry.type.SectorPreset;

import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet;
import static ct.content.CT3CoreBlocks.P5Core;



public class CreatorTowerDefenseTechTree {
    public static float TechTrees5倍率 = 1;

    public static void load() {
        DTPlanet.techTree = TechTree.nodeRoot(Core.bundle.format("Planet55"), P5Core, true, () -> {
            SectorPreset mull5 = new SectorPreset("mull5", DTPlanet, 100) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
            }};



        });
    }
}
