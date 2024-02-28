package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.CreatorTowerDefenseItems显示;


public class CreatorTowerDefensePlanet {
    public static Planet
            DTPlanet ;

    /*    public static Block
                coreT1,coreT2,coreT3;*/
    public static void load() {

        DTPlanet = new Planet("GOD", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("创世神塔防");
            generator = new SerpuloPlanetGenerator() {
                public boolean allowLanding(Sector sector) {
                    return false;
                }//关闭数字区块

                public void generateSector(Sector sector) {

                }//无基地

            };
            // defaultEnv = Env.terrestrial;//*这个星球上扇区的环境标志。

            iconColor = Color.valueOf("ee7433");
            atmosphereColor = Color.valueOf("ee7433");
            landCloudColor = Pal.spore.cpy().a(0.5f);
            meshLoader = () -> new HexMesh(this, 7);
            itemWhitelist.addAll(CreatorTowerDefenseItems显示);
            bloom = true;
            startSector = 0;
            alwaysUnlocked = true;
            clearSectorOnLose = true;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = false;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次
            accessible = true;
            //TODO SHOULD there be lighting?
            updateLighting = false;
            ruleSetter = r -> {
                r.unitAmmo = true;//单位需要子弹
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 9999;//单位上限
                r.onlyDepositCore = true;//物品只能存放在核心
                r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
                //r.teams.get(Team.sharded).unitDamageMultiplier = 0.5f;//单位伤害减半
                r.waveTeam = Team.crux;
                r.fog = false;//迷雾
                r.placeRangeCheck = false;


            };

           // unlockedOnLand.add(Blocks.coreShard);
        }};

        //  setPlanet(Planet5, new String[]{"ct"});


    }

}
