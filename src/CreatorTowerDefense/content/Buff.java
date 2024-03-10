package CreatorTowerDefense.content;

import mindustry.type.StatusEffect;

public class Buff {
    public static class BuffStatusEffect extends StatusEffect {

        public BuffStatusEffect(String name,float 移速,float 血量) {
            super(name);
            speedMultiplier = 移速;
            healthMultiplier = 血量;
        }
        public BuffStatusEffect(String name,float 移速) {
            super(name);
            speedMultiplier = 移速;
            healthMultiplier = 1f;
        }
    }
}
