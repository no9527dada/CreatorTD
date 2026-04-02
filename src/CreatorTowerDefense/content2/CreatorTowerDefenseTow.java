package CreatorTowerDefense.content2;

import CreatorTowerDefense.content.CreatorTowerDefenseType;

import CtCoreSystem.CoreSystem.type.CT3UnitType;
import CtCoreSystem.CoreSystem.type.CTCoreBlock;
import CtCoreSystem.CoreSystem.type.Ovulam5480.BlockLimit.TD2MendProjector;
import CtCoreSystem.CoreSystem.type.StatusEffectProjector;
import CtCoreSystem.CoreSystem.type.TDTyep.TDMendProjector;

import CtCoreSystem.CoreSystem.type.VXV.CreatorsPowerField;
import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.Vars;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.Planets;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.*;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.consumers.ConsumeItems;
import mindustry.world.meta.BlockGroup;

import static CreatorTowerDefense.content.CreatorTowerDefenseBuff.冰霜塔减速2;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseUnits.加速状态仪Buff;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowGenericCrafter.*;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowPower.*;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowTurret.*;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowWall.*;
import static mindustry.Vars.indexer;
import static mindustry.Vars.world;
import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.node;
import static mindustry.type.Category.effect;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTow {
    public static Planet 塔防星球2;

    //前置
    public static Block 核心基地;//神心2, 神心3, 神心4, 神心5
    // /设施
    public static Block 易伤器1, 易伤器2, 制冷器, 冰爆器, 超速1, 超速2, 超速3;
    public static Block 修复器A1, 修复器A2, 修复器A3, 修复器A4, 修复器A5, 修复器B;

    public static void load() {
        CreatorTowerDefenseTowWall.load();
        CreatorTowerDefenseTowGenericCrafter.load();
        CreatorTowerDefenseTowPower.load();
        CreatorTowerDefenseTowTurret.load();
        塔防星球2 = new Planet("GOD2", Planets.sun, 1f, 3) {{
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
           // itemWhitelist.addAll(CreatorTowerDefenseItems显示2);
            bloom = true;
            startSector = 0;
            alwaysUnlocked = true;
            //  defaultEnv =  Evn2.TD2标记;
            clearSectorOnLose = true;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = false;//模拟攻击图入侵

            accessible = true;
            updateLighting = true;//照明开关
            ruleSetter = r -> {
                r.bannedBlocks.addAll(//禁用方块
                         核心基地,当当宝盒1);
                r.hideBannedBlocks = true;//禁用的方块被隐藏开启
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
        核心基地 = new CTCoreBlock("核心基地") {{
            requirements(Category.effect, with(TD微晶, 1));
            alwaysUnlocked = true;
            incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
            isFirstTier = false;//核心地板限制
            description="";
            unitType = new CT3UnitType.CTR1UnitType("CoreUnit2", "gamma") {{
                // localizedName = "";
                description="";
                aiController = BuilderAI::new;
                isEnemy = false;
                lowAltitude = true;
                flying = true;
                // mineSpeed = 3f;
                // mineTier = 1;
                buildSpeed = 5f;
                drag = 0.05f;
                speed = 8f;
                rotateSpeed = 15f;
                accel = 0.1f;
                itemCapacity = 1;
                health = 100f;
                hitSize = 16f;
                alwaysUnlocked = true;
                mineRange = 0f;//采矿范围
                hittable = false;//被子弹击中
                killable = false;//被杀死
                targetable = false;//被敌人瞄准
                physics = false;//单位碰撞
                buildRange = 35 * 8.0F;//建造范围
                lightColor = Color.valueOf("ffcd35");
                ammoType = new ItemAmmoType(TD微晶);
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
            health = 100;
            itemCapacity = 50000;
            size = 3;
            unitCapModifier = 0;
            requiresCoreZone = true;//需要特定地板

        }};
        修复器A1 = new TD2MendProjector("TD2修复器A1") {{
            requirements(effect, with(TD微晶, 200));
            数量 = 1;
            size = 2;
            reload = 30f;//修复间隔
            range = 40 * 8f;//范围
            healPercent = 1f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
        }};
        修复器A2 = new TD2MendProjector("TD2修复器A2") {{
            requirements(effect, with(TD微晶, 400));
            数量 = 1;
            size = 2;
            reload = 30f;//修复间隔
            range = 40 * 8f;//范围
            healPercent = 1f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
        }};
        修复器A3 = new TD2MendProjector("TD2修复器A3") {{
            requirements(effect, with(TD微晶, 800));
            数量 = 1;
            size = 2;
            reload = 30f;//修复间隔
            range = 40 * 8f;//范围
            healPercent = 1f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
        }};
        修复器A4 = new TD2MendProjector("TD2修复器A4") {{
            requirements(effect, with(TD微晶, 1600));
            数量 = 1;
            size = 2;
            reload = 30f;//修复间隔
            range = 40 * 8f;//范围
            healPercent = 1f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
        }};
        修复器A5 = new TD2MendProjector("TD2修复器A5") {{
            requirements(effect, with(TD微晶, 3200));
            数量 = 1;
            size = 2;
            reload = 30f;//修复间隔
            range = 40 * 8f;//范围
            healPercent = 1f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
        }};
        修复器B = new TD22MendProjector("TD2修复器B") {{
            requirements(effect, with(TD魔能晶, 300));
            damageTime = 20*60;//N秒后自毁
            size = 2;
            reload = 30f;//修复间隔
            range = 100 * 8f;//范围
            healPercent = 5f;//修复百分比
            phaseBoost = 0f;
            phaseRangeBoost = 0f;
            useTime = -1f;
            前置方块=铜墙V0;
        }};
        超速1 = new TD2OverdriveProjector("超速V1") {
            {
                damageTime = 10*60;//N秒后自毁
                range = 30 * 8;//范围
                speedBoost = 1.5f;//加速
                requirements(effect, with(
                        TD微晶, 100

                ));
                consumePower(200 / 60f);
            }
        };
        超速2 = new TD2OverdriveProjector("超速V2") {
            {
                damageTime = 30*60;//N秒后自毁
                range = 30 * 8;//范围
                speedBoost = 2f;//加速
                requirements(effect, with(
                        TD微晶, 220

                ));
                consumePower(2300 / 60f);
            }
        };
        超速3 = new TD2OverdriveProjector("超速V3") {

            {
                damageTime = 90*60;//N秒后自毁
                range = 30 * 8;//范围
                speedBoost = 2f;//加速
                requirements(effect, with(
                        TD微晶, 220

                ));
                consumePower(2300 / 60f);
            }
        };
        制冷器 = new TD2StatusEffectProjector("制冷器") {{
            canOverdrive = false;
            requirements(effect, with(TD微晶, 200));
            consumePower(300/60f);
            group = BlockGroup.turrets;
            前置方块=当当宝盒6;
            plans = Seq.with(
                    new StatusEffectPlan(
                            new StatusEffect("FireRate1") {{
                                reloadMultiplier = 0.75f;
                                localizedName= Core.bundle.format("status."+name+".name", reloadMultiplier*100);
                            }},
                            new ConsumeItems(with()),60)
            );
        }};
        冰爆器= new CreatorTowerDefenseType.TDItemTurret("冰爆器", 20 * 8, 8 * 60,
               new StatusEffect("FireRate2") {{
                   reloadMultiplier = 0.6f;
                   localizedName= Core.bundle.format("status."+name+".name", reloadMultiplier*100);
               }},
               1) {{
           canOverdrive = false;
            reload = 14 * 60f;
            升级前置 = 制冷器;
           group = BlockGroup.turrets;
            itemStacks = ItemStack.with(TD微晶, 30);
            consumePower(800 / 60f);
            requirements(Category.turret, with(TD微晶, 800, TD魔能晶, 230));
        }};



        CreatorTowerDefenseTowMaps.load();
        塔防星球2.techTree = TechTree.nodeRoot(Core.bundle.format("cttd.TechTree2"), 核心基地, true, () -> {
            node(铜墙V0, () -> {
                node(铅墙V1, () -> {
                    node(钛墙V2, () -> {
                        node(钍墙V3, () -> {
                            node(塑钢墙V4, () -> {
                                node(相位墙V5, () -> {
                                    node(合金墙V6, () -> {
                                        node(魔石墙V7, () -> {
                                            node(魔微墙V8, () -> {
                                                node(神威墙V9, () -> {
                                                    node(创世墙V10, () -> {
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(当当宝盒1, () -> {
                node(当当宝盒2, () -> {
                    node(当当宝盒3, () -> {
                        node(当当宝盒4, () -> {
                            node(当当宝盒5, () -> {
                                node(当当宝盒6, () -> {
                                    node(当当宝盒7, () -> {
                                        node(当当宝盒8, () -> {
                                            node(当当宝盒9, () -> {
                                                node(当当宝盒10, () -> {
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(叮叮魔盒1, () -> {
                node(叮叮魔盒2, () -> {
                    node(叮叮魔盒3, () -> {
                        node(叮叮魔盒4, () -> {
                            node(叮叮魔盒5, () -> {
                                node(叮叮魔盒6, () -> {
                                    node(叮叮魔盒7, () -> {
                                        node(叮叮魔盒8, () -> {
                                            node(叮叮魔盒9, () -> {
                                                node(叮叮魔盒10, () -> {
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(电量查看器2, () -> {
                node(能量网络器, () -> {
                    node(能量释放器1, () -> {
                        node(能量释放器2, () -> {
                            node(能量释放器3, () -> {
                                node(能量释放器4, () -> {
                                    node(能量释放器5, () -> {
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(双管V1,() -> {
                node(双管V2, ItemStack.with(TD蔚蓝星辰,2),Seq.with(
                        new Objectives.Research(双管V1)//研究
                ), () -> {
                    node(齐射V1, () -> {
                        node(齐射V2, () -> {
                            node(蓝瑟V1, () -> {
                                node(蓝瑟V2, () -> {
                                 });
                            });
                        });
                    });
                });
            });
            node(雷光V1, () -> {
                node(雷光V2, () -> {
                    node(浪涌V1, () -> {
                        node(浪涌V2, () -> {
                            node(幽灵V1, () -> {
                                node(幽灵V2, () -> {
                                    node(熔毁V1, () -> {
                                        node(熔毁V2, () -> {
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(修复器A1, () -> {
                node(修复器A2, () -> {
                    node(修复器A3, () -> {
                        node(修复器A4, () -> {
                            node(修复器A5, () -> {
                                node(修复器B, () -> {
                                });
                            });
                        });
                    });
                });
            });
            node(超速1, () -> {
                node(超速2, () -> {
                    node(超速3, () -> {
                    });
                });
            });
            node(制冷器, () -> {
                node(冰爆器, () -> {
                });
            });
        });
    }


    public static class TD2OverdriveProjector extends OverdriveProjector {
        //伤害百分比, 负值时为回血
        public float damagePercent = 100f;
        //固定数值伤害, 负值时为回血
        public float damageAmount = 0f;
        //受伤或者回血间隔
        public float damageTime = 120f;
        //受伤不能回血时间
        public float pauseTime = 300f;

        class Build extends OverdriveProjector.OverdriveBuild {
            @Override
            public boolean isHealSuppressed() {
                return false;
            }//禁止被修复

            public float damageTimer, pauseTimer;

            @Override
            public void updateTile() {
                boolean isDamage = damagePercent > 0 || damageAmount > 0;

                if(pauseTimer > 0 && !isDamage){
                    pauseTimer -= delta();
                }else {
                    damageTimer += delta();
                }

                if (damageTimer > damageTime) {
                    if(isDamage){
                        damage(damageAmount);
                        damage(damagePercent * maxHealth / 100);
                    }else {
                        heal(-damageAmount);
                        heal(-damagePercent * maxHealth / 100);
                    }

                    damageTimer = 0f;
                }
            }

            @Override
            public void damage(float damage) {
                super.damage(damage);
                pauseTimer = pauseTime;
            }

        }

        public TD2OverdriveProjector(String name) {
            super(name);
            buildType = Build::new;
            speedBoostPhase = 0f;//加速加成
            useTime = -1;
            phaseRangeBoost = 0 * 8f;//范围加成
            health = 10;
            size = 3;
            buildCostMultiplier = 0;
            createRubble = false;//被破坏后的黑色残留
            solid = targetable = false;//被单位攻击？
            /** 方块破坏时声音.*/
            destroySound = Vars.tree.loadSound("Z1");
        }
    }

    public static class TD22MendProjector extends MendProjector {
        //前置方块targetBlock
        public Block 前置方块;
        //伤害百分比, 负值时为回血
        public float damagePercent = 100f;
        //固定数值伤害, 负值时为回血
        public float damageAmount = 0f;
        //受伤或者回血间隔
        public float damageTime = 120f;
        //受伤不能回血时间
        public float pauseTime = 300f;

        //允许放置
        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            //size后面数字代表场上目标建筑的数量，低于数字的值则不允许建造
            if (Vars.state.teams.get(team).getBuildings(前置方块).size < 1) return false;
            if (前置方块 == null) return false;
            return super.canPlaceOn(tile, team, rotation);
        }


        class TD22MendProjectorBuild extends MendProjector.MendBuild {

            @Override
            public boolean isHealSuppressed() {
                return false;
            }//禁止被修复
            public float damageTimer, pauseTimer;

            @Override
            public void updateTile() {
                boolean canHeal = !checkSuppression();

                smoothEfficiency = Mathf.lerpDelta(smoothEfficiency, efficiency, 0.08f);
                heat = Mathf.lerpDelta(heat, efficiency > 0 && canHeal ? 1f : 0f, 0.08f);
                charge += heat * delta();

                phaseHeat = Mathf.lerpDelta(phaseHeat, optionalEfficiency, 0.1f);

                if(optionalEfficiency > 0 && timer(timerUse, useTime) && canHeal){
                    consume();
                }

                if(charge >= reload && canHeal){
                    float realRange = range + phaseHeat * phaseRangeBoost;
                    charge = 0f;

                    indexer.eachBlock(this, realRange, b -> b.damaged() && !b.isHealSuppressed(), other -> {
                        other.heal(other.maxHealth() * (healPercent + phaseHeat * phaseBoost) / 100f * efficiency);
                        other.recentlyHealed();
                        Fx.healBlockFull.at(other.x, other.y, other.block.size, baseColor, other.block);
                    });
                }
                boolean isDamage = damagePercent > 0 || damageAmount > 0;

                if(pauseTimer > 0 && !isDamage){
                    pauseTimer -= delta();
                }else {
                    damageTimer += delta();
                }

                if (damageTimer > damageTime) {
                    if(isDamage){
                        damage(damageAmount);
                        damage(damagePercent * maxHealth / 100);
                    }else {
                        heal(-damageAmount);
                        heal(-damagePercent * maxHealth / 100);
                    }

                    damageTimer = 0f;
                }
            }

            @Override
            public void damage(float damage) {
                super.damage(damage);
                pauseTimer = pauseTime;
            }



        }

        //瞬间替换和扣除物品
        @Override
        public void placeBegan(Tile tile, Block previous) {
            if (!Vars.state.rules.infiniteResources) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                core.items.remove(requirements);
            }
            tile.setBlock(this, tile.team());
            tile.block().placeEffect.at(tile, tile.block().size);
        }


        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = true; //true是启用资源不足的条件限制

        public boolean 沙盒模式() {
            return Vars.state.isEditor() || Vars.state.rules.infiniteResources;
        }

        public boolean 资源要求(Team team) {
            CoreBlock.CoreBuild core = Vars.state.teams.get(team).core();
            return !立即放置 || core != null && core.items.has(requirements, Vars.state.rules.buildCostMultiplier);
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            Team team = Vars.player.team();
            if (沙盒模式()) {
            } else if (!资源要求(team)) drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
            super.drawPlace(x, y, rotation, valid);
        }

        public TD22MendProjector(String name) {
            super(name);
            buildType = TD22MendProjectorBuild::new;
            useTime = 60;
            phaseRangeBoost = 0 * 8f;//范围加成
            health = 10;
            size = 2;
            buildCostMultiplier = 0;
            createRubble = false;//被破坏后的黑色残留
            solid = targetable = false;//被单位攻击？
            /** 方块破坏时声音.*/
            destroySound = Vars.tree.loadSound("Z1");
        }
    }
    public static class TD2StatusEffectProjector extends StatusEffectProjector {

        public TD2StatusEffectProjector(String name) {
            super(name);
            range = 100 * 8f;//范围
            size = 2;
        }
        // 前置方块存在场上的数量，低于数字的值则不允许建造
        public int 数量 = 1;

        //前置方块targetBlock
        public Block 前置方块;

        //允许放置
        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            //size后面数字代表场上目标建筑的数量，低于数字的值则不允许建造
            if (Vars.state.teams.get(team).getBuildings(前置方块).size < 数量) return false;
            if (前置方块 == null) return false;
            return super.canPlaceOn(tile, team, rotation);
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            if (Vars.state.teams.get(Vars.player.team()).getBuildings(前置方块).size < 数量)
                drawPlaceText(Core.bundle.get("QuantityLimit.缺少前置方块") + 前置方块.localizedName + " X" + 数量, x, y, valid);
            super.drawPlace(x, y, rotation, valid);
        }
    }
}