package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;

import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDFloor;
import static ct.Asystem.type.CTColor.C;
import static ct.content.CTFragShader.紫色冷却液效果;

//地形
public class CreatorTowerDefenseTerrain {
    public static Block TD地板a,TD地板b,TD地板d,TD地板c
            ;

    public static void load() {
        /*         new Floor("mud"){{
            speedMultiplier = 0.6f;
            variants = 3;
            status = StatusEffects.muddy;
            statusDuration = 30f;
            attributes.set(Attribute.water, 1f);//增幅
            cacheLayer = CacheLayer.mud;//效果
            walkSound = Sounds.mud;//走路发出的声音
        }};*/
/*        StatusEffect 恢复1= new StatusEffect("recover1"){{
            damage=-8/60f;
            show = false;
            effect= new Effect(30, e -> {
                color(C("6fffa1"), Color.darkGray, e.rotation);
                Fill.circle(e.x, e.y, e.fout() * 3.5f);
            });
        }};
        StatusEffect 恢复2= new StatusEffect("recover2"){{
            show = false;
            damage=-30/60f;    effect= new Effect(30, e -> {
                color(C("6fffa1"), Color.darkGray, e.rotation);
                Fill.circle(e.x, e.y, e.fout() * 3.5f);
            });
        }};*/


        new Floor("DT-LiquidFloor"){{
            drownTime = 10f;
            variants = 0;
            isLiquid = true;
            emitLight = true;
            lightRadius = 25f;
            lightColor = Color.cyan.cpy().a(0.7f);
            cacheLayer = CacheLayer.cryofluid;
        }};
        new Floor("DT-LiquidFloor2"){{
            variants = 0;
            isLiquid = false;
            emitLight = true;
            lightRadius = 25f;
            lightColor = C("cc44ff").cpy().a(0.7f);
            //cacheLayer = new CacheLayer.ShaderLayer(紫色Floor);
            cacheLayer = 紫色冷却液效果;
        }};

        new TDFloor("TD地板0"){{
            isLiquid=true;
        localizedName = Core.bundle.getOrNull("block.Floor");
        }};
        new TDFloor("TD地板1"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板2"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板3"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板4"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板5"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板6"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板7"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};
        new TDFloor("TD地板8"){{ localizedName = Core.bundle.getOrNull("block.Floor");}};


        new TDFloor("TD加速地板a1"){{
            speedMultiplier = 1.8f;
        }};
        new TDFloor("TD加速地板a2"){{
            speedMultiplier = 1.8f;
        }};
        new TDFloor("TD加速地板a3"){{
            speedMultiplier = 1.8f;
        }};
        new TDFloor("TD加速地板a4"){{
            speedMultiplier = 1.8f;
        }};
        new TDFloor("TD加速地板b"){{
            speedMultiplier = 10f;
        }};
        new TDFloor("TD减速地板a1"){{speedMultiplier = 0.7f;}};
        new TDFloor("TD减速地板a2"){{speedMultiplier = 0.7f;}};
        new TDFloor("TD减速地板a3"){{speedMultiplier = 0.7f;}};
        new TDFloor("TD减速地板a4"){{speedMultiplier = 0.7f;}};
        new TDFloor("TD减速地板b1"){{ speedMultiplier = 0.4f;}};
        new TDFloor("TD减速地板b2"){{ speedMultiplier = 0.4f;}};
        new TDFloor("TD减速地板b3"){{ speedMultiplier = 0.4f;}};
        new TDFloor("TD减速地板b4"){{ speedMultiplier = 0.4f;}};
        new Floor("TD碧云地板1"){{  variants = 0;}};
        new Floor("TD碧云地板2"){{  variants = 0;}};
        new Floor("TD碧云地板3"){{  variants = 0;}};
        new Floor("TD碧云地板4"){{  variants = 0;}};
        new Floor("TD碧云地板5"){{  variants = 0;}};
        new Floor("TD碧云地板6"){{  variants = 0;}};
        new Floor("TD碧云地板7"){{  variants = 0;}};
        new Floor("TD碧云地板8"){{  variants = 0;}};
        new Floor("TD碧云地板9"){{  variants = 0;}};
        new Floor("TD碧云地板10"){{  variants = 0;}};
        new Floor("TD碧云地板11"){{  variants = 0;}};
        new Floor("TD碧云地板12"){{  variants = 0;}};
         new StaticWall("TD碧云墙壁"){{variants=7;}};

        new Floor("TD镀银地板1"){{  variants = 0;}};
        new Floor("TD镀银地板2"){{  variants = 0;}};
        new Floor("TD镀银地板3"){{  variants = 0;}};
        new Floor("TD镀银地板4"){{  variants = 0;}};
        new Floor("TD镀银地板5"){{  variants = 0;}};
        new Floor("TD镀银地板6"){{  variants = 0;}};
        new Floor("TD镀银地板7"){{  variants = 0;}};
        new Floor("TD镀银地板8"){{  variants = 0;}};
        new Floor("TD镀银地板9"){{  variants = 0;}};
        new Floor("TD镀银地板10"){{  variants = 0;}};
        new StaticWall("TD镀银墙壁"){{variants=5;}};
        //墙专用
        TD地板a= new Floor("TD地板a"){{
            variants = 0;
        }};

        //修复器专用
        TD地板b= new Floor("TD地板b"){{
            variants = 0;
        }};

        //快进专用
        TD地板c= new Floor("TD地板c"){{
            variants = 0;
        }};

        //无限模式专用
        TD地板d= new Floor("TD地板d"){{
            variants = 0;
        }};
    }
}