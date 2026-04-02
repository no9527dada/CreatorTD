package CreatorTowerDefense.content;

import CtCoreSystem.CoreSystem.type.LYBF.power.CoreConsumeGenerator;
import CtCoreSystem.CoreSystem.type.LYBF.power.CoreImpactReactor;
import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;


import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static mindustry.type.Category.power;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefensePower {
    public static Block 节点小,节点大,初始电力产生器,电力产生器,三级极点发电器,四级点辉发电器,五级辉灵发电器, 储电器,放电器
            ;
              ;
    public static void load() {


        节点小 = new PowerNode("power-node"){{
            requirements(Category.power, with(魂, 10));
            maxNodes = 7;
            laserRange = 9;
            solid = false;//固体
        }};
        节点大 = new PowerNode("power-node-large"){{
            requirements(Category.power, with(魂, 120, 魄, 5));
            size = 2;
            maxNodes = 30;
            laserRange = 22f;
            solid = false;//固体
        }};
        初始电力产生器=  new ConsumeGenerator("初始电力产生器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 80));
            canOverdrive = false;
            powerProduction = 1f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 3;
            generateEffect = Fx.none;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.02f;
            // consume(new ConsumeItemFlammable());
            // consume(new ConsumeItemExplode());
            drawer = new DrawDefault();
            buildType =Build::new;
        }class Build extends ConsumeGenerator.ConsumeGeneratorBuild {
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, Color.orange, 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }};
        电力产生器 = new ConsumeGenerator("电力产生器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 250, 魄, 30));
            canOverdrive = false;
            powerProduction = 360/60f;
            itemDuration = 60f;
            hasLiquids = false;
            size = 3;
            generateEffect = Fx.generatespark;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.03f;
           // consume(new ConsumeItemFlammable());
           // consume(new ConsumeItemExplode());
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawRegion("-turbine"){{
                        rotateSpeed = 2f;
                    }},
                    new DrawRegion("-turbine"){{
                        rotateSpeed = -2f;
                        rotation = 45f;
                    }},
                    new DrawRegion("-cap")

            );
            buildType =Build::new;
        }
            class Build extends ConsumeGenerator.ConsumeGeneratorBuild {
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, Color.orange, 0.65F + Mathf.absin(20.0F, 0.1F));
                }
            }};
        三级极点发电器=  new CoreConsumeGenerator("三级极点发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 750, 魄, 180));
            canOverdrive = false;
            powerProduction = 1080/60f;
            itemDuration = 60*4f;
            consumeItem(魂,1);
            hasLiquids = false;
            size = 3;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.04f;
            generateEffect = Fx.generatespark;buildType =Build::new;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }class Build extends CoreConsumeGenerator.CoreConsumeGeneratorBuild {
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }};
        四级点辉发电器=new CoreConsumeGenerator("四级点辉发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 1500, 魄, 50,星辰,5));
            powerProduction = 3200/60f;
            itemDuration = 60*4f;
            size = 4;
           // takeItemDelay = 50f;
            consumeItem(魂,2);
            consumesPower=true;
            explosionRadius = 1;
            explosionDamage =0;buildType =Build::new;
           // heating = 0f;//
           // fuelItem=魂;
            consumePower(30/60f);
        }class Build extends CoreConsumeGenerator.CoreConsumeGeneratorBuild {
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }
        };
        五级辉灵发电器=new CoreImpactReactor("五级辉灵发电器"){{
            health = 100;
            armor=500;
            requirements(Category.power, with(魂, 12000, 魄, 4500,星辰,100));
            powerProduction = 25100/60f;
            size = 5;
            itemDuration = 60*2f;
            ambientSound = Sounds.loopPulse;
            ambientSoundVolume = 0.03f;
            consumePower(100/60f);
            fuelItem=魄;
            consumeItem(魄,3);takeItemDelay = 30.0F;

        }};
        储电器 =new Battery("储电器") {{
            requirements(power, with(
                    魄, 120
            ));
          //  insulated = true;//电力自动连接关闭
            conductivePower = true;//可以导电
            consumePowerBuffered(3000);
            health = 100;
            armor=500;
            size = 2;
            buildCostMultiplier = 3f;
            emptyLightColor = Color.valueOf("f8c26600");
            fullLightColor = Color.valueOf("ffffff");
        }};
        放电器=  new ConsumeGenerator("放电器"){{
            health = 100;
            armor=500;
            rebuildable = false;//不会自动重建
            requirements(Category.power, with(星辰, 1));
            canOverdrive = false;
            powerProduction = 1200/60f;
            itemDuration = 60f;
            //consumeLiquid(Liquids.water, 0.1f);
            hasLiquids = false;
            size = 2;
            generateEffect = Fx.none;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.02f;
            // consume(new ConsumeItemFlammable());
            // consume(new ConsumeItemExplode());
            drawer = new DrawDefault();
            buildType =Build::new;
        }
            int 数量 = 10;
            //允许放置
            @Override
            public boolean canPlaceOn(Tile tile, Team team, int rotation) {
                CoreBlock.CoreBuild core = team.core();
                //size后面数字代表允许建筑的数量，最多是数字的值+1
                if (core == null || Vars.state.teams.get(team).getBuildings(this).size > 数量 - 1
                        || (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)
                )) return false;
                return super.canPlaceOn(tile, team, rotation);
            }

            //显示红字
            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                if (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)) {
                    drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
                } else if (Vars.state.teams.get(Vars.player.team()).getBuildings(this).size > 数量 - 1)
                    drawPlaceText(Core.bundle.get("QuantityLimit.限制最大数量") + 数量, x, y, valid);
                super.drawPlace(x, y, rotation, valid);
            }
        class Build extends ConsumeGenerator.ConsumeGeneratorBuild {

            @Override
            public void updateTile() {
                boolean valid = efficiency > 0;

                warmup = Mathf.lerpDelta(warmup, valid ? 1f : 0f, warmupSpeed);

                productionEfficiency = efficiency * efficiencyMultiplier;
                totalTime += warmup * Time.delta;

                //randomly produce the effect
                if(valid && Mathf.chanceDelta(effectChance)){
                    generateEffect.at(x + Mathf.range(generateEffectRange), y + Mathf.range(generateEffectRange));
                }

                //take in items periodically
                if(hasItems && valid && generateTime <= 0f){
                    consume();
                    consumeEffect.at(x + Mathf.range(generateEffectRange), y + Mathf.range(generateEffectRange));
                    generateTime = 1f;
                }

                if(outputLiquid != null){
                    float added = Math.min(productionEfficiency * delta() * outputLiquid.amount, liquidCapacity - liquids.get(outputLiquid.liquid));
                    liquids.add(outputLiquid.liquid, added);
                    dumpLiquid(outputLiquid.liquid);

                    if(explodeOnFull && liquids.get(outputLiquid.liquid) >= liquidCapacity - 0.01f){
                        kill();
                        Events.fire(new EventType.GeneratorPressureExplodeEvent(this));
                    }
                }
                //generation time always goes down, but only at the end so consumeTriggerValid doesn't assume fake items
                generateTime -= delta() / itemDuration;
                /**
                 * 伤害百分比
                 */
                float damagePercent = 20f;
                /**
                 * 固定数值伤害
                 */
                float damageAmount = 0f;
                /**
                 * 伤害间隔
                 */
                float damageTime = 120f;
                //掉血 - 修改：建筑启动 2 秒后才开始扣血
                if (totalTime >= 120f && timer().get(damageTime)) {
                    damage(damageAmount);
                    damage(damagePercent * maxHealth / 100);
                }
            }

            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, Color.orange, 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }};
    }
}
