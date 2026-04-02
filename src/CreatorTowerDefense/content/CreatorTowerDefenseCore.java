package CreatorTowerDefense.content;

import arc.graphics.Color;
import CtCoreSystem.CoreSystem.type.CT3UnitType;
import CtCoreSystem.CoreSystem.type.CTCoreBlock;
import mindustry.entities.Fires;
import mindustry.entities.bullet.FireBulletType;
import arc.graphics.g2d.Draw;
import mindustry.gen.Bullet;
import arc.graphics.g2d.Fill;
import arc.math.Interp;
import arc.util.Time;
import mindustry.ai.types.BuilderAI;
import mindustry.gen.Fire;
import mindustry.gen.Groups;
import mindustry.type.Category;
import mindustry.type.UnitType;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.星辰;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.魂;
import static arc.util.Tmp.c1;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

public class CreatorTowerDefenseCore {
    public static Block DTcore0, DTcore1, DTcore2;
    public static UnitType 核心机1;
    public static void load() {


        核心机1 = new CT3UnitType.CTR1UnitType("CoreUnit", "gamma") {{
           // localizedName = "初号机";
           // description = "";
            aiController = BuilderAI::new;
            isEnemy = false;
            lowAltitude = true;
            flying = true;
           // mineSpeed = 3f;
           // mineTier = 1;
            buildSpeed = 2f;
            drag = 0.05f;
            speed = 8f;
            rotateSpeed = 15f;
            accel = 0.1f;
            itemCapacity = 1;
            health = 100f;
            hitSize = 16f;
            alwaysUnlocked = true;
            mineRange = 0f;//采矿范围
            hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            physics = false;//单位碰撞
            buildRange = 35*8.0F;//建造范围
            lightColor = Color.valueOf("ffcd35");
            ammoType = new ItemAmmoType(魂);
            lightOpacity = 1;
            coreUnitDock = true;
            envDisabled = 0;
            engineOffset = 7.5f;
            engineSize = 3.4f;

            setEnginesMirror(
                    new UnitEngine(35 / 4f, -13 / 4f, 2.7f, 315f),
                    new UnitEngine(28 / 4f, -35 / 4f, 2.7f, 315f)
            );
        }};
        DTcore0 = new CTCoreBlock("DTcore0") {{
            requirements(Category.effect, with(星辰, 10));
            alwaysUnlocked = true;
            incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
            isFirstTier = false;//核心地板限制
            unitType = 核心机1;
            health = 100;
            itemCapacity = 50000;
            size = 5;
            unitCapModifier = 0;
            requiresCoreZone = true;//需要特定地板
            buildType = CTCoreBlockBuild::new;
        }

            public class CTCoreBlockBuild  extends CoreBlock.CoreBuild {
                 public float y偏移 = 5f;
                public float 血条高度 = 3f;
                public float 底色透明度 = 0.5f;
                @Override
                public void draw() {
                    if (this.thrusterTime > 0.0F) {
                        float frame = this.thrusterTime;
                        Draw.alpha(1.0F);
                        this.drawThrusters(frame);
                        Draw.rect(this.block.region, this.x, this.y);
                        Draw.alpha(Interp.pow4In.apply(frame));
                        this.drawThrusters(frame);
                        Draw.reset();
                        this.drawTeamTop();
                    } else {
                        super.draw();
                    }
                 //   if(Version.class.getFields().length == 6) {//仅限在原版端显示血条
                        super.draw();
                        float trns = size * 8 / 2f;
                        Draw.color(Color.grays(底色透明度));
                        Fill.rect(x, y + trns + y偏移, size * 8, 血条高度);
                        //Draw.color(team.color);
                      //  Draw.color(C("00de54"));
                        Draw.color(c1.set(Color.red).shiftHue((float) ((Time.time * 0.2) + (1 * (360 / 16)))));//变色
                        Fill.rect(x - size * 4 * (1 - health / maxHealth), y + trns + y偏移, size * 8 * health / maxHealth, 血条高度);
                        Draw.color();
                  //  }
                }
                public void updateTile() {
                    super.updateTile();

                    this.iframes -= Time.delta;
                    this.thrusterTime -= Time.delta / 90.0F;
                    tile.getLinkedTiles(t -> {
                        if(t == null || !Fires.has(t.x, t.y))return;

                        Fire fire = Fires.get(t.x, t.y);
                        fire.remove();
                    });

                    float radiusT = size / 2f * tilesize;
                    Groups.bullet.intersect(x - radiusT, y - radiusT, radiusT * 2, radiusT * 2).each(fire -> fire.type instanceof FireBulletType, Bullet::remove);
                }
            }};
    }
}
