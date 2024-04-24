package CreatorTowerDefense.content.Sundry;

import CreatorTowerDefense.content.CreatorTowerDefenseType;
import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Healthc;
import mindustry.type.Category;
import mindustry.world.Block;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static ct.Asystem.type.CTColor.C;
import static mindustry.content.Fx.none;
import static mindustry.type.ItemStack.with;

//太占篇幅，所以搬到这里来
//本代码由 @guiY 提供
public class 光圈 {
    public static Block 光圈1,光圈2,光圈3;
    public static void load() {
        float 速度=20f;
        光圈1=new CreatorTowerDefenseType.TDPowerTurret("光圈1",60,12) {{
            Color TU浅绿色 = Color.valueOf("acff9a");
            range = 12 * 8;
            size = 3;
            shootY=0;
            recoil = 0;//武器后座
            rotateSpeed = 0;
            shootCone = 360;//射击瞄准角度
            //升级前置 = 激光炮3;
            consumePower(50f/60);
            requirements(Category.turret, with(魂, 70,魄,20));
//    requirements(Category.turret, with(魂, 25,魄,800,星辰,300));
            float cont = 360 / 2f;//扩散角度，1/2值，60 = 120
            float bRange = range;//范围
            shootType = new BulletType() {
                {
                    damage = 3;
                    lifetime = 速度;
                    speed = 0;
                    keepVelocity = false;
                    despawnEffect = hitEffect = none;
                    hittable = absorbable = reflectable = false;
                }
                @Override
                public void update(Bullet b) {
                    //super.update(b);
                    Seq<Healthc> seq = new Seq<>();
                    // float r = bRange * (1 - b.foutpow());
                    float r = bRange * (b.fin());
                    Vars.indexer.allBuildings(b.x, b.y, r, bd -> {
                        if (bd.team != b.team && Angles.within(b.rotation(), b.angleTo(bd), cont)) seq.addUnique(bd);
                    });
                    Units.nearbyEnemies(b.team, b.x - r, b.y - r, r * 2, r * 2, u -> {
                        if (u.type != null && u.type.targetable && b.within(u, r) && Angles.within(b.rotation(), b.angleTo(u), cont))
                            seq.addUnique(u);
                    });
                    for (int i = 0; i < seq.size; i++) {
                        Healthc hc = seq.get(i);
                        if (hc != null && !hc.dead()) {
                            if (!b.hasCollided(hc.id())) {
                                //伤害的方式在这里改

                                //普攻
                                hc.damage(damage);

                                //穿甲
                                //hc.damagePierce(damage);

                                //真伤
                                //if(hc.health() <= damage) hc.kill();
                                //else hc.health(hc.health() - damage);
                                b.collided.add(hc.id());
                            }
                        }
                    }
                }
                float dx(float px, float r, float angel) {
                    return px + r * (float) Math.cos(angel * Math.PI / 180);
                }
                float dy(float py, float r, float angel) {
                    return py + r * (float) Math.sin(angel * Math.PI / 180);
                }
                @Override
                public void draw(Bullet b) {
                    super.draw(b);
                    float pin = (b.fin());
                    Lines.stroke(3, TU浅绿色);
                    for (float i = b.rotation() - cont; i < b.rotation() + cont; i++) {
                        float lx = dx(b.x, bRange * pin, i);
                        float ly = dy(b.y, bRange * pin, i);
                        Lines.lineAngle(lx, ly, i - 90, bRange / (cont * 2) * pin);
                        Lines.lineAngle(lx, ly, i + 90, bRange / (cont * 2) * pin);

                    }
                }
            };
        }};
        光圈2=new CreatorTowerDefenseType.TDPowerTurret("光圈2",60,16) {{
            Color TU浅绿色 = Color.valueOf("acff9a");
            range = 16 * 8;
            size = 3;
            升级前置 = 光圈1;
            shootY=0;
            recoil = 0;//武器后座
            rotateSpeed = 0;
            shootCone = 360;//射击瞄准角度
            consumePower(450f/60);
            requirements(Category.turret, with(魂, 820,魄,200));
            float cont = 360 / 2f;//扩散角度，1/2值，60 = 120
            float bRange = range;//范围
            shootType = new BulletType() {
                {
                    damage = 9;
                    lifetime = 速度;
                    speed = 0;
                    keepVelocity = false;
                    despawnEffect = hitEffect = none;
                    hittable = absorbable = reflectable = false;
                }
                @Override
                public void update(Bullet b) {
                    //super.update(b);
                    Seq<Healthc> seq = new Seq<>();
                    // float r = bRange * (1 - b.foutpow());
                    float r = bRange * (b.fin());
                    Vars.indexer.allBuildings(b.x, b.y, r, bd -> {
                        if (bd.team != b.team && Angles.within(b.rotation(), b.angleTo(bd), cont)) seq.addUnique(bd);
                    });
                    Units.nearbyEnemies(b.team, b.x - r, b.y - r, r * 2, r * 2, u -> {
                        if (u.type != null && u.type.targetable && b.within(u, r) && Angles.within(b.rotation(), b.angleTo(u), cont))
                            seq.addUnique(u);
                    });
                    for (int i = 0; i < seq.size; i++) {
                        Healthc hc = seq.get(i);
                        if (hc != null && !hc.dead()) {
                            if (!b.hasCollided(hc.id())) {
                                //伤害的方式在这里改

                                //普攻
                                hc.damage(damage);

                                //穿甲
                                //hc.damagePierce(damage);

                                //真伤
                                //if(hc.health() <= damage) hc.kill();
                                //else hc.health(hc.health() - damage);
                                b.collided.add(hc.id());
                            }
                        }
                    }
                }
                float dx(float px, float r, float angel) {
                    return px + r * (float) Math.cos(angel * Math.PI / 180);
                }
                float dy(float py, float r, float angel) {
                    return py + r * (float) Math.sin(angel * Math.PI / 180);
                }
                @Override
                public void draw(Bullet b) {
                    super.draw(b);
                    float pin = (b.fin());
                    Lines.stroke(3,  C("#00cfa0"));
                    for (float i = b.rotation() - cont; i < b.rotation() + cont; i++) {
                        float lx = dx(b.x, bRange * pin, i);
                        float ly = dy(b.y, bRange * pin, i);
                        Lines.lineAngle(lx, ly, i - 90, bRange / (cont * 2) * pin);
                        Lines.lineAngle(lx, ly, i + 90, bRange / (cont * 2) * pin);

                    }
                }
            };
        }};
        光圈3=new CreatorTowerDefenseType.TDPowerTurret("光圈3",40,22) {{
            Color TU浅绿色 = Color.valueOf("acff9a");
            range = 22 * 8;
            size = 3;
            升级前置 = 光圈2;
            shootY=0;
            recoil = 0;//武器后座
            rotateSpeed = 0;
            shootCone = 360;//射击瞄准角度
            consumePower(1520f/60);
           // requirements(Category.turret, with(魂, 25));
            requirements(Category.turret, with(魂, 7300,魄,2800,星辰,50));
            float cont = 360 / 2f;//扩散角度，1/2值，60 = 120
            float bRange = range;//范围
            shootType = new BulletType() {
                {
                    damage = 22;
                    lifetime = 速度;
                    speed = 0;
                    keepVelocity = false;
                    despawnEffect = hitEffect = none;
                    hittable = absorbable = reflectable = false;
                }
                @Override
                public void update(Bullet b) {
                    //super.update(b);
                    Seq<Healthc> seq = new Seq<>();
                    // float r = bRange * (1 - b.foutpow());
                    float r = bRange * (b.fin());
                    Vars.indexer.allBuildings(b.x, b.y, r, bd -> {
                        if (bd.team != b.team && Angles.within(b.rotation(), b.angleTo(bd), cont)) seq.addUnique(bd);
                    });
                    Units.nearbyEnemies(b.team, b.x - r, b.y - r, r * 2, r * 2, u -> {
                        if (u.type != null && u.type.targetable && b.within(u, r) && Angles.within(b.rotation(), b.angleTo(u), cont))
                            seq.addUnique(u);
                    });
                    for (int i = 0; i < seq.size; i++) {
                        Healthc hc = seq.get(i);
                        if (hc != null && !hc.dead()) {
                            if (!b.hasCollided(hc.id())) {
                                //伤害的方式在这里改

                                //普攻
                                hc.damage(damage);

                                //穿甲
                                //hc.damagePierce(damage);

                                //真伤
                                //if(hc.health() <= damage) hc.kill();
                                //else hc.health(hc.health() - damage);
                                b.collided.add(hc.id());
                            }
                        }
                    }
                }
                float dx(float px, float r, float angel) {
                    return px + r * (float) Math.cos(angel * Math.PI / 180);
                }
                float dy(float py, float r, float angel) {
                    return py + r * (float) Math.sin(angel * Math.PI / 180);
                }
                @Override
                public void draw(Bullet b) {
                    super.draw(b);
                    float pin = (b.fin());
                    Lines.stroke(3,  C("#00bced"));
                    for (float i = b.rotation() - cont; i < b.rotation() + cont; i++) {
                        float lx = dx(b.x, bRange * pin, i);
                        float ly = dy(b.y, bRange * pin, i);
                        Lines.lineAngle(lx, ly, i - 90, bRange / (cont * 2) * pin);
                        Lines.lineAngle(lx, ly, i + 90, bRange / (cont * 2) * pin);

                    }
                }
            };
        }};
    }
}
