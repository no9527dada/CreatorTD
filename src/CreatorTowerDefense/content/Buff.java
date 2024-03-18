package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.type.StatusEffect;

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
                color = Team.crux.color;
                permanent = true;//状态永久持续
                speedMultiplier = 0.5f;//移速
                damageMultiplier = 3f;//伤害倍率
                localizedName = Core.bundle.format("status." + name + ".name", speedMultiplier * 100);
            }};
    }
}
