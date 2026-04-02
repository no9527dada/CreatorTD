package CreatorTowerDefense.content;

import arc.graphics.Color;
import CtCoreSystem.CoreSystem.type.CTUnitSpawnAbility;
import CtCoreSystem.CoreSystem.type.OnlyAttackCoreAI;
import CtCoreSystem.CoreSystem.type.Ovulam5480.TDRoundBUFFAbility;
import mindustry.Vars;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.DefenderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;

import static CreatorTowerDefense.content.CreatorTowerDefenseBuff.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDUnitType;
import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static CtCoreSystem.ui.NanDu.WorldDifficulty.cheat;
import static mindustry.content.StatusEffects.burning;
import static mindustry.content.StatusEffects.freezing;

//方块
public class CreatorTowerDefenseUnits {
    public static UnitType 星尘单位, 星灵单位, 凝蓝单位, 蚀魂单位,创世微子,U星辰,W星辰;
    public static TDUnitType /*U星辰,W星辰,*/沙 , 铜, 铅, 煤炭, 石英, 玻璃,石墨 ,碳板 ,
            硅, 石墨烯, 硫化物,硅晶体 , 钛,钍 ,冷却液 , 液氮, 塑钢
            ,相织布 ,紫晶 ,金 , 电池,钛合金, 钻石,巨浪合金 ,魔力石 , 微晶 ,粒子,创世之星;
    public static TDUnitType 爆混,孢子荚 ;

