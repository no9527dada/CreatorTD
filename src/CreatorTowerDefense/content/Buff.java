package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.tilesize;
import static mindustry.content.StatusEffects.*;

public class Buff {
    public static StatusEffect TDburning,BossBuff;
    public static class BuffStatusEffect extends StatusEffect {
        public BuffStatusEffect(String name,float 移速) {
            super(name);
            show = false;
            speedMultiplier = 移速;
            localizedName= Core.bundle.format("status.cttd-"+name+".name", 移速*100);
        }
        public BuffStatusEffect(String name,float 血量,float 移速) {
            super(name);
            show = false;
            healthMultiplier = 血量;
            speedMultiplier = 移速;
            localizedName= Core.bundle.format("status.cttd-"+name+".name", 血量*100);
        }
    }
    public static void load() {
        TDburning = new StatusEffect("TDburning"){{//燃烧
            color = Color.valueOf("ffc455");
            damage = 3/60f;
            effect = Fx.burning;
            transitionDamage = 8f;
            show = false;
            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(burning, Math.min(time + result.time, 300f));
                });
            });
        }};
        BossBuff = new StatusEffect("Boss") {
            @Override
            public void update(Unit unit, float time) {
                super.update(unit, time);
                Vars.state.teams.bosses.add(unit);
            }{
                effect =  new Effect(35, e -> {
                    color(Pal.accent);
                    stroke(4f - e.fin() * 3f);
                    Lines.square(e.x, e.y, tilesize / 2f * e.rotation * 1.2f + e.fin() * 5f);
                    randLenVectors(e.id, 5 + (int)(e.rotation * 5), e.rotation * 3f + (tilesize * e.rotation) * e.finpow() * 1.5f, (x, y) -> {
                        Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * (4f + e.rotation));
                    });
                });
                color = Team.crux.color;
                permanent = true;//状态永久持续
                speedMultiplier = 0.5f;//移速
                damageMultiplier = 3f;//伤害倍率
                localizedName = Core.bundle.format("status." + name + ".name", speedMultiplier * 100);
            }};

    }
}
