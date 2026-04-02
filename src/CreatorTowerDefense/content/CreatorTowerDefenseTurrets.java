package CreatorTowerDefense.content;

import CreatorTowerDefense.content.Sundry.光圈;

import CtCoreSystem.CoreSystem.type.Ovulam5480.BUFF投影2;
import CtCoreSystem.CoreSystem.type.Ovulam5480.BulletType.JiGuangFanWeiShangHaiBulletType;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import CtCoreSystem.CoreSystem.type.TDTyep.CTMineCell;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ContinuousTurret;
import mindustry.world.meta.BlockGroup;

import static CreatorTowerDefense.content.CreatorTowerDefenseBuff.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.*;
import static CreatorTowerDefense.knapsack.*;
import static arc.graphics.Blending.additive;
import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;
import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static mindustry.content.Fx.none;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class CreatorTowerDefenseTurrets {
    public static Effect 火焰(int lifetime, int clipsize, int 数量, int 长度) {
        return new Effect(lifetime, clipsize, e -> {
            color(Pal.lightFlame, Pal.darkFlame, Color.gray, e.fin());
            randLenVectors(e.id, 数量, e.finpow() * 长度, e.rotation, 10, (x, y) -> {
                Fill.circle(e.x + x, e.y + y, 0.65f + e.fout() * 1.5f);
            });
        });
    }

    public static Block 双管1, 双管2, 双管3, 双管4, 双管5,
            冰霜塔1, 冰霜塔2, 冰霜塔3,
            霜冻塔2,霜冻塔3,
            黏黏炮1, 黏黏炮2, 蓝瑟2, 蓝瑟1, 蓝瑟3,蓝瑟4,蓝瑟5,
            激光炮1, 激光炮2, 激光炮3, 激光炮4, 激光炮5,
            火焰喷射器1, 火焰喷射器2, 火焰喷射器3,
            钉钉塔, 钉刺塔, 地刺塔, 地刺雷,
            繁花1,繁花2,
            熔毁1, 熔毁2, 熔毁3,
            厄运1, 厄运2, 厄运3, 厄梦2, 厄梦3,
            飞星1,飞星2,飞星3,

    炮塔aaa;

    public static void load() {
        双管1 = new TDPowerTurret("双管1", 60, 8) {{
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

            consumePower(10 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 4));
        }};
        双管2 = new TDPowerTurret("双管2", 40, 14) {{
            shootType = new BasicBulletType(4f, 6) {{
                width = 7 + 2f;
                height = 9 + 2f;
                lifetime = 30f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("fff96f");
            }};
            升级前置 = 双管1;
            consumePower(60 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 60, 魄, 5));
        }};
        双管3 = new TDPowerTurret("双管3", 30, 22) {{
            shootType = new BasicBulletType(4f, 15) {{
                width = 7 + 4f;
                height = 9 + 4f;
                lifetime = 65f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
                pierce = true;
                pierceCap=2;
            }};
            升级前置 = 双管2;
            consumePower(300 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 850, 魄, 330));
        }};
        双管4 = new TDPowerTurret("双管4", 22, 26) {{
            shootType = new BasicBulletType(4f, 20) {{
                width = 9 + 4f;
                height = 11 + 4f;
                lifetime = 60f;
                ammoMultiplier = 1;
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("ff847d");
                splashDamage = 40;
                splashDamageRadius = 3.5f * 8f;
                hitEffect = Fx.blastExplosion;

            }};
            升级前置 = 双管3;
            consumePower(1200 / 60f);
            shoot = new ShootAlternate(3.5f);
            requirements(Category.turret, with(魂, 2600, 魄, 320, 星辰, 15));
        }};
        双管5 = new TDPowerTurret("双管5", 5, 35) {{
            size = 4;
            shootSound = Sounds.shootSalvo;
            shoot = new ShootAlternate(16f);
            ammoUseEffect = Fx.casing3;
            shootType = new BasicBulletType(9f, 40) {{
                width = 14 + 4f;
                height = 17 + 4f;
                lifetime = 40f;
                ammoMultiplier = 1;
                inaccuracy = 4;//精准
                homingPower = 0.02F;
                hitEffect = Fx.blastExplosion;
                trailLength = 11;
                trailWidth = 4;
                trailColor = C("B8DCAA");
                splashDamage = 300;
                splashDamageRadius = 5f * 8f;
                lightning = 4; //闪电根数
                lightningLength = 15; //闪电长度
                lightningDamage = 15;//闪电伤害
                lightningColor = C("B8DCAA");//闪电颜色
            }};
            升级前置 = 双管4;
            consumePower(4000 / 60f);
            requirements(Category.turret, with(魂, 35000, 魄, 15000, 星辰, 150,无尽星辰,1));
        }};

        黏黏炮1 = new TDPowerTurret("黏黏炮1", 120, 14) {{
            shootType = new BasicBulletType(4f, 2) {{
                width = 7f;
                height = 9f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
                splashDamageRadius = 2 * 8;
                splashDamage = 0.01F;
                status = 黏黏;
                statusDuration = 5 * 60f;
                shootCone = 90F;//瞄准角度
            }};
            consumePower(30 / 60f);
            requirements(Category.turret, with(魂, 40));
        }};
        黏黏炮2 = new TDPowerTurret("黏黏炮2", 80, 23) {{
            shootType = new BasicBulletType(4f, 6) {{
                width = 7f;
                height = 9f;
                lifetime = 70f;
                ammoMultiplier = 1;//装弹倍率
                homingPower = 1;
                trailLength = 8;
                trailWidth = 2;
                trailColor = C("baee33");
                splashDamageRadius = 3 * 8;
                splashDamage = 0.01F;
                status = 黏黏;
                statusDuration = 12 * 60f;
                shootCone = 90F;//瞄准角度
            }};
            升级前置 = 黏黏炮1;
            consumePower(400 / 60f);
            requirements(Category.turret, with(魂, 560, 魄, 90));
        }};

        蓝瑟1 = new TDPowerTurret("蓝瑟1", 70, 14) {{
            shootSound = Sounds.shootLancer;
            shootType = new LaserBulletType(5) {{
                colors = new Color[]{C("fab02d").cpy().a(0.4f), C("fab02d"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 14 * 8;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            consumePower(50 / 60f);
            requirements(Category.turret, with(魂, 50, 魄, 10));
        }};
        蓝瑟2 = new TDPowerTurret("蓝瑟2", 50, 17) {{
            shootSound = Sounds.shootLancer;
            shootType = new LaserBulletType(12) {{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 20 * 8f;
                ammoMultiplier = 1f;
                //pierceCap = 4;
            }};
            升级前置 = 蓝瑟1;
            consumePower(240 / 60f);
            requirements(Category.turret, with(魂, 220, 魄, 60));
        }};
        蓝瑟3 = new TDPowerTurret("蓝瑟3", 40, 22) {{
            shootSound = Sounds.shootLancer;
            shootType = new LaserBulletType(25) {{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                fragOnHit = false;
                length = 27 * 8f;
                ammoMultiplier = 1f;
                shoot = new ShootSpread(3, 5);
            }};
            升级前置 = 蓝瑟2;
            consumePower(1200 / 60f);
            requirements(Category.turret, with(魂, 4500, 魄, 750, 星辰, 7));
        }};
        蓝瑟4 = new TDPowerTurret("蓝瑟4", 30, 25) {{
            shootSound = Sounds.shootLancer;
            shootType = new LaserBulletType(45) {{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 30F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                fragOnHit = false;
                length = 30 * 8f;
                ammoMultiplier = 1f;
                shoot = new ShootSpread(4, 3);
            }};
            升级前置 = 蓝瑟2;
            consumePower(2200 / 60f);
            requirements(Category.turret, with(魂, 15000, 魄, 1300, 星辰, 20));
        }};
        蓝瑟5 = new TDPowerTurret("蓝瑟5", 20, 35) {{
            shootSound = Sounds.shootFuse;;
            size=4;
            shootType = new LaserBulletType(350) {{
                colors = new Color[]{C("f90000").cpy().a(0.4f), C("f90000"), C("ff9f9f")};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                shootCone = 10F;//瞄准角度
                hitEffect = Fx.hitLancer;
                hitSize = 8;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                fragOnHit = false;
                length = 43 * 8f;
                ammoMultiplier = 1f;
                shoot = new ShootSpread(6, 5);
                lightningDamage=8;
                lightningLength=32;
                lightning=1;
                lightningColor=C("ffa59f");
                lightningCone=25;
            }};
            升级前置 = 蓝瑟2;
            consumePower(7000 / 60f);
            requirements(Category.turret, with(魂, 48000, 魄, 24000, 星辰, 150,无尽星辰,1));
        }};
        繁花1 = new TDPowerTurret("繁花1", 180, 25) {{
            //shootSound = Sounds.shootLancer;
            unitSort = UnitSorts.farthest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
            size = 3;
            shootCone = 40F;//瞄准角度
            shoot = new ShootSpread(2, 10f);
            shootType = new CreatorTowerDefenseType.CTTDBasicBulletType(2, 15, "cttd-bu3") {
                {
                    width = 25f;
                    height = 25f;
                    lifetime = 60f;
                    ammoMultiplier = 1;//装弹倍率
                    spin = 12;
                    fragOnHit = false;
                    pierce = true; //穿透
                    trailLength = 8;
                    trailWidth = 2;
                    //trailColor = 翠.color;
                    frontColor = C("ff93fa"); //前面颜色
                    fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(2, 7, "cttd-bu3")//分裂的子弹
                    {{
                        width = 25f;
                        height = 25f;
                        lifetime = 300f;
                        spin = 12;
                        fragOnHit = false;
                        backColor = Color.valueOf("ffffff"); //背景颜色
                        frontColor = C("ff93fa"); //前面颜色
                        pierce = true;
                        despawnEffect = Fx.none;
                        fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(3.5f, 7, "cttd-bu3")//分裂的子弹
                        {{
                            width = 25f;
                            height = 25f;
                            lifetime = 300f;
                            spin = 18;
                            fragOnHit = false;
                            backColor = Color.valueOf("ffffff"); //背景颜色
                            frontColor = C("ff93fa"); //前面颜色
                            pierce = true;
                            homingPower = 1;
                            homingRange = 150 * 8;
                            despawnEffect = Fx.none;
                        }};
                        fragBullets = 1;//分裂的数量
                        fragRandomSpread = 15f;//分裂的角度
                        fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                        fragVelocityMin = 1f;//随机范围的破片速度最小0。
                        fragVelocityMax = 1f;//随机范围的破片速度最大1。
                        fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                        fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                        despawnEffect = Fx.none;
                        hitEffect = Fx.none;
                    }};
                    fragBullets = 1;//分裂的数量
                    fragRandomSpread = 15f;//分裂的角度
                    fragAngle = 0f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                    fragVelocityMin = 1f;//随机范围的破片速度最小0。
                    fragVelocityMax = 1f;//随机范围的破片速度最大1。
                    fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                    fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                    despawnEffect = Fx.none;
                    hitEffect = Fx.none;
                }
            };
            // 升级前置 = 蓝瑟2;
            consumePower(550 / 60f);
            requirements(Category.turret, with(魂, 750, 魄, 280));
        }};
        繁花2 = new TDPowerTurret("繁花2", 140, 28) {{
            //shootSound = Sounds.shootLancer;
            unitSort = UnitSorts.farthest;//优先最远，攻击单位时的优先选择/closest/farthest/strongest/weakest
            size = 3;
            shootCone = 40F;//瞄准角度
            shoot = new ShootSpread(2, 10f);
            shootType = new CreatorTowerDefenseType.CTTDBasicBulletType(2, 32, "cttd-bu3") {
                {
                    width = 25f;
                    height = 25f;
                    lifetime = 60f;
                    ammoMultiplier = 1;//装弹倍率
                    spin = 12;
                    fragOnHit = false;
                    pierce = true; //穿透
                    trailLength = 8;
                    trailWidth = 2;
                    //trailColor = 翠.color;
                    frontColor = C("84ffab"); //前面颜色
                    fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(2, 20, "cttd-bu3")//分裂的子弹
                    {{
                        width = 25f;
                        height = 25f;
                        lifetime = 300f;
                        spin = 12;
                        fragOnHit = false;
                        backColor = Color.valueOf("00e047"); //背景颜色
                        frontColor = C("84ffab"); //前面颜色
                        pierce = true;
                        despawnEffect = Fx.none;
                        fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(3.5f, 20, "cttd-bu3")//分裂的子弹
                        {{
                            width = 25f;
                            height = 25f;
                            lifetime = 300f;
                            spin = 18;
                            fragOnHit = false;
                            backColor = Color.valueOf("00e047"); //背景颜色
                            frontColor = C("84ffab"); //前面颜色
                            pierce = true;
                            homingPower = 1;
                            homingRange = 150 * 8;
                            despawnEffect = Fx.none;
                            lightningDamage=3;
                            lightningLength=15;
                            lightning=1;
                            lightningColor=C("84ffab");
                            //lightningCone=25;
                        }};
                        fragBullets = 1;//分裂的数量
                        fragRandomSpread = 15f;//分裂的角度
                        fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                        fragVelocityMin = 1f;//随机范围的破片速度最小0。
                        fragVelocityMax = 1f;//随机范围的破片速度最大1。
                        fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                        fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                        despawnEffect = Fx.none;
                        hitEffect = Fx.none;
                    }};
                    fragBullets = 1;//分裂的数量
                    fragRandomSpread = 15f;//分裂的角度
                    fragAngle = 0f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                    fragVelocityMin = 1f;//随机范围的破片速度最小0。
                    fragVelocityMax = 1f;//随机范围的破片速度最大1。
                    fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                    fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                    despawnEffect = Fx.none;
                    hitEffect = Fx.none;
                }
            };
            升级前置 = 繁花1;
            consumePower(1400 / 60f);
            requirements(Category.turret, with(魂, 3800, 魄, 900));
        }};
        冰霜塔1 = new TDItemTurret("冰霜塔1", 14 * 8, 8 * 60, 冰霜塔减速1, 1) {{

            reload = 11 * 60f;
            itemStacks = ItemStack.with(魂, 15);
            consumePower(120 / 60f);
            requirements(Category.turret, with(魂, 100));
            buildType =Build::new;
        }class Build extends TDItemTurret.TDItemTurretBuild{
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }};
        冰霜塔2 = new TDItemTurret("冰霜塔2", 20 * 8, 20 * 60, 冰霜塔减速2, 1) {{
            reload = 20 * 60f;
            升级前置 = 冰霜塔1;
            itemStacks = ItemStack.with(魂, 30, 魄, 5);
            consumePower(500 / 60f);
            requirements(Category.turret, with(魂, 800, 魄, 230));
            buildType =Build::new;

        } class Build extends TDItemTurret.TDItemTurretBuild{
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }};
        冰霜塔3 = new TDItemTurret("冰霜塔3", 33 * 8, 4 * 60, 冰霜塔减速3, 1) {{
            reload = 8 * 60f;
            升级前置 = 冰霜塔2;
            itemStacks = ItemStack.with(星辰,1);
            consumePower(3200 / 60f);
            requirements(Category.turret, with(魂, 1500, 魄, 1200));
            buildType =Build::new;
        }
            class Build extends TDItemTurret.TDItemTurretBuild{
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
                }
            }
        };

        霜冻塔2=new BUFF投影2("霜冻塔2"){{
            armor = 500;
            health = 100;
            升级前置 = 冰霜塔1;
            group = BlockGroup.turrets;
            duration = 60f;//持续
            effect=冰霜塔减速1;
            size = 3;
            reload = 60f;//消耗物品间隔
            range = 13*8f;//范围
            itemStacks = ItemStack.with(魂, 1);
            consumePower(320f / 60);
            requirements(Category.turret, with(魂, 500));
            buildType =Build::new;
        }
        class Build extends BUFF投影2.BUFF投影2Build {
            public void draw() {
                super.draw();
                Draw.blend();
                Draw.color();
                Draw.rect(Core.atlas.find("cttd-霜冻塔3-0"), this.x, this.y);
                Draw.rect(Core.atlas.find("cttd-霜冻塔3-1"), this.x, this.y);
                Draw.rect(Core.atlas.find("cttd-霜冻塔2-2"), this.x, this.y, 90 + Time.time * 2);
            }
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
            }
        }
        };
        霜冻塔3=new BUFF投影2("霜冻塔3"){{
            armor = 500;
            health = 100;
            升级前置 = 霜冻塔2;
            group = BlockGroup.turrets;
            duration = 60f;//持续
            effect=冰霜塔减速2;
            size = 3;
            reload = 60f;//间隔
            range = 17*8f;//范围
            itemStacks = ItemStack.with(魄, 1);
            consumePower(900f / 60);
            requirements(Category.turret, with(魂, 2100));
            buildType =Build::new;

        }
            class Build extends BUFF投影2.BUFF投影2Build {
                public void draw() {
                    super.draw();
                    Draw.blend();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-霜冻塔3-0"), this.x, this.y);
                    Draw.rect(Core.atlas.find("cttd-霜冻塔3-1"), this.x, this.y);
                    Draw.rect(Core.atlas.find("cttd-霜冻塔3-2"), this.x, this.y, 90 + Time.time * 2);
                }
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, C("16b1fe"), 0.65F + Mathf.absin(20.0F, 0.1F));
                }
            }};
        激光炮1 = new TDTractorBeamTurret("激光炮1", 9, 15) {{
            shootCone = 360;
            group = BlockGroup.turrets;
            rotateSpeed = 0;
            consumePower(20f / 60);
            requirements(Category.turret, with(魂, 35));
            buildType = Build::new;

        }
            class Build extends TDTractorBeamTurret.Build  {
                public void draw() {
                    super.draw();
                    Draw.rect(Core.atlas.find("cttd-激光炮1-0"), this.x, this.y);
                    Draw.color(Color.valueOf("FF3030"));
                    Draw.alpha(Mathf.sin(Time.time * 0.04f));
                    Draw.blend(additive);
                    Draw.rect(Core.atlas.find("cttd-激光炮1-1"), this.x, this.y);
                    Draw.blend();
                    Draw.reset();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-激光炮1-2"), this.x, this.y, 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮1-3"), this.x, this.y);
                }
            }};
        激光炮2 = new TDTractorBeamTurret("激光炮2", 24, 19) {{
            shootCone = 360;
            group = BlockGroup.turrets;
            rotateSpeed = 0;
            consumePower(180f / 60);
            升级前置 = 激光炮1;
            requirements(Category.turret, with(魂, 240, 魄, 20));
            buildType = Build::new;

        }
            class Build extends TDTractorBeamTurret.Build  {
                public void draw() {
                    super.draw();
                    Draw.rect(Core.atlas.find("cttd-激光炮2-0"), this.x, this.y);
                    Draw.color(Color.valueOf("FF3030"));
                    Draw.alpha(Mathf.sin(Time.time * 0.04f));
                    Draw.blend(additive);
                    Draw.rect(Core.atlas.find("cttd-激光炮2-1"), this.x, this.y);
                    Draw.blend();
                    Draw.reset();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-激光炮2-2"), this.x, this.y, 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮2-3"), this.x, this.y);
                }
            }};
        激光炮3 = new TDTractorBeamTurret("激光炮3", 55, 25) {{
            shootCone = 360;
            group = BlockGroup.turrets;
            rotateSpeed = 0;
            升级前置 = 激光炮2;
            consumePower(650f / 60);
            requirements(Category.turret, with(魂, 650, 魄, 90));
            buildType = Build::new;

        }
            class Build extends TDTractorBeamTurret.Build  {
                public void draw() {
                    super.draw();
                    Draw.rect(Core.atlas.find("cttd-激光炮3-0"), this.x, this.y);
                    Draw.color(Color.valueOf("FF3030"));
                    Draw.alpha(Mathf.sin(Time.time * 0.04f));
                    Draw.blend(additive);
                    Draw.rect(Core.atlas.find("cttd-激光炮3-1"), this.x, this.y);
                    Draw.blend();
                    Draw.reset();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-激光炮3-2"), this.x, this.y, 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮3-3"), this.x, this.y);
                }
            }};
        激光炮4 = new TDTractorBeamTurret("激光炮4", 90, 30) {{
            shootCone = 360;
            group = BlockGroup.turrets;
            rotateSpeed = 0;
            size = 4;
            升级前置 = 激光炮3;
            consumePower(2300f / 60);
            requirements(Category.turret, with(魂, 2500, 魄, 1000, 星辰, 10));
            buildType = Build::new;

        }
            class Build extends TDTractorBeamTurret.Build  {
                public void draw() {
                    super.draw();
                    Draw.rect(Core.atlas.find("cttd-激光炮4-0"), this.x, this.y);
                    Draw.color(Color.valueOf("FF3030"));
                    Draw.alpha(Mathf.sin(Time.time * 0.04f));
                    Draw.blend(additive);
                    Draw.rect(Core.atlas.find("cttd-激光炮4-1"), this.x, this.y);
                    Draw.blend();
                    Draw.reset();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-激光炮4-2"), this.x, this.y, -90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮4-2"), this.x, this.y, 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮4-3"), this.x, this.y);
                }
            }};
        激光炮5 = new TDLaserTurret("激光炮5", 230f, 45) {{
            requirements(Category.turret,  with(魂, 38000, 魄, 17000, 星辰, 170,无尽星辰,1));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 360f;
            升级前置 = 激光炮4;
            group = BlockGroup.turrets;
            size = 4;
            shake = 2f;
            shootSound = Sounds.none;
            loopSound = Sounds.beamMeltdown;;
            loopSoundVolume = 0.5f;
            recoil = 0;//武器后座
            shootY = 0;//中心发射子弹
            rotateSpeed = 1;
            shootType = new JiGuangFanWeiShangHaiBulletType() {{
                splashDamage = 350;
                splashDamageRadius = 4*8f;
            }};
            coolant = consumeCoolant(0);
             consumePower(8600 / 60f);
            buildType = Build::new;

        }
            class Build extends ContinuousTurret.ContinuousTurretBuild  {
                public void draw() {
                    super.draw();
                    Draw.rect(Core.atlas.find("cttd-激光炮5-0"), this.x, this.y);
                    Draw.color(Color.valueOf("FF3030"));
                    Draw.alpha(Mathf.sin(Time.time * 0.04f));
                    Draw.blend(additive);
                    Draw.rect(Core.atlas.find("cttd-激光炮5-1"), this.x, this.y);
                    Draw.blend();
                    Draw.reset();
                    Draw.color();
                    Draw.rect(Core.atlas.find("cttd-激光炮5-2"), this.x, this.y, -90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮5-2"), this.x, this.y, 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("cttd-激光炮5-3"), this.x, this.y);
                    Draw.rect(Core.atlas.find("cttd-激光炮5-4"), this.x, this.y, 90 + Time.time * 2);
                }
            }};
        光圈.load();
        火焰喷射器1 = new TDPowerTurret("火焰喷射器1", 180, 10) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.shootFlame;
            shoot.shots = 70 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 5f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 20f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 100, 12, 105);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = CreatorTowerDefenseBuff.TDburning;
            }};
            consumePower(150 / 60f);
            requirements(Category.turret, with(魂, 230, 魄, 35));
        }};
        火焰喷射器2 = new TDPowerTurret("火焰喷射器2", 160, 10) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.shootFlame;
            shoot.shots = 90 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 10f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 22f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 100, 12, 100);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = CreatorTowerDefenseBuff.TDburning;
            }};
            升级前置 = 火焰喷射器1;
            consumePower(450 / 60f);
            requirements(Category.turret, with(魂, 930, 魄, 180));
        }};
        火焰喷射器3 = new TDPowerTurret("火焰喷射器3", 120, 13) {{
            shootY = 10;
            shootCone = 50f;
            ammoUseEffect = none;
            shootSound = Sounds.shootFlame;
            shoot.shots = 110 / 6;
            shoot.shotDelay = 6f;
            size = 3;
            inaccuracy = 4;
            shootType = new BulletType(3.35f, 18f) {{
                ammoMultiplier = 1f;
                hitSize = 7f;
                lifetime = 29f;
                pierceBuilding = pierce = true;
                statusDuration = 60f * 4;
                shootEffect = 火焰(60, 130, 22, 120);
                hitEffect = Fx.hitFlameSmall;
                despawnEffect = none;
                status = CreatorTowerDefenseBuff.TDburning;
            }};
            升级前置 = 火焰喷射器2;
            consumePower(1200 / 60f);
            requirements(Category.turret, with(魂, 3200, 魄, 700, 星辰, 20));
        }};

        钉钉塔 = new CTMineCell("钉钉塔") {
            {
                size = 4;
                consumePower(400 / 60f);
                requirements(Category.turret, with(魂, 300, 魄, 20));
                mines = 3;
                floors = TD地板;
                mineConsumes = with();
                mine = new 钉钉子弹(mines, 10);buildType =Build::new;
            }class Build extends CTMineCell.MineCellBuild{
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, Pal.accent, 0.65F + Mathf.absin(20.0F, 0.1F));
                }}
        };
        钉刺塔 = new CTMineCell("钉刺塔") {
            {
                size = 4;
                consumePower(900 / 60f);
                requirements(Category.turret, with(魂, 900, 魄, 400));
                mines = 4;
                floors = TD地板;range=13*8;
                mineConsumes = with();
                mine = new 钉钉子弹(mines, 30);
                buildType =Build::new;

            }class Build extends CTMineCell.MineCellBuild{
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, Pal.accent, 0.65F + Mathf.absin(20.0F, 0.1F));
                }}

        };
        地刺塔 = new CTMineCell("地刺塔") {
            {
                size = 5;
                consumePower(3200 / 60f);
                requirements(Category.turret, with(魂, 2800, 魄, 1200));
                mines = 4;
                floors = TD地板;range=16*8;
                mineConsumes = with();
                mine = new 钉钉子弹(mines, 60);
                buildType =Build::new;
            }class Build extends CTMineCell.MineCellBuild{
            public void drawLight() {
                Drawf.light(this.x, this.y, size*8, Pal.accent, 0.65F + Mathf.absin(20.0F, 0.1F));
            }}
        };
        地刺雷 = new CTMineCell("地刺雷") {
            {
                size = 5;
                consumePower(14000 / 60f);
                requirements(Category.turret, with(魂, 24000, 魄, 8000, 星辰, 100));
                mines = 6;
                floors = TD地板;range=20*8;
                mineConsumes = with();
                mine = new 钉雷子弹(mines, 100, 320, 3);
                buildType =Build::new;
            }class Build extends CTMineCell.MineCellBuild{
                public void drawLight() {
                    Drawf.light(this.x, this.y, size*8, Pal.accent, 0.65F + Mathf.absin(20.0F, 0.1F));
                }}
        };

        熔毁1 = new TDLaserTurret("熔毁1", 230f, 23) {{
            requirements(Category.turret, with(魂, 450, 魄, 80));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            shake = 2f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 0.5f;
            shootType = new ContinuousLaserBulletType(7 / 12f) {{
                length = 23 * 8;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                statusDuration=2*60;
                drawSize = 180f;
                // timescaleDamage = true;

                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};
            coolant = consumeCoolant(0);
            consumePower(500 / 60f);
        }};
        熔毁2 = new TDLaserTurret("熔毁2", 230f, 25) {{
            requirements(Category.turret, with(魂, 720, 魄, 100,星辰,2));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            shake = 2f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 0.5f;
            升级前置 = 熔毁1;
            shootType = new ContinuousLaserBulletType(17 / 12f) {{
                length = 28 * 8;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting; statusDuration=2*60;

                drawSize = 420f / 2;
                // timescaleDamage = true;
                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};
            coolant = consumeCoolant(0);
            consumePower(1200 / 60f);
        }};
        熔毁3 = new TDLaserTurret("熔毁3", 190f, 30) {{
            requirements(Category.turret, with(魂, 3500, 魄, 680,星辰,15));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;

            shake = 2f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 0.5f;
            升级前置 = 熔毁2;
            shootType = new ContinuousLaserBulletType(40 / 12f) {{
                length = 35 * 8;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                statusDuration=2*60;
                drawSize = 420f / 3;
                // timescaleDamage = true;
                shoot.shots = 2;
                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};
            shoot = new ShootSpread(2, 10);
            coolant = consumeCoolant(0);
            consumePower(1800 / 60f);
        }};
        厄运1 = new TDItemTurret("厄运1") {{
            consumePower(500 / 60f);
            itemStacks = ItemStack.with(魂, 1);
            requirements(Category.turret, with(魂, 700, 魄, 100));
            size = 4;
            shootSound = Sounds.shootForeshadow;
            reload = 200;
            range = 50 * 8;    buildCostMultiplier = 2.5f;//建造时间倍
            unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
            shootType = new PointBulletType() {{
                shootEffect = Fx.instShoot;
                hitEffect = Fx.instHit;
                smokeEffect = Fx.smokeCloud;
                trailEffect = Fx.instTrail;
                despawnEffect = Fx.instBomb;
                trailSpacing = 20f;
                damage = 120;
                buildingDamageMultiplier = 0.2f;
                speed = 50 * 8;
                hitShake = 6f;
                ammoMultiplier = 1f;
            }};
        }};
        厄运2 = new TDItemTurret("厄运2") {{
            itemStacks = ItemStack.with(魂, 2);
            consumePower(900 / 60f);
            requirements(Category.turret, with(魂, 1400, 魄, 400));
            升级前置 = 厄运1;
            buildCostMultiplier = 2.5f;//建造时间倍
            size = 4;
            reload = 180;
            range = 60 * 8;
            shootSound = Sounds.shootForeshadow;
            unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
            shootType = new PointBulletType() {{
                shootEffect = Fx.instShoot;
                hitEffect = Fx.instHit;
                smokeEffect = Fx.smokeCloud;
                trailEffect = Fx.instTrail;
                despawnEffect = Fx.instBomb;
                trailSpacing = 20f;
                damage = 300;
                buildingDamageMultiplier = 0.2f;
                speed = 60 * 8;
                hitShake = 6f;
                ammoMultiplier = 1f;
            }};
        }};
        厄运3 = new TDItemTurret("厄运3") {{
            itemStacks = ItemStack.with(魄, 1);

            consumePower(2300 / 60f);
            requirements(Category.turret, with(魂, 3200, 魄, 1300, 星辰, 18));
            升级前置 = 厄运2;
            buildCostMultiplier = 3.5f;//建造时间倍
            unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
            size = 4;
            reload = 80;
            range = 75 * 8;
            shootSound = Sounds.shootForeshadow;
            shootType = new RailBulletType() {{
                shootEffect = Fx.railShoot;
                length = 75 * 8;
                pointEffectSpace = 60f;
                pierceEffect = Fx.railHit;
                pointEffect = Fx.railTrail;
                hitEffect = Fx.massiveExplosion;
                smokeEffect = Fx.shootBig2;
                damage = 650;
                pierceDamageFactor = 0f;//穿透衰减
            }};
        }};
        厄梦2 = new TDItemTurret("厄梦2") {{
            itemStacks = ItemStack.with(魂, 5);
            consumePower(800 / 60f);
            requirements(Category.turret, with(魂, 700, 魄, 400));
            升级前置 = 厄运1;    buildCostMultiplier = 2.5f;//建造时间倍
            unitSort = UnitSorts.farthest;//优先最远
            size = 4;
            reload = 150;
            range = 60 * 8;
            shootSound = Sounds.shootForeshadow;
            shootType = new ArtilleryBulletType() {{
                speed = 5;
                buildingDamageMultiplier = 0.2f;//对建筑的伤害
                hitEffect = Fx.plasticExplosion;
                lifetime = 40;
                width = 30;
                height = 30;
                collidesTiles = false;
                //shoot.shots=3;
                scaleLife = true;//开启指哪打哪
                splashDamageRadius = 4 * 8;
                splashDamage = 130;
                backColor = C("#9C6CD3");
                frontColor = C("#9C6CD3");
                knockback = 3;
                homingPower = 0.08f;
                homingRange = 50f;
            }};
        }};
        厄梦3 = new TDItemTurret("厄梦3") {{
            itemStacks = ItemStack.with(魂, 10);
            unitSort = UnitSorts.farthest;//优先最远
            consumePower(1600 / 60f);
            requirements(Category.turret, with(魂, 2000, 魄, 900, 星辰, 12));
            升级前置 = 厄梦2;    buildCostMultiplier = 2.8f;//建造时间倍
            size = 4;
            reload = 100;
            range = 75 * 8;
            shootSound = Sounds.shootForeshadow;
            shootType = new ArtilleryBulletType() {{
                speed = 5;
                buildingDamageMultiplier = 0.2f;//对建筑的伤害
                hitEffect = Fx.plasticExplosion;
                lifetime = 40;
                width = 35;
                height = 35;
                scaleLife = true;//开启指哪打哪
                collidesTiles = false;
                splashDamageRadius = 5 * 8;
                splashDamage = 300;
                backColor = C("#9C6CD3");
                frontColor = C("#9C6CD3");
                knockback = 3;
                homingPower = 0.08f;
                homingRange = 50f;
            }};
        }};
    }
}



















