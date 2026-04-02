package CreatorTowerDefense.content2;

import CtCoreSystem.content.Effect.NewFx;
import arc.Core;
import arc.graphics.Color;
import arc.struct.ObjectMap;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.consumers.ConsumeLiquidBase;
import mindustry.world.consumers.ConsumePower;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatValues;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.TD微晶;
import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static CtCoreSystem.content.ItemX.物品;
import static CtCoreSystem.content.NewColor.*;
import static arc.graphics.g2d.Draw.color;
import static mindustry.Vars.state;
import static mindustry.Vars.world;
import static mindustry.content.Fx.*;
import static mindustry.type.Category.defense;
import static mindustry.type.Category.turret;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTowTurret {


    public static Block
            双管V1, 双管V2, 齐射V1, 齐射V2, 蓝瑟V1, 蓝瑟V2, 雷光V1, 雷光V2,
            浪涌V1, 浪涌V2, 幽灵V1, 幽灵V2, 熔毁V1, 熔毁V2, 厄兆V1, 厄兆V2;

    public static void load() {

        双管V1 = new TD2Turret("双管V1") {{
            requirements(turret, with(TD微晶, 10));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 20 * 8;
            shootType = new BasicBulletType(4f, 10) {{
                pierceArmor = true;
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        双管V1.consume(new ConsumePower(6/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        双管V2 = new TD2Turret("双管V2") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 20 * 8;
            shootType = new BasicBulletType(4f, 15) {{
                pierceArmor = true;
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        双管V2.consume(new ConsumePower(10/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        齐射V1 = new TD2Turret("齐射V1") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 20 * 8;
            shoot.shots = 3;
            shoot.shotDelay = 3;
            ammoUseEffect = Fx.casing2;
            shootSound = Sounds.shootSalvo;
            shootType = new BasicBulletType(4f, 20) {{
                pierceArmor = true;
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        齐射V1.consume(new ConsumePower(30/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });

        齐射V2 = new TD2Turret("齐射V2") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 20 * 8;
            shoot.shots = 5;
            shoot.shotDelay = 3;
            ammoUseEffect = Fx.casing2;
            shootSound = Sounds.shootSalvo;
            shootType = new BasicBulletType(4f, 25) {{
                pierceArmor = true;
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        齐射V2.consume(new ConsumePower(50/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        蓝瑟V1 = new TD2Turret("蓝瑟V1") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 22 * 8;
            shootSound = Sounds.shootLancer;
            shoot.firstShotDelay = 20f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            shootType = new LaserBulletType(30){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                //buildingDamageMultiplier = 0.25f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                pierceArmor = true;
                collidesAir = false;
                length = 180f;
                ammoMultiplier = 1f;
                pierce = true;
            }};
        }};
        蓝瑟V1.consume(new ConsumePower(100/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        蓝瑟V2 = new TD2Turret("蓝瑟V2") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 22 * 8;
            shootSound = Sounds.shootLancer;
            shoot.firstShotDelay = 20f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            shootType = new LaserBulletType(30){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                //buildingDamageMultiplier = 0.25f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                pierceArmor = true;
                drawSize = 400f;
                collidesAir = false;
                length = 180f;
                ammoMultiplier = 1f;
                pierce = true;
            }};
        }};
        蓝瑟V2.consume(new ConsumePower(150/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        雷光V1 = new TD2Turret("雷光V1") {{
            requirements(turret, with(TD微晶, 20));
            reload = 60f;
            range = 23 * 8;
            shoot = new ShootSpread(3, 5f);
            shootCone = 30;
            shootSound = Sounds.shootFuse;;
            float brange = range + 3f;
            shootType = new ShrapnelBulletType(){{
                length = brange;
                damage = 50;
                ammoMultiplier = 1f;
                toColor = Pal.thoriumPink;
                shootEffect = smokeEffect = Fx.thoriumShoot;
            }};
        }};
        雷光V1 .consume(new ConsumePower(300/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        雷光V2 = new TD2Turret("雷光V2") {{
            requirements(turret, with(TD微晶, 20));
            reload = 60f;
            range = 23 * 8;
            shoot = new ShootSpread(5, 5f);
            shootCone = 30;
            shootSound = Sounds.shootFuse;;
            float brange = range + 3f;
            shootType = new ShrapnelBulletType(){{
                length = brange;
                damage = 70;
                ammoMultiplier = 1f;
                toColor = Pal.thoriumPink;
                shootEffect = smokeEffect = Fx.thoriumShoot;
            }};
        }};
        雷光V2 .consume(new ConsumePower(450/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        浪涌V1 = new TD2Turret("浪涌V1") {{
            requirements(turret, with(TD微晶, 20));
            shootSound = Sounds.shootDiffuse;
            reload = 60f;
            range = 25 * 8;
            shootType = new BasicBulletType(2f, 0) {{
                lifetime = 140;
                absorbable = false;//子弹不被护盾仪吸收
                sprite = "ctcoresystem-round";
                width = 24;
                height = 33;
                ammoMultiplier = 1;
                //reloadMultiplier = 射速;
                shootEffect = shootBig;
                smokeEffect = shootSmallSmoke;
                //pierce = true;
                trailColor = 毁灭Bullet颜色;
                trailParam = 2;
                trailLength = 18;
                trailWidth = 8;
                trailRotation = true;
                trailEffect = new ParticleEffect() {{
                    region = "ctcoresystem-正四星";
                    colorFrom = 帝王Bullet颜色2;
                    colorTo = 帝王Bullet颜色1;
                    length = 20f;
                    baseLength = 10f;
                    sizeFrom = 9f;
                    sizeTo = 3f;
                    spin = 5f;
                }};
                trailInterval = 3f;
                trailChance = 0.3f;
                splashDamage = 120;//范围伤害
                splashDamageRadius = 8 * 6;//范围伤害的范围
                collidesAir = collidesGround = true;//对空对地
                       /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
                hitEffect= despawnEffect = NewFx.毁灭despawnEffect(); //NewFx.制裁子弹消失;

                //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
                chargeEffect = none;
            }};
        }};
        浪涌V1 .consume(new ConsumePower(900/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        浪涌V2 = new TD2Turret("浪涌V2") {{
            requirements(turret, with(TD微晶, 20));
            shootSound = Sounds.shootDiffuse;
            reload = 60f;
            range = 25 * 8;
            shootType = new BasicBulletType(2f, 0) {{
                lifetime = 140;
                absorbable = false;//子弹不被护盾仪吸收
                sprite = "ctcoresystem-round";
                width = 24;
                height = 33;
                ammoMultiplier = 1;
                //reloadMultiplier = 射速;
                shootEffect = shootBig;
                smokeEffect = shootSmallSmoke;
                //pierce = true;
                trailColor = 毁灭Bullet颜色;
                trailParam = 2;
                trailLength = 18;
                trailWidth = 8;
                trailRotation = true;
                trailEffect = new ParticleEffect() {{
                    region = "ctcoresystem-正四星";
                    colorFrom = 帝王Bullet颜色2;
                    colorTo = 帝王Bullet颜色1;
                    length = 20f;
                    baseLength = 10f;
                    sizeFrom = 9f;
                    sizeTo = 3f;
                    spin = 5f;
                }};
                trailInterval = 3f;
                trailChance = 0.3f;
                splashDamage = 170;//范围伤害
                splashDamageRadius = 8 * 6;//范围伤害的范围
                collidesAir = collidesGround = true;//对空对地
                       /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
                hitEffect= despawnEffect = NewFx.毁灭despawnEffect(); //NewFx.制裁子弹消失;

                //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
                chargeEffect = none;
            }};
        }};
        浪涌V2.consume(new ConsumePower(1350/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        幽灵V1 = new TD2Turret("幽灵V1") {{
            requirements(turret, with(TD微晶, 20));
            reload = 5f;
            range = 25 * 8;
            ammoUseEffect = Fx.casing3;
            shoot = new ShootAlternate(8f);
            shootSound = Sounds.shootSalvo;
            shootType = new BasicBulletType(8f, 200) {{
                lifetime = 50f;
                sprite= "ctcoresystem-正四星";
                ammoMultiplier = 1;//装弹倍率
                hitSize = 5;
                width = 21f;
                height = 21f;
                frontColor = Pal.lightishOrange;
                backColor = Pal.lightOrange;
                hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
                shootEffect = Fx.shootBig;
                makeFire = true;
                pierce = true;
                splashDamage = 30f;
                splashDamageRadius = 4*8f;
                trailEffect = new ParticleEffect() {{
                    region = "ctcoresystem-正四星";
                    colorFrom = Pal.lightishOrange;;
                    colorTo = Pal.lightOrange;
                    length = 20f;
                    baseLength = 10f;
                    sizeFrom = 9f;
                    sizeTo = 3f;
                    spin = 5f;
                }};
                trailInterval = 2f;//每次产生的间隔时间
                trailParam = 1f;//每次产生的数量
                trailColor = Pal.lightishOrange;;
                trailRotation = false;
                trailLength = -6;//小于等于0会禁用
                trailWidth = -6f;
                trailSinMag = 0f;
                trailSinScl = 3f;
            }};
        }};
        幽灵V1.consume(new ConsumePower(2700/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        幽灵V2 = new TD2Turret("幽灵V2") {{
            requirements(turret, with(TD微晶, 20));
            reload = 5f;
            range = 25 * 8;
            ammoUseEffect = Fx.casing3;
            shoot = new ShootAlternate(8f);
            shootSound = Sounds.shootSalvo;
            shootType = new BasicBulletType(8f, 250) {{
                sprite= "ctcoresystem-正四星";
                lifetime = 50f;
                ammoMultiplier = 1;//装弹倍率
                hitSize = 5;
                width = 21f;
                height = 21f;
                frontColor = Pal.lightishOrange;
                backColor = Pal.lightOrange;
                hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
                shootEffect = Fx.shootBig;
                makeFire = true;
                pierce = true;
                splashDamage = 60f;
                splashDamageRadius = 4*8f;
                trailEffect = new ParticleEffect() {{
                    region = "ctcoresystem-正四星";
                    colorFrom = Pal.lightishOrange;;
                    colorTo = Pal.lightOrange;
                    length = 20f;
                    baseLength = 10f;
                    sizeFrom = 9f;
                    sizeTo = 3f;
                    spin = 5f;
                }};
                trailInterval = 2f;//每次产生的间隔时间
                trailParam = 1f;//每次产生的数量
                trailColor =Pal.lightishOrange;;
                trailRotation = false;
                trailLength = -6;//小于等于0会禁用
                trailWidth = -6f;
                trailSinMag = 0f;
                trailSinScl = 3f;
            }};
        }};
        幽灵V2.consume(new ConsumePower(4050/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        熔毁V1 = new TD2LaserTurret("熔毁V1") {{
            requirements(turret, with(TD微晶, 20));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            recoil = 4f;
            size = 2;
            shake = 2f;
            range = 195f;
            reload = 90f;
            firingMoveFract = 0.5f;
            shootDuration = 230f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 2f;
            envEnabled |= Env.space;
            scaledHealth = 200;
           // coolant = consumeCoolant(0.5f);
            consumePower(17f);
            shootType = new ContinuousLaserBulletType(78){{
                length = 200f;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                drawSize = 420f;
                width = 4f;
                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};
        }};
        熔毁V1.consume(new ConsumePower(8700/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        熔毁V2 = new TD2LaserTurret("熔毁V2") {{
            requirements(turret, with(TD微晶, 20));
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 150 * 8;
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        熔毁V2 .consume(new ConsumePower(12000/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        厄兆V1 = new TD2Turret("厄兆V1") {{
            requirements(turret, with(TD微晶, 1));
            consumePower(10 / 60f);
            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 150 * 8;
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        厄兆V1 .consume(new ConsumePower(60/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });
        厄兆V2 = new TD2Turret("厄兆V2") {{
            requirements(turret, with(TD微晶, 1));

            shoot = new ShootAlternate(3.5f);
            reload = 60f;
            range = 150 * 8;
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 30f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
            }};
        }};
        厄兆V2.consume(new ConsumePower(60/60f,0,false) {
            @Override
            public float requestedPower(Building entity) {
                return super.requestedPower( entity) / entity.timeScale();
            }
        });

    }
    public static class TDConsumePower extends ConsumePower{
        @Override
        public float requestedPower(Building entity) {
            return super.requestedPower( entity) / entity.delta();
           /*
            return buffered ?
                    (1f - entity.power.status) * capacity :
                    usage * (entity.shouldConsume() ? 1f : 0f);
*/
        }
    }
    public static class TD2Turret extends PowerTurret {
        public TD2Turret(String name) {
            super(name);
            size = 2;
            health = 10;
            armor = 0;
            description="";
           // playerControllable = false;//玩家附身
            range = 5 * 8;
            solid = targetable = false;//被单位攻击？
            buildVisibility = BuildVisibility.shown;
        }
        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = false; //true是启用资源不足的条件限制

        //场上数量要求方块不足时禁止放置
        public Block 场上数量要求方块;
        public int 数量 = 1;

        //放置位置没有被覆盖方块时禁止放置
        public Block 被覆盖方块;

        public boolean 资源要求(Team team) {
            CoreBlock.CoreBuild core = Vars.state.teams.get(team).core();
            return !立即放置 || core != null && core.items.has(requirements, Vars.state.rules.buildCostMultiplier);
        }

        public boolean 数量要求(Team team) {
            return 场上数量要求方块 == null || Vars.state.teams.get(team).getBuildings(场上数量要求方块).size >= 数量;
        }

        public boolean 覆盖要求(Tile tile) {
            tile.getLinkedTilesAs(this, tempTiles);
            return 被覆盖方块 == null || tempTiles.contains(o -> o.block() == 被覆盖方块);
        }

        public boolean 沙盒模式() {
            return Vars.state.isEditor() || Vars.state.rules.infiniteResources;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (!沙盒模式() && !(资源要求(team) && 数量要求(team) && 覆盖要求(tile))) return false;
            return super.canPlaceOn(tile, team, rotation);
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            Team team = Vars.player.team();

            if (沙盒模式()) {
            } else if (!资源要求(team)) drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
            else if (!数量要求(team))
                drawPlaceText(Core.bundle.get("QuantityLimit.缺少前置方块") + 场上数量要求方块.localizedName + " X" + 数量, x, y, false);
            else if (!覆盖要求(world.tile(x, y)))
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 被覆盖方块.localizedName, x, y, valid);
            ;

            super.drawPlace(x, y, rotation, valid);
        }

        //瞬间替换和扣除物品
        @Override
        public void placeBegan(Tile tile, Block previous) {
            Team team = Vars.player.team();

            if (立即放置 && 资源要求(team) && !沙盒模式()) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                core.items.remove(requirements);
                tile.setBlock(this, tile.team());
                tile.block().placeEffect.at(tile, tile.block().size);
            } else super.placeBegan(tile, previous);
        }

        @Override
        public boolean canReplace(Block other) {
            return super.canReplace(other) || other == 被覆盖方块;
        }
    }
    public static class TD2LaserTurret extends LaserTurret {
        public TD2LaserTurret(String name) {
            super(name);
            size = 2;
            health = 10;
            armor = 0;
            description="";
            // playerControllable = false;//玩家附身
            range = 5 * 8;
            solid = targetable = false;//被单位攻击？
            buildVisibility = BuildVisibility.shown;
        }
        @Override
        public void setStats() {
            stats = Blocks.lancer.stats;
        }
        @Override
        public void init(){
        }
        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = false; //true是启用资源不足的条件限制

        //场上数量要求方块不足时禁止放置
        public Block 场上数量要求方块;
        public int 数量 = 1;

        //放置位置没有被覆盖方块时禁止放置
        public Block 被覆盖方块;

        public boolean 资源要求(Team team) {
            CoreBlock.CoreBuild core = Vars.state.teams.get(team).core();
            return !立即放置 || core != null && core.items.has(requirements, Vars.state.rules.buildCostMultiplier);
        }

        public boolean 数量要求(Team team) {
            return 场上数量要求方块 == null || Vars.state.teams.get(team).getBuildings(场上数量要求方块).size >= 数量;
        }

        public boolean 覆盖要求(Tile tile) {
            tile.getLinkedTilesAs(this, tempTiles);
            return 被覆盖方块 == null || tempTiles.contains(o -> o.block() == 被覆盖方块);
        }

        public boolean 沙盒模式() {
            return Vars.state.isEditor() || Vars.state.rules.infiniteResources;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if (!沙盒模式() && !(资源要求(team) && 数量要求(team) && 覆盖要求(tile))) return false;
            return super.canPlaceOn(tile, team, rotation);
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            Team team = Vars.player.team();

            if (沙盒模式()) {
            } else if (!资源要求(team)) drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
            else if (!数量要求(team))
                drawPlaceText(Core.bundle.get("QuantityLimit.缺少前置方块") + 场上数量要求方块.localizedName + " X" + 数量, x, y, false);
            else if (!覆盖要求(world.tile(x, y)))
                drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 被覆盖方块.localizedName, x, y, valid);
            ;

            super.drawPlace(x, y, rotation, valid);
        }

        //瞬间替换和扣除物品
        @Override
        public void placeBegan(Tile tile, Block previous) {
            Team team = Vars.player.team();

            if (立即放置 && 资源要求(team) && !沙盒模式()) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                core.items.remove(requirements);
                tile.setBlock(this, tile.team());
                tile.block().placeEffect.at(tile, tile.block().size);
            } else super.placeBegan(tile, previous);
        }

        @Override
        public boolean canReplace(Block other) {
            return super.canReplace(other) || other == 被覆盖方块;
        }
    }
}