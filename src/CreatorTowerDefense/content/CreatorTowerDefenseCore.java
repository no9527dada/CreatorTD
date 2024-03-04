package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.type.CT3UnitType;
import ct.Asystem.type.CTCoreBlock;
import mindustry.ai.types.BuilderAI;
import mindustry.type.Category;
import mindustry.type.UnitType;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.星辰;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefenseCore {
    public static Block DTcore0, DTcore1, DTcore2;
    public static UnitType 核心机1;
    public static void load() {
        核心机1 = new CT3UnitType.CTR1UnitType("CoreUnit", "gamma") {{
            localizedName = "初号机";
            description = "";
            aiController = BuilderAI::new;
            isEnemy = false;
            lowAltitude = true;
            flying = true;
           // mineSpeed = 3f;
           // mineTier = 1;
            buildSpeed = 1f;
            drag = 0.05f;
            speed = 5f;
            rotateSpeed = 15f;
            accel = 0.1f;
            itemCapacity = 30;
            health = 100f;
            hitSize = 8f;
            alwaysUnlocked = true;
            mineRange = 0f;//采矿范围
            hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            physics = false;//单位碰撞
            lightColor = Color.valueOf("ffcd35");
            ammoType = new ItemAmmoType(魂);
            lightOpacity = 1;
            coreUnitDock = true;
            envDisabled = 0;
            engineOffset = 7.5f;
            engineSize = 3.4f;
            setEnginesMirror(
                    new UnitEngine(35 / 4f, -13 / 4f, 2.7f, 315f),
                    new UnitEngine(28 / 4f, -35 / 4f, 2.7f, 315f)
            );
        }};
        DTcore0 = new CTCoreBlock("DTcore0") {{
            requirements(Category.effect, with(星辰, 10));
            alwaysUnlocked = true;
            incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
            isFirstTier = false;//核心地板限制
            unitType = 核心机1;
            health = 200;
            itemCapacity = 9999999;
            size = 5;
            unitCapModifier = 0;
            requiresCoreZone = true;//需要特定地板

        }};
    }
}
