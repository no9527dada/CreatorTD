package CreatorTowerDefense;


import CreatorTowerDefense.content.*;
import mindustry.mod.Mod;
//主类
public class CreatorTowerDefense  extends Mod {
    public void loadContent() {
        CreatorTowerDefenseTerrain.load();//地形
        CreatorTowerDefenseItems.load();//资源
        CreatorTowerDefenseCore.load();//核心
        CreatorTowerDefenseWall.load();//墙
        CreatorTowerDefenseUnits.load();//单位
        CreatorTowerDefensePower.load();
        CreatorTowerDefenseTurrets.load();//炮塔
        CreatorTowerDefensePlanet.load();//星球
        CreatorTowerDefenseMaps.load();//地图
        CreatorTowerDefenseTechTree.load();//科技树
    }
}
