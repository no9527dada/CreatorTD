package CreatorTowerDefense.content.Sundry;

import CreatorTowerDefense.content.CreatorTowerDefenseType;
import mindustry.content.Fx;
import mindustry.entities.bullet.BulletType;

public class 三叶 {
    public static class 三叶BU extends BulletType {
    public  三叶BU(float 速度, float 伤害1, float 伤害2, float 伤害3) {
        new CreatorTowerDefenseType.CTTDBasicBulletType(速度, 伤害1, "cttd-bu3") {
            {
                width = 25f;
                height = 25f;
                lifetime = 60f;
                ammoMultiplier = 1;//装弹倍率
                spin = 8;
                pierce = true; //穿透
                trailLength = 8;
                trailWidth = 2;
                //trailColor = 翠.color;

                fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(速度, 伤害2, "cttd-bu3")//分裂的子弹
                {{
                    width = 25f;
                    height = 25f;
                    lifetime = 300f;
                    spin = 8;
                    fragOnHit=false;
                    // backColor = Color.valueOf("ffffff"); //背景颜色
                    // frontColor = 翠.color; //前面颜色
                    pierce = true;
                    despawnEffect = Fx.none;
                    fragBullet = new CreatorTowerDefenseType.CTTDBasicBulletType(速度, 伤害3, "cttd-bu3")//分裂的子弹
                    {{
                        width = 25f;
                        height = 25f;
                        lifetime = 300f;
                        spin = 8;
                        // backColor = Color.valueOf("ffffff"); //背景颜色
                        //frontColor = 翠.color; //前面颜色
                        pierce = true;
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
                fragBullets = 3;//分裂的数量
                fragRandomSpread = 15f;//分裂的角度
                fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
                fragVelocityMin = 1f;//随机范围的破片速度最小0。
                fragVelocityMax = 1f;//随机范围的破片速度最大1。
                fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
                fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
                despawnEffect = Fx.none;
                hitEffect = Fx.none;
            }
        };
    }}
}
