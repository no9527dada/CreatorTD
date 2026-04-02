package CreatorTowerDefense;


import CreatorTowerDefense.content.*;
import CreatorTowerDefense.content2.CreatorTowerDefenseTow;
import CreatorTowerDefense.content2.CreatorTowerDefenseTowUnits;
import mindustry.Vars;
import mindustry.mod.Mod;

import static CtCoreSystem.CoreSystem.compareVersions.compareVersions;

//主类
public class CreatorTowerDefense extends Mod {
    /*   public CreatorTowerDefense(){
          Vars.mods.locateMod("cttd").meta.version += "----" +  "[violet]创世神3-塔防[]";
       }*/
    static String  MinVersion="1.28";
    public void loadContent() {
        if((Vars.mods.locateMod("ctcoresystem")!=null) ){
            if(compareVersions(Vars.mods.getMod("ctcoresystem").meta.version, MinVersion)>=0 ) {
                CreatorTowerDefenseTerrain.load();//地形
                CreatorTowerDefenseItems.load();//资源
                CreatorTowerDefenseBuff.load();
                CreatorTowerDefenseCore.load();//核心
                CreatorTowerDefenseUnits.load();//单位A
                CreatorTowerDefenseTowUnits.load();//单位B

                // UnitDeathReward.load();//资源掉落
                CreatorTowerDefenseBlocks.load();//墙 单位工厂
                CreatorTowerDefenseTurrets.load();//炮塔
                CreatorTowerDefensePower.load();//电力
                CreatorTowerDefenseUnitDeathReward.load();//单位死亡掉落资源
                CreatorTowerDefenseSandbox.load();
                if(Vars.mods.locateMod("creators")==null){//在加载CT2时停止本mod的战役
                    CreatorTowerDefensePlanet.load();//星球
                    CreatorTowerDefenseMaps.load();//地图
                    CreatorTowerDefenseMaps2.load();
                    CreatorTowerDefenseTechTree.load();//科技树

                    //CreatorTowerDefenseTow.load();//塔防2的所有的内容

                }
                //CreatorTowerDefenseTow.load();
                CTTDModJS.DawnMods();//JS加载器
            }}
    }
    @Override
    public void init() {
        if(Vars.mods.locateMod("ctcoresystem") ==null){
            CreatorTowerDefenseInfoDialog.show();

        }else {
            if(compareVersions( Vars.mods.getMod("ctcoresystem").meta.version , MinVersion)<0){//检测低版本
                CreatorTowerDefenseInfoDialog2.show();
            }
            else {
                if (Vars.mods.locateMod("creators") != null) {
                    CreatorTowerDefenseInfoDialog3.show();
                }
            }
        }

    }
}