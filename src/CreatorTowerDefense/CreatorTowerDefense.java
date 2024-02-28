package CreatorTowerDefense;


import CreatorTowerDefense.content.*;
import mindustry.mod.Mod;
//主类
public class CreatorTowerDefense  extends Mod {
    public void loadContent() {
        CreatorTowerDefenseTerrain.load();//地形
        CreatorTowerDefenseItems.load();//资源
        CreatorTowerDefenseCore.load();//核心
        CreatorTowerDefenseUnits.load();//单位
        CreatorTowerDefenseTurrets.load();//炮塔
        CreatorTowerDefensePlanet.load();//星球
        //CreatorTowerDefenseMaps.load();//地图
       // CreatorTowerDefenseTechTree.load();//科技树
    }
}
