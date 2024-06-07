package CreatorTowerDefense;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.struct.Seq;
import mindustry.content.StatusEffects;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;

import static CreatorTowerDefense.content.CreatorTowerDefenseBuff.dd;
import static mindustry.content.Fx.none;

public class knapsack {
    public static String ModName = "cttd";

    public static String name(String add) {
        return ModName + "-" + add;
    }

    public static Seq<String> TD地板 = Seq.with(
            ("cttd-TD地板1"),
            ("cttd-TD地板2"),
            ("cttd-TD地板3"),
            ("cttd-TD地板4"),
            ("cttd-TD地板5"),
            ("cttd-TD地板6"),
            ("cttd-TD地板7"),
            ("cttd-TD地板8")
    );

    public static class 钉钉子弹 extends BulletType {
             public 钉钉子弹(int 子弹数量, int 伤害) {
            lifetime = 120 * 60;
            damage = 伤害;
            pierceArmor = true;
            collidesTiles = false;
            hitEffect = despawnEffect = none;
            ammoMultiplier = 子弹数量;
            hitSize = 6;
                 status = dd;
                 statusDuration = 60f*3;
        }
        @Override
        public void draw(Bullet b) {
            super.draw(b);
            if (!(b.data instanceof Float f)) return;
            float z = Draw.z();
            Draw.z(Layer.blockOver + 1);
            Draw.color(Pal.gray);
            for (int i = 0; i < 3; i++) {
                Draw.color(Pal.gray);
                Drawf.tri(b.x, b.y, 1.2f, 3.2f, f + 120 * i);
                Draw.color(b.team.color);
                Drawf.tri(b.x, b.y, 0.9f, 2.6f, f + 120 * i);
            }
            Draw.reset();
            Draw.z(z);
        }
    }
    public static class 钉雷子弹 extends BulletType {
        int cap = 5;//每个雷有几个钉刺
        public 钉雷子弹(int 子弹数量, int 伤害,int 爆炸伤害,int 爆炸范围) {
                lifetime = 2400;
                damage = 伤害;
                pierceArmor = true;
                collides = collidesAir = collidesGround = collidesTiles = false;
                hitEffect = despawnEffect = none;
                ammoMultiplier = 子弹数量;
                hitSize = 6;
                fragOnAbsorb = true;
                pierce = true;
                fragBullets = 1;
                despawnHit = true;
                fragBullet = new BulletType() {{
                    lifetime = 0;
                    speed = 0;
                    damage = 0;
                    splashDamage = 爆炸伤害;
                    splashDamageRadius = 爆炸范围 * 8f;
                    hitEffect = despawnEffect = new ExplosionEffect() {{
                        waveRad = smokeRad = sparkRad = splashDamageRadius;
                        waveLife = 12;
                        waveStroke = 3;
                        smokes = 8;
                        smokeSize = 9;
                        smokeSizeBase = 2;
                        sparkLen = 5;
                        sparks = 5;
                        sparkStroke = 2f;
                        smokeColor = Pal.gray;
                        sparkColor = Pal.darkFlame;
                    }};
                    pierceArmor = true;
                    absorbable = keepVelocity = hittable = false;
                   // hitSound = despawnSound = Sounds.explosionbig;
                    status = StatusEffects.freezing;
                    statusDuration = 5*60f;
                }};
            }

            @Override
            public void update(Bullet b) {
                Units.nearbyEnemies(b.team, b.x, b.y, 1.5f * 8, u -> {
                    while (!u.dead && b.collided.size < cap) {
                        u.damagePierce(damage);
                        b.collided.add(u.id);
                    }
                });

                if (b.collided.size >= cap) b.remove();
            }

            @Override
            public void draw(Bullet b) {
                super.draw(b);
                if (!(b.data instanceof Float f)) return;
                float z = Draw.z();
                Draw.z(Layer.blockOver + 1);
                for (int i = 0; i < cap - b.collided.size; i++) {
                    Draw.color(Pal.gray);
                    Drawf.tri(b.x, b.y, 7f, 7f, f + 360f / cap * i);
                    Draw.color(b.team.color);
                    Drawf.tri(b.x, b.y, 6.5f, 6f, f + 360f / cap * i);
                }

                Lines.stroke(2f, Pal.gray);
                Lines.square(b.x, b.y, 3, b.time * 1.5f);
                Lines.stroke(1.5f, b.team.color);
                Lines.square(b.x, b.y, 3, b.time * 1.5f);
                Lines.stroke(2f, Pal.gray);
                Lines.square(b.x, b.y, 3, -b.time * 1.5f);
                Lines.stroke(1.5f, b.team.color);
                Lines.square(b.x, b.y, 3, -b.time * 1.5f);
                Draw.reset();
                Draw.z(z);
            }

        ;
    }
}
