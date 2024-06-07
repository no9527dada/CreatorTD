package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.type.CTCoreBlock;
import ct.Asystem.type.TDTyep.TDMendProjector;
import ct.Asystem.type.VXV.CreatorsPowerField;
import mindustry.content.Planets;
import mindustry.content.TechTree;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.*;
import mindustry.world.Block;

import static CreatorTowerDefense.content.CreatorTowerDefenseCore.核心机1;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.CreatorTowerDefenseItems显示;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
import static CreatorTowerDefense.content.CreatorTowerDefensePlanet.DTPlanet2;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDCoreGenericCrafter;
import static mindustry.type.Category.crafting;
import static mindustry.type.Category.effect;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTow {
    public static Planet DTPlanet2;
    //资源
    public static Item TD微晶, TD魔能晶;
    //前置
    public static Block 神心1, 神心2, 神心3, 神心4, 神心5;
    //生产
    public static Block 宝盒1, 宝盒2, 宝盒3, 宝盒4, 宝盒5, 宝盒6, 宝盒7, 宝盒8, 宝盒9, 宝盒10;
    public static Block 魔盒1, 魔盒2, 魔盒3, 魔盒4, 魔盒5;
    //防御
    public static Block 铜墙0, 铅墙1, 钛墙2, 钍墙3, 塑钢墙4, 相位墙5, 合金墙6, 魔石墙7, 魔微墙8, 神威墙9, 创世墙10;
    public static Block 双管1, 双管2, 齐射1, 齐射2, 蓝瑟1, 蓝瑟2, 雷光1, 雷光2, 浪涌1, 浪涌2, 幽灵1, 幽灵2, 熔毁1, 熔毁2, 厄兆1, 厄兆2;
    //电力
    public static Block 能量网络, 能量核心1, 能量核心2, 能量核心3, 能量核心4, 能量核心5;
    // /设施
    public static Block 修复器, 减速器1, 减速器2, 易伤器1, 易伤器2, 加速1, 加速2, 加速3;


    public static void load() {
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
                r.disableOutsideArea = false;//场外禁用 关闭 世处都是在场外 不能禁用
                r.disableWorldProcessors = false;//世处禁用 关闭
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 0;//单位上限
                // r.onlyDepositCore = true;//物品只能存放在核心
                //r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
                //r.teams.get(Team.sharded).unitDamageMultiplier = 0.5f;//单位伤害减半
                r.waveTeam = Team.crux;
                r.fog = false;//迷雾
                r.placeRangeCheck = false;
                r.waitEnemies = true;//等待波次敌人结束后再计时
                r.waveSending = false;//手动跳波
                r.enemyCoreBuildRadius = 5 * 8f;//敌方核心不可建造区域半径
                r.dropZoneRadius = 3 * 8;//敌人刷新点禁区
                // r.ghostBlocks = true;//重建
                r.deconstructRefundMultiplier = 0.2f;//拆除返还倍率
                r.waveTimer = true;//开启波次计时
                r.waves = true;//波次
                r.initialWaveSpacing = 60 * 60;//第一波间隔
                r.waveSpacing = 10 * 60;//后续波次时间
            };

            // unlockedOnLand.add(Blocks.coreShard);
        }};
        TD微晶 = new Item("微晶", Color.valueOf("9bccfe"));
        TD魔能晶 = new Item("魔能晶", Color.valueOf("fb7069"));
        new CreatorsPowerField("能量网络") {{
            laserRange = 500 * 8;
        }};
        神心1 = new CTCoreBlock("DTcore1") {{
            requirements(Category.effect, with(TD微晶, 1));
            alwaysUnlocked = true;
            incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
            isFirstTier = false;//核心地板限制
            unitType = 核心机1;
            health = 100;
            itemCapacity = 50000;
            size = 3;
            unitCapModifier = 0;
            requiresCoreZone = true;//需要特定地板

        }};

        宝盒1 = new TDCoreGenericCrafter("宝盒1") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒2 = new TDCoreGenericCrafter("宝盒2") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒1;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒3 = new TDCoreGenericCrafter("宝盒3") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒2;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒4 = new TDCoreGenericCrafter("宝盒4") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒3;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒5 = new TDCoreGenericCrafter("宝盒5") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒4;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒6 = new TDCoreGenericCrafter("宝盒6") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒5;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒7 = new TDCoreGenericCrafter("宝盒7") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒6;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒8 = new TDCoreGenericCrafter("宝盒8") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒7;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒9 = new TDCoreGenericCrafter("宝盒9") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒8;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        宝盒10 = new TDCoreGenericCrafter("宝盒10") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(魂, 7);
            health = 100;
            armor = 500;
            itemCapacity = 20;
            size = 4;
            craftTime = 60 * 5;
            升级前置 = 宝盒9;
            requirements(crafting, with(
                    TD微晶, 100
            ));
        }};
        修复器 = new TDMendProjector("修复器a") {{
            requirements(effect, with(魂, 600));
            //floor = (Floor) TD地板b;
        }};
        DTPlanet2.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree2"), 神心1, true, () -> {

        });
    }
}