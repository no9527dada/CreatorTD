package cttd.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;

import static cttd.content.CreatorTowerDefenseType.*;

//地形
public class CreatorTowerDefenseTerrain {
    public static Block TD地板a,TD地板b,TD地板d,TD地板c
            ;

    public static void load() {
        new TDFloor("TD地板1");
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