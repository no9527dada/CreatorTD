package CreatorTowerDefense.content;

import arc.Core;
import mindustry.type.StatusEffect;

public class Buff {
    public static class BuffStatusEffect extends StatusEffect {
        public BuffStatusEffect(String name,float 移速) {
            super(name);
            speedMultiplier = 移速;
            localizedName= Core.bundle.format("status.cttd-"+name+".name", 移速*100);
        }
        public BuffStatusEffect(String name,float 血量,float 移速) {
            super(name);
            healthMultiplier = 血量;
            speedMultiplier = 移速;
            localizedName= Core.bundle.format("status.cttd-"+name+".name", 血量*100);
        }
    }
}
