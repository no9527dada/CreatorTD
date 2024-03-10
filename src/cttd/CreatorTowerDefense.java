package cttd;


import cttd.content.*;
import mindustry.Vars;
import mindustry.mod.Mod;
//主类
public class CreatorTowerDefense  extends Mod {
   public CreatorTowerDefense(){
      Vars.mods.locateMod("creators3_TD").meta.version += "----" +  "[violet]创世神3-塔防[]";
   }
    public void loadContent() {
        //测试.load();
       CreatorTowerDefenseTerrain.load();//地形
       CreatorTowerDefenseItems.load();//资源
       CreatorTowerDefenseCore.load();//核心
       CreatorTowerDefenseUnits.load();//单位
       CreatorTowerDefenseBlocks.load();//墙 单位工厂
       CreatorTowerDefenseTurrets.load();//炮塔
       CreatorTowerDefensePower.load();//电力
       CreatorTowerDefenseSandbox.load();
       CreatorTowerDefensePlanet.load();//星球
       CreatorTowerDefenseMaps.load();//地图
       CreatorTowerDefenseTechTree.load();//科技树
    }
}
