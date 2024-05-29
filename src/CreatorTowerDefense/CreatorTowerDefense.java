package CreatorTowerDefense;


import CreatorTowerDefense.content.*;
import mindustry.Vars;
import mindustry.mod.Mod;

//主类
public class CreatorTowerDefense extends Mod {
    /*   public CreatorTowerDefense(){
          Vars.mods.locateMod("cttd").meta.version += "----" +  "[violet]创世神3-塔防[]";
       }*/

    public void loadContent() {
        if(/*Vars.mods.getMod("ct")!=null||*/Vars.mods.locateMod("ct") !=null) {
            CreatorTowerDefenseTerrain.load();//地形
            CreatorTowerDefenseItems.load();//资源
            CreatorTowerDefenseCore.load();//核心
            CreatorTowerDefenseUnits.load();//单位A
            // CreatorTowerDefenseUnits2.load();//单位B
            // UnitDeathReward.load();//资源掉落
            CreatorTowerDefenseBlocks.load();//墙 单位工厂
            CreatorTowerDefenseTurrets.load();//炮塔
            CreatorTowerDefensePower.load();//电力
            CreatorTowerDefenseSandbox.load();
            CreatorTowerDefensePlanet.load();//星球
            CreatorTowerDefenseMaps.load();//地图
            CreatorTowerDefenseTechTree.load();//科技树
            CTTDModJS.DawnMods();//JS加载器
        }
    }
    @Override
    public void init() {
        if(Vars.mods.locateMod("ct") ==null){
            CreatorTowerDefenseInfoDialog.show();
        }
    }
}