    public static StatusEffect 加速状态仪Buff= new StatusEffect("加速状态仪") {{
        speedMultiplier = 2;
    }};;
    public static void load() {
         U星辰 = new UnitType("dt星辰") {{
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
           // hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
             engineOffset = 0F;
             physics = false;//关闭碰撞
              createWreck = false;
             createScorch = false;

             flying=true;
             constructor = UnitTypes.flare.constructor;
             weapons.add(new Weapon() {{
                 autoTarget = true;//被动开火?
                 shootOnDeath = true;//当它的主人死后，这把武器是否应该开火
                 reload = 30;
                 shootCone = 180;
                 ejectEffect = Fx.none;
                 shootSound = Sounds.explosion;
                 inaccuracy = 0;
                 x = 0;
                 shootY = 0;
                 mirror = false;
             bullet = new BasicBulletType(3, 0, "ctdt-透明") {{
                 width = 0.1f;
                 height = 0.1f;
                 collidesAir = false;
                 collidesGround = true;
                 lifetime = 3;
                 collides = collidesTiles = true;
                 hitSound = Sounds.explosion;
                 hitEffect = Fx.none;
                 killShooter = true;//射击后死亡
                 hittable = false;//这颗子弹能否被点防击中
                 homingPower = 1;
                 fragBullet = new BasicBulletType(0f, 0, "ctdt-透明")//分裂的子弹
                 {{
                     homingPower = 1;
                     width = 0.1f;
                     height = 0.1f;
                     lifetime = 20f;
                     shrinkY = 0;
                     shrinkX = 0;
                     despawnEffect = Fx.none;
                 }};
                 fragBullets = 1;//分裂的数量
                 fragRandomSpread = 0f;//分裂的角度
             }};  }});
        }};//奖励单位，没有伤害
         W星辰 = new UnitType("dt无尽星辰") {{
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
           // hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
             createWreck = false;
             createScorch = false;
             engineOffset = 0F;
             flying=true;
             constructor = UnitTypes.flare.constructor;
             weapons.add(new Weapon() {{
                 autoTarget = true;//被动开火?
                 shootOnDeath = true;//当它的主人死后，这把武器是否应该开火
                 reload = 30;
                 shootCone = 180;
                 ejectEffect = Fx.none;
                 shootSound = Sounds.explosion;
                 inaccuracy = 0;
                 x = 0;
                 shootY = 0;
                 mirror = false;
             bullet = new BasicBulletType(3, 0, "ctdt-透明") {{
                 width = 0.1f;
                 height = 0.1f;
                 collidesAir = false;
                 collidesGround = true;
                 lifetime = 3;
                 collides = collidesTiles = true;
                 hitSound = Sounds.explosion;
                 hitEffect = Fx.none;
                 killShooter = true;//射击后死亡
                 hittable = false;//这颗子弹能否被点防击中
                 homingPower = 1;
                 fragBullet = new BasicBulletType(0f, 0, "ctdt-透明")//分裂的子弹
                 {{
                     homingPower = 1;
                     width = 0.1f;
                     height = 0.1f;
                     lifetime = 20f;
                     shrinkY = 0;
                     shrinkX = 0;
                     despawnEffect = Fx.none;
                 }};
                 fragBullets = 1;//分裂的数量
                 fragRandomSpread = 0f;//分裂的角度
             }};  }});
        }};//奖励单位，没有伤害
        沙 = new TDUnitType("dt沙", 1, 10, 0.5f){{deathSound= Vars.tree.loadSound("m11");}};
        铜 = new TDUnitType("dt铜", 1, 20, 0.5f){{deathSound= Vars.tree.loadSound("m2");}};
        铅 = new TDUnitType("dt铅", 1, 10, 1.5f){{deathSound= Vars.tree.loadSound("m9");immunities.addAll(cheat,加速状态仪Buff);}};
        煤炭 = new TDUnitType("dt煤炭", 1, 30, 0.5f){{deathSound= Vars.tree.loadSound("m4");}};
        石英 = new TDUnitType("dt石英", 2, 30, 0.5f) {{
            abilities.add(new SpawnDeathAbility(沙, 2, 8));
            Vars.tree.loadSound("m1");
        }};
         玻璃 = new TDUnitType("dt玻璃", 2, 35, 0.8f) {{
            abilities.add(new SpawnDeathAbility(铅, 1, 8));
            Vars.tree.loadSound("m3");
        }};
         石墨 = new TDUnitType("dt石墨", 2, 40, 0.5f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 1, 8));
            Vars.tree.loadSound("m7");
        }};
         碳板 = new TDUnitType("dt碳板", 2, 50, 0.5f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 2, 8));
            Vars.tree.loadSound("m9");
        }};
         硅 = new TDUnitType("dt硅", 3, 30, 2.5f){{
            immunities.addAll(cheat,加速状态仪Buff);}};
         石墨烯 = new TDUnitType("dt石墨烯", 3, 100, 0.75f) {{
            abilities.add(new SpawnDeathAbility(石墨, 2, 8));
        }};
         硫化物 = new TDUnitType("dt硫化物", 3, 180, 0.3f) {{
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
        }};
         硅晶体 = new TDUnitType("dt硅晶体", 4, 270, 0.5f) {{
            abilities.add(new RepairFieldAbility(80f, 60f * 2, 4 * 8f));
            deathSound= Vars.tree.loadSound("m8");
        }};//加血

         钛 = new TDUnitType("dt钛", 4, 220, 0.5f) {{
            abilities.add(new ForceFieldAbility(3 * 8f, 30/60f, 150f, 60f * 3, 8, 0f));
            deathSound= Vars.tree.loadSound("m10");
        }};//力场
         钍 = new TDUnitType("dt钍", 5, 500, 0.3f) {{
            abilities.add(new CTUnitSpawnAbility(石墨烯, 60 * 8, 0, 0));
            deathSound= Vars.tree.loadSound("m11");
        }};//生产单位
         冷却液 = new TDUnitType("dt冷却液", 4, 90, 0.5f) {{// 免疫潮湿 冷冻 免疫燃烧 范围队友免疫燃烧
            // abilities.add(new SpawnDeathAbility(钍, 2, 8));
            deathSound= Vars.tree.loadSound("m4");
            immunities.addAll(cheat,freezing,burning,冰霜塔减速1);//
            abilities.add(new TDRoundBUFFAbility(冷却液免疫,2,1,5*8,C("62f8ed")));
        }};
         液氮 = new TDUnitType("dt液氮", 4, 240, 0.5f) {{// 免疫潮湿 冷冻 免疫燃烧 范围队友免疫冰冻
           // abilities.add(new SpawnDeathAbility(钍, 2, 8));
            deathSound= Vars.tree.loadSound("m6");
            immunities.addAll(cheat,burning,freezing,冰霜塔减速1,冰霜塔减速2,冰霜塔减速3);//自身免疫潮湿 冷冻 燃烧 免疫所有冰霜塔状态
            abilities.add(new TDRoundBUFFAbility(液氮免疫,2,1,13*8,Color.white));
        }};
         塑钢 = new TDUnitType("dt塑钢", 5, 520, 0.5f) {{
            deathSound= Vars.tree.loadSound("m1");
            abilities.add(new StatusFieldAbility(塑钢加血, 60f * 3, 60f * 6f, 4 * 8f));
        }};
         相织布 = new TDUnitType("dt相织布", 6, 520, 0.5f) {{
            deathSound= Vars.tree.loadSound("m9");
            abilities.add(new StatusFieldAbility(相织布移速, 60f * 10, 60f * 6f, 4 * 8f));
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
            immunities.addAll(cheat,加速状态仪Buff);
        }};
         紫晶 = new TDUnitType("dt紫晶", 5, 400, 0.5f) {{//给队友加盾量
            abilities.add(new SpawnDeathAbility(硅晶体, 1, 8));
            abilities.add(new ShieldRegenFieldAbility(100f, 20000f, 60f * 2, 4*8f));//加盾每次加100  最大加2W
            Vars.tree.loadSound("m7");
        }};
         金 = new TDUnitType("dt金", 8, 380, 0.5f) {{
            deathSound= Vars.tree.loadSound("m7");
            abilities.add(new StatusFieldAbility(金加速, 60f * 5, 10f * 60f, 4 * 8f));
            abilities.add(new SpawnDeathAbility(钍, 1, 8));
            immunities.addAll(cheat,加速状态仪Buff);
        }};
         电池 = new TDUnitType("dt电池", 10, 600, 0.6f) {{
            abilities.add(new SpawnDeathAbility(石墨烯, 3, 8));
            armor=1;
        }};//
         钛合金 = new TDUnitType("dt钛合金", 15, 1500, 0.5f) {{
            abilities.add(new SpawnDeathAbility(钛, 3, 8)); armor=3;

        }};
         钻石 = new TDUnitType("dt钻石", 20, 5000, 0.7f) {{
            abilities.add(new SpawnDeathAbility(钍, 2, 8)); armor=5;
            deathSound= Vars.tree.loadSound("m5");
        }};
       // coreLaunchConstruct
         巨浪合金 = new TDUnitType("dt巨浪合金", 25, 10000, 0.5f) {{
            armor=2;
            deathSound= Vars.tree.loadSound("m11");
            abilities.add(
                    new CTUnitSpawnAbility(铜, 60 * 3, 0, 0),
                    new CTUnitSpawnAbility(硅, 60 * 5, 0, 0),
                    new CTUnitSpawnAbility(铅, 60 * 3, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 9, 0, 0));
        }};
         魔力石 = new TDUnitType("dt魔力石", 25, 24000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m6"); armor=3;
            abilities.add(
                    new CTUnitSpawnAbility(相织布, 60 * 8, 0, 0),
                    new CTUnitSpawnAbility(硅晶体, 60 * 7, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 5, 0, 0));
        }};
         微晶 = new TDUnitType("dt微晶", 35, 60000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m5"); armor=6;
            abilities.add(
                    new CTUnitSpawnAbility(石英, 60 * 0.7f, 0, 0),
                    new CTUnitSpawnAbility(钍, 60 * 5, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 7, 0, 0));
        }};//生产单位;
        粒子 = new TDUnitType("dt粒子", 50, 130000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m4"); armor=10;
           // abilities.add(new StatusFieldAbility(粒子抗伤, 60f * 20, 19f * 60f, 60 * 8f));
            abilities.add(
                    new CTUnitSpawnAbility(紫晶, 60 * 7f, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 7, 0, 0));
        }};
        //特殊单位 飞行 奶妈AI
        创世微子 = new UnitType("dt创世微子") {{
            flying = true;
            health = 100;
            speed = 2f;
            hitSize = 8f;
            isEnemy = false;//不加入敌人波次列表，仅用于创世之星单位产出
            aiController = DefenderAI::new;
            abilities.add(new RepairFieldAbility(5000f, 60f * 2, 5 * 8f));
            deathSound= Vars.tree.loadSound("m8");
            constructor = UnitTypes.oct.constructor;
        }};//加血
        创世之星 = new TDUnitType("dt创世之星", 101, 200000, 0.4f) {{
            deathSound= Vars.tree.loadSound("m4"); armor=10;
            abilities.add(
                    new CTUnitSpawnAbility(创世微子, 60 * 20f, 0, 0),
                    new CTUnitSpawnAbility(微晶, 60 * 90, 0, 0));
        }};



        爆混 = new TDUnitType("dt爆混", 101, 60000, 0.015f) {{
            deathSound= Vars.tree.loadSound("m4"); armor=1;
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
            hitSize = 24f; physics = false;//关闭碰撞
            abilities.add(new RepairFieldAbility(100f, 60f * 30, 1 * 8f));
        }};
        孢子荚 = new TDUnitType("dt孢子荚", 101, 100000, 0.015f) {{
            deathSound= Vars.tree.loadSound("m4"); armor=7;
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
            hitSize = 24f; physics = false;//关闭碰撞
            abilities.add(new RepairFieldAbility(100f, 60f * 30, 1 * 8f));
        }};

        /*单位工厂的单位*/

        星尘单位 = new UnitType("星尘") {{
            defaultCommand = UnitCommand.rebuildCommand;
            flying = true;
            drag = 0.05f;
            speed = 4f;
            armor = 500;
            rotateSpeed = 15f;
            accel = 0.1f;
            range = 130f;
            health = 260;
            buildSpeed = 0.5f;
            engineOffset = 3.5f;
            engineSize=2f;
           // envEnabled = Evn2.TD标记;
            hitSize = 8f;
            lowAltitude = true;
            ammoType = new ItemAmmoType(魂);
            hittable = false;//被子弹击中
            killable = true;//被杀死
            targetable = false;//被敌人瞄准
            constructor = UnitTypes.poly.constructor;
            abilities.add(new StatusFieldAbility( 减血, 60f * 6, 60f * 5f, 1f){{activeEffect =applyEffect = Fx.none;   display = false;}});

        }};
        星灵单位 = new UnitType("星灵") {{
            controller = u -> new  OnlyAttackCoreAI.DevourSpiritAI();
                 //   envEnabled = Evn2.TD标记;
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
            killable = true;//被杀死,这里需要打开，保证在刷怪圈内会被死亡
            playerControllable = false;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
           // armor = 500;
            flying = true;
            health = 150;
            engineOffset = 5.75f;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
            //targetAir = false;
            //targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 9;
            abilities.add(new StatusFieldAbility(减血, 60f * 1, 0, 1f){{activeEffect =applyEffect = Fx.none;   display = false;}});
            weapons.add(new Weapon() {{
                y = 0f;
                x = 2f;
                reload = 50f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 8) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 30f;
                    homingPower = 0.5f;
                    homingRange = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.shoot ;
            }});
        }};
        凝蓝单位 = new UnitType("凝蓝") {{
            aiController = OnlyAttackCoreAI.DevourSpiritAI::new;
          //  envEnabled = Evn2.TD标记;
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
            killable = true;//被杀死,这里需要打开，保证在刷怪圈内会被死亡
            playerControllable = false;
            speed = 2.7f;
            accel = 0.08f;
            armor = 500;
            drag = 0.04f;
            flying = true;
            health = 1050;
            engineOffset = 5.75f;
            hitSize = 9;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
            abilities.add(new StatusFieldAbility(减血, 60f * 6, 60f * 5f, 1f){{activeEffect =applyEffect = Fx.none;   display = false;}});
            weapons.add(new Weapon("zenith-missiles") {{
                reload = 60f;
                x = 7f;
                rotate = true;
                shake = 1f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.shootMissile;
                bullet = new MissileBulletType(3f, 0) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 25f;
                    splashDamage = 15f;
                    lifetime = 40f;
                    trailColor = Pal.unitBack;
                    backColor = Pal.unitBack;
                    frontColor = Pal.unitFront;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};
            }});
        }};
        蚀魂单位 = new UnitType("蚀魂") {{
            aiController = OnlyAttackCoreAI.DevourSpiritAI::new;
            //envEnabled = Evn2.TD标记;
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
            killable = true;//被杀死,这里需要打开，保证在刷怪圈内会被死亡
            playerControllable = false;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            armor = 500;
            flying = true;
            health = 320*7+50;
            engineOffset = 5.75f;
            hitSize = 9;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
            abilities.add(new StatusFieldAbility(减血, 60f * 6, 60f * 5f, 1f){{activeEffect =applyEffect = Fx.none;   display = false;}});
            weapons.add(new Weapon("vela-weapon") {{
                mirror = false;
                top = false;
                shake = 4f;
                shootY = 14f;
                x = y = 0f;

                shoot.firstShotDelay = Fx.greenLaserChargeSmall.lifetime - 1f;
                parentizeEffects = true;

                reload = 155f;
                recoil = 0f;
                chargeSound = Sounds.chargeVela;
                shootSound = Sounds.beamPlasma;
                initialShootSound = Sounds.shootBeamPlasma;
                continuous = true;
                cooldownTime = 180f;

                bullet = new ContinuousLaserBulletType() {{
                    damage = 45 / 12f;
                    length = 180f;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 160f;
                    shake = 1f;
                    despawnEffect = Fx.smokeCloud;
                    smokeEffect = Fx.none;

                    chargeEffect = Fx.greenLaserChargeSmall;

                    incendChance = 0.1f;
                    incendSpread = 5f;
                    incendAmount = 1;

                    //constant healing
                    healPercent = 1f;
                    collidesTeam = true;

                    colors = new Color[]{Pal.heal.cpy().a(.2f), Pal.heal.cpy().a(.5f), Pal.heal.cpy().mul(1.2f), Color.white};
                }};

                shootStatus = StatusEffects.slow;
                shootStatusDuration = bullet.lifetime + shoot.firstShotDelay;
            }});
        }};


    }
}