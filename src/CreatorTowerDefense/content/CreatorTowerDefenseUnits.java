package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.Evn2;
import ct.Asystem.type.CTUnitSpawnAbility;
import ct.Asystem.type.OnlyAttackCoreAI;
import ct.Asystem.type.UnitDeathReward;
import mindustry.Vars;
import mindustry.ai.UnitCommand;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDUnitType;
import static ct.Asystem.type.CTlib.loadSound;
import static mindustry.content.UnitTypes.dagger;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseUnits {
    public static UnitType 星尘单位, 星灵单位, 凝蓝单位, 蚀魂单位;

    public static void load() {


        TDUnitType U星辰 = new TDUnitType("dt星辰", 0, 30, 3f) {{
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
        }};//奖励单位，没有伤害
        TDUnitType W星辰 = new TDUnitType("dt无尽星辰", 0, 30, 3f) {{
            immunities.addAll(Vars.content.statusEffects());//免疫任何BUFF
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
        }};//奖励单位，没有伤害
        TDUnitType 沙 = new TDUnitType("dt沙", 1, 10, 0.5f){{deathSound= Vars.tree.loadSound("m11");}};
        TDUnitType 铜 = new TDUnitType("dt铜", 1, 20, 0.5f){{deathSound= Vars.tree.loadSound("m2");}};
        TDUnitType 铅 = new TDUnitType("dt铅", 1, 10, 1.5f){{deathSound= Vars.tree.loadSound("m9");}};
        TDUnitType 煤炭 = new TDUnitType("dt煤炭", 1, 30, 0.5f){{deathSound= Vars.tree.loadSound("m4");}};
        TDUnitType 石英 = new TDUnitType("dt石英", 2, 30, 0.5f) {{
            abilities.add(new SpawnDeathAbility(沙, 2, 8));
            Vars.tree.loadSound("m1");
        }};
        TDUnitType 玻璃 = new TDUnitType("dt玻璃", 2, 35, 0.8f) {{
            abilities.add(new SpawnDeathAbility(铅, 1, 8));
            Vars.tree.loadSound("m3");
        }};
        TDUnitType 石墨 = new TDUnitType("dt石墨", 2, 40, 0.5f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 1, 8));
            Vars.tree.loadSound("m7");
        }};
        TDUnitType 碳板 = new TDUnitType("dt碳板", 2, 50, 0.5f) {{
            abilities.add(new SpawnDeathAbility(煤炭, 2, 8));
            Vars.tree.loadSound("m9");
        }};
        TDUnitType 硅 = new TDUnitType("dt硅", 3, 30, 2.5f);
        TDUnitType 石墨烯 = new TDUnitType("dt石墨烯", 3, 100, 0.75f) {{
            abilities.add(new SpawnDeathAbility(石墨, 2, 8));
        }};
        TDUnitType 硫化物 = new TDUnitType("dt硫化物", 3, 180, 0.3f) {{
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
        }};
        TDUnitType 硅晶体 = new TDUnitType("dt硅晶体", 4, 270, 0.5f) {{
            abilities.add(new RepairFieldAbility(30f, 60f * 2, 4 * 8f));
            deathSound= Vars.tree.loadSound("m8");
        }};//加血
        TDUnitType 钛 = new TDUnitType("dt钛", 4, 220, 0.5f) {{
            abilities.add(new ForceFieldAbility(3 * 8f, 30/60f, 150f, 60f * 3, 8, 0f));
            deathSound= Vars.tree.loadSound("m10");
        }};//力场
        TDUnitType 钍 = new TDUnitType("dt钍", 5, 500, 0.3f) {{
            abilities.add(new CTUnitSpawnAbility(石墨烯, 60 * 15, 0, 0));
            deathSound= Vars.tree.loadSound("m11");
        }};//生产单位
        TDUnitType 塑钢 = new TDUnitType("dt塑钢", 5, 320, 0.5f) {{
            deathSound= Vars.tree.loadSound("m1");
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiaxue") {{
                show = false;healthMultiplier = 2f;//血量倍率
                localizedName= Core.bundle.format("status."+name+".name", healthMultiplier*100);
            }}, 60f * 3, 60f * 6f, 4 * 8f));
        }};
        TDUnitType 相织布 = new TDUnitType("dt相织布", 6, 260, 0.5f) {{
            deathSound= Vars.tree.loadSound("m9");
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiasu") {{
                show = false;speedMultiplier = 1.8f;//移速
                localizedName= Core.bundle.format("status."+name+".name", speedMultiplier*100);
            }}, 60f * 10, 60f * 6f, 4 * 8f));
            abilities.add(new SpawnDeathAbility(硅, 1, 8));
        }};
        TDUnitType 金 = new TDUnitType("dt金", 8, 380, 0.5f) {{
            deathSound= Vars.tree.loadSound("m7");
            abilities.add(new StatusFieldAbility(new StatusEffect("tdjiasu2") {{
                show = false;speedMultiplier = 3.2f;//移速
                localizedName= Core.bundle.format("status."+name+".name", speedMultiplier*100);
            }}, 60f * 5, 90f * 60f, 1f));
            abilities.add(new SpawnDeathAbility(钍, 1, 8));
        }};
        TDUnitType 电池 = new TDUnitType("dt电池", 10, 600, 0.6f) {{
            abilities.add(new SpawnDeathAbility(石墨烯, 3, 8));
        }};//
        TDUnitType 钛合金 = new TDUnitType("dt钛合金", 15, 1500, 0.5f) {{
            abilities.add(new SpawnDeathAbility(钛, 3, 8));
        }};
        TDUnitType 钻石 = new TDUnitType("dt钻石", 20, 5000, 0.7f) {{
            abilities.add(new SpawnDeathAbility(钍, 2, 8));
            deathSound= Vars.tree.loadSound("m5");
        }};

        TDUnitType 巨浪合金 = new TDUnitType("dt巨浪合金", 25, 5000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m11");
            abilities.add(
                    new CTUnitSpawnAbility(铜, 60 * 3, 0, 0),
                    new CTUnitSpawnAbility(硅, 60 * 5, 0, 0),
                    new CTUnitSpawnAbility(铅, 60 * 3, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 9, 0, 0));
        }};
        TDUnitType 魔力石 = new TDUnitType("dt魔力石", 30, 9000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m6");
            abilities.add(
                    new CTUnitSpawnAbility(相织布, 60 * 8, 0, 0),
                    new CTUnitSpawnAbility(硅晶体, 60 * 7, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 5, 0, 0));
        }};
        TDUnitType 微晶 = new TDUnitType("dt微晶", 50, 20000, 0.5f) {{
            deathSound= Vars.tree.loadSound("m5");
            abilities.add(
                    new CTUnitSpawnAbility(石英, 60 * 0.7f, 0, 0),
                    new CTUnitSpawnAbility(钍, 60 * 5, 0, 0),
                    new CTUnitSpawnAbility(钛, 60 * 15, 0, 0));
        }};//生产单位;
        UnitDeathReward.getInstance().init()
                .add(U星辰, with(星越星辰, 1))
                .add(W星辰, with(无尽星辰, 1))
                .add(沙, with(魂, 1))
                .add(铜, with(魂, 1))
                .add(铅, with(魂, 1))
                .add(煤炭, with(魂, 2, 魄, 1))
                .add(玻璃, with(魂, 3, 魄, 1))
                .add(碳板, with(魂, 4, 魄, 3))
                .add(石墨, with(魂, 4, 魄, 2))
                .add(石墨烯, with(魂, 6, 魄, 2))
                .add(硅, with(魂, 2, 魄, 4))
                .add(硅晶体, with(魂, 4, 魄, 4))
                .add(石英, with(魂, 3, 魄, 2))
                .add(钛, with(魂, 10, 魄, 5))
                .add(硫化物, with(魂, 7, 魄, 3))
                .add(钍, with(魂, 13, 魄, 7))
                .add(塑钢, with(魂, 20, 魄, 9))
                .add(相织布, with(魂, 22, 魄, 8))
                .add(金, with(魂, 30, 魄, 7))
                .add(电池, with(魂, 45, 魄, 13, 星辰, 2))
                .add(钛合金, with(魂, 60, 魄, 18, 星辰, 3))
                .add(钻石, with(魂, 90, 魄, 25, 星辰, 3))
                //boss
                .add(巨浪合金, with(魂, 200, 魄, 80, 星辰, 10))
                .add(魔力石, with(魂, 150, 魄, 130, 星辰, 20))
                .add(微晶, with(魂, 500, 魄, 200, 星辰, 50))
        ;

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
            health = 100;
            buildSpeed = 0.5f;
            engineOffset = 3.5f;
            engineSize=2f;
           // envEnabled = Evn2.TD标记;
            hitSize = 8f;
            lowAltitude = true;
            ammoType = new ItemAmmoType(魂);
            hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            constructor = UnitTypes.poly.constructor;
        }};
        星灵单位 = new UnitType("星灵") {{
            controller = u -> new  OnlyAttackCoreAI.DevourSpiritAI();
                 //   envEnabled = Evn2.TD标记;
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
            killable = true;//被杀死,这里需要打开，保证在刷怪圈内会被死亡
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            armor = 500;
            flying = true;
            health = 100;
            engineOffset = 5.75f;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
            //targetAir = false;
            //targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 9;
            //itemCapacity = 10;
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
                shootSound = Sounds.pew;
            }});
        }};
        凝蓝单位 = new UnitType("凝蓝") {{
            aiController = OnlyAttackCoreAI.DevourSpiritAI::new;
          //  envEnabled = Evn2.TD标记;
            hittable = false;//被子弹击中
            targetable = false;//被敌人瞄准
            killable = true;//被杀死,这里需要打开，保证在刷怪圈内会被死亡
            speed = 2.7f;
            accel = 0.08f;
            armor = 500;
            drag = 0.04f;
            flying = true;
            health = 100;
            engineOffset = 5.75f;
            hitSize = 9;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
            weapons.add(new Weapon("zenith-missiles") {{
                reload = 60f;
                x = 7f;
                rotate = true;
                shake = 1f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
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
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            armor = 500;
            flying = true;
            health = 100;
            engineOffset = 5.75f;
            hitSize = 9;
            constructor = UnitTypes.flare.constructor;
            ammoType = new ItemAmmoType(魂);
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
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
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