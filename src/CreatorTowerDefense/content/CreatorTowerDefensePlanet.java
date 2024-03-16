package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.Evn2;
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
            DTPlanet1, DTPlanet2;

    /*    public static Block
                coreT1,coreT2,coreT3;*/
    public static void load() {

        DTPlanet1 = new Planet("GOD1", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("cttd.Planet1");
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
           // defaultEnv =  Evn2.TD标记 ;
            clearSectorOnLose = true;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = false;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次
            accessible = true;
            updateLighting = false;//照明开关
            ruleSetter = r -> {
                r.disableWorldProcessors = false;//世处
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 30;//单位上限
                // r.onlyDepositCore = true;//物品只能存放在核心
                //r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
                //r.teams.get(Team.sharded).unitDamageMultiplier = 0.5f;//单位伤害减半
                r.waveTeam = Team.crux;
                r.fog = false;//迷雾
                r.placeRangeCheck = false;
                r.waitEnemies = true;//等待波次敌人结束后再计时
                r.waveSending = false;//手动跳波
                r.enemyCoreBuildRadius = 5 * 8f;//敌方核心不可建造区域半径
                r.dropZoneRadius = 20 * 8;//敌人刷新点禁区
                r.ghostBlocks = false;
                r.deconstructRefundMultiplier = 0.3f;//拆除返还倍率
                r.waveTimer = true;//开启波次计时
                r.waves = true;//波次
                r.initialWaveSpacing = 30*60;//第一波间隔
                r.waveSpacing=5;//后续波次时间
            };

            // unlockedOnLand.add(Blocks.coreShard);
        }};
        DTPlanet2 = new Planet("GOD2", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("cttd.Planet2");
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
                //r.unitAmmo = true;//单位需要子弹
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 0;//单位上限
                // r.onlyDepositCore = true;//物品只能存放在核心
                //r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
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
