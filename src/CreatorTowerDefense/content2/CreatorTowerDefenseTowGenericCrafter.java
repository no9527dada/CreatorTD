package CreatorTowerDefense.content2;

import CreatorTowerDefense.content.CreatorTowerDefenseType;
import arc.Core;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content2.CreatorTowerDefenseTowWall.*;
import static mindustry.Vars.world;
import static mindustry.type.Category.crafting;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTowGenericCrafter {
    //生产
    public static Block 当当宝盒1, 当当宝盒2, 当当宝盒3, 当当宝盒4, 当当宝盒5, 当当宝盒6, 当当宝盒7, 当当宝盒8, 当当宝盒9, 当当宝盒10;//当当宝盒相当于床  只能放一个 地图初始自带1级当当宝盒
    public static Block  宝盒1,宝盒2,宝盒3,宝盒4,宝盒5;
    public static Block 叮叮魔盒1, 叮叮魔盒2, 叮叮魔盒3, 叮叮魔盒4, 叮叮魔盒5, 叮叮魔盒6, 叮叮魔盒7, 叮叮魔盒8, 叮叮魔盒9, 叮叮魔盒10;//等于游戏机
    public static void load() {
        Float 当当宝盒倍率=2f;
        Float 叮叮魔盒倍率=2f;
        当当宝盒1 = new TD2CoreGenericCrafter("当当宝盒V1") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 2);
            itemCapacity = 10;
            requirements(crafting, with(
                    TD微晶, 0
            ));
        }};
        当当宝盒2 = new TD2CoreGenericCrafter("当当宝盒V2") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 4);
            被覆盖方块 = 当当宝盒1;
            itemCapacity = 10;
            requirements(crafting, with(
                    TD微晶, 20*当当宝盒倍率
            ));
        }};
        当当宝盒3 = new TD2CoreGenericCrafter("当当宝盒V3") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 8);
            被覆盖方块 = 当当宝盒2;
            场上数量要求方块=铅墙V1;
            requirements(crafting, with(
                    TD微晶, 50*当当宝盒倍率
            ));
        }};
        当当宝盒4 = new TD2CoreGenericCrafter("当当宝盒V4") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 16);
            被覆盖方块 = 当当宝盒3;
            场上数量要求方块=魔石墙V7;
            requirements(crafting, with(
                    TD微晶, 100*当当宝盒倍率
            ));
        }};
        当当宝盒5 = new TD2CoreGenericCrafter("当当宝盒V5") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 32);
            被覆盖方块 = 当当宝盒4;
            requirements(crafting, with(
                    TD微晶, 200*当当宝盒倍率
            ));
        }};
        当当宝盒6 = new TD2CoreGenericCrafter("当当宝盒V6") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 64);
            被覆盖方块 = 当当宝盒5;
            requirements(crafting, with(
                    TD微晶, 400*当当宝盒倍率
            ));
        }};
        当当宝盒7 = new TD2CoreGenericCrafter("当当宝盒V7") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 128);
            被覆盖方块 = 当当宝盒6;
            requirements(crafting, with(
                    TD微晶, 800*当当宝盒倍率,TD魔能晶,20
            ));
        }};
        当当宝盒8 = new TD2CoreGenericCrafter("当当宝盒V8") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶,256);
            被覆盖方块 = 当当宝盒7;
            requirements(crafting, with(
                    TD微晶, 1600*当当宝盒倍率,TD魔能晶,50
            ));
        }};
        当当宝盒9 = new TD2CoreGenericCrafter("当当宝盒V9") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 512);
            被覆盖方块 = 当当宝盒8;
            requirements(crafting, with(
                    TD微晶, 3200*当当宝盒倍率,TD魔能晶,150
            ));
        }};
        当当宝盒10 = new TD2CoreGenericCrafter("当当宝盒V10") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 1024);
            被覆盖方块 = 当当宝盒9;
            requirements(crafting, with(
                    TD微晶, 6400*当当宝盒倍率,TD魔能晶,400
            ));
        }};


        宝盒1 = new TD2CoreGenericCrafter("宝盒V1") {{
            consumePower(10 / 60f);
            outputItems = ItemStack.with(TD微晶, 8);
            itemCapacity = 10;
            requirements(crafting, with(
                    TD魔能晶,100
            ));
        }};
        宝盒2 = new TD2CoreGenericCrafter("宝盒V2") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 32);
            被覆盖方块 = 宝盒1;
            itemCapacity = 10;
            requirements(crafting, with(
                    TD魔能晶,1000
            ));
        }};
        宝盒3 = new TD2CoreGenericCrafter("宝盒V3") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 128);
            被覆盖方块 = 宝盒2;
            itemCapacity = 10;
            requirements(crafting, with(
                    TD魔能晶,2000
            ));
        }};
        宝盒4 = new TD2CoreGenericCrafter("宝盒V4") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 512);
            被覆盖方块 = 宝盒3;
            itemCapacity = 10;
            requirements(crafting, with(
                    TD魔能晶,4000
            ));
        }};
        宝盒5 = new TD2CoreGenericCrafter("宝盒V5") {{
            consumePower(800 / 60f);
            outputItems = ItemStack.with(TD微晶, 1024);
            被覆盖方块 = 宝盒4;
            itemCapacity = 10;
            requirements(crafting, with(
                    TD魔能晶,8000
            ));
        }};
/**********************************/
        叮叮魔盒1= new TD2CoreGenericCrafter("叮叮魔盒V1") {{
            consumePower(-800 / 60f);
            outputItems = ItemStack.with(TD魔能晶, 1);
            requirements(crafting, with(
                    TD微晶, 400
            ));
        }};
        叮叮魔盒2 = new TD2CoreGenericCrafter("叮叮魔盒V2") {{
            consumePower(-800 / 60f);
            被覆盖方块 = 叮叮魔盒1;
            outputItems = ItemStack.with(TD魔能晶, 2);
            requirements(crafting, with(
                    TD微晶, 800
            ));
        }};
        叮叮魔盒3 = new TD2CoreGenericCrafter("叮叮魔盒V3") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒2;
            outputItems = ItemStack.with(TD魔能晶, 4);
            requirements(crafting, with(
                    TD微晶, 1600
            ));
        }};
        叮叮魔盒4 = new TD2CoreGenericCrafter("叮叮魔盒V4") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒3;
            outputItems = ItemStack.with(TD魔能晶, 8);
            requirements(crafting, with(
                    TD微晶, 3200
            ));
        }};
        叮叮魔盒5 = new TD2CoreGenericCrafter("叮叮魔盒V5") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒4;
            outputItems = ItemStack.with(TD魔能晶, 16);
            requirements(crafting, with(
                    TD微晶, 6400
            ));
        }};
        叮叮魔盒6 = new TD2CoreGenericCrafter("叮叮魔盒V6") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒5;
            outputItems = ItemStack.with(TD魔能晶, 32);
            requirements(crafting, with(
                    TD微晶, 12800
            ));
        }};
        叮叮魔盒7 = new TD2CoreGenericCrafter("叮叮魔盒V7") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒6;
            outputItems = ItemStack.with(TD魔能晶, 64);
            requirements(crafting, with(
                    TD微晶, 25600
            ));
        }};
        叮叮魔盒8 = new TD2CoreGenericCrafter("叮叮魔盒V8") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒7;
            outputItems = ItemStack.with(TD魔能晶, 128);
            requirements(crafting, with(
                    TD微晶, 51200
            ));
        }};
        叮叮魔盒9 = new TD2CoreGenericCrafter("叮叮魔盒V9") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒8;
            outputItems = ItemStack.with(TD魔能晶, 256);
            requirements(crafting, with(
                    TD微晶, 102400
            ));
        }};
        叮叮魔盒10 = new TD2CoreGenericCrafter("叮叮魔盒V10") {{
            consumePower(800 / 60f);
            被覆盖方块 = 叮叮魔盒9;
            outputItems = ItemStack.with(TD魔能晶, 512);
            requirements(crafting, with(
                    TD微晶, 204800
            ));
        }};
    }
    public static class TD2CoreGenericCrafter extends CreatorTowerDefenseType.TDCoreGenericCrafter {

        public TD2CoreGenericCrafter(String name) {
            super(name);
            description="";
            size = 3;
            health = 10;
            armor = 0;
            craftTime = 60 * 3;
            canOverdrive = false;
            solid= targetable = false;//被单位攻击？
            // 立即放置 = false;
            //  envDisabled = Evn2.TD2标记;
        }
        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = true; //true是启用资源不足的条件限制

        //场上数量要求方块不足时禁止放置
        public Block 场上数量要求方块 ;
        public int 数量 = 1;

        //放置位置没有被覆盖方块时禁止放置
        public Block 被覆盖方块;

        public boolean 资源要求(Team team){
            CoreBlock.CoreBuild core = Vars.state.teams.get(team).core();
            return !立即放置 || core != null && core.items.has(requirements, Vars.state.rules.buildCostMultiplier);
        }

        public boolean 数量要求(Team team){
            return 场上数量要求方块 == null || Vars.state.teams.get(team).getBuildings(场上数量要求方块).size >= 数量;
        }

        public boolean 覆盖要求(Tile tile){
            tile.getLinkedTilesAs(this, tempTiles);
            return 被覆盖方块 == null || tempTiles.contains(o -> o.block() == 被覆盖方块);
        }

        public boolean 沙盒模式(){
            return Vars.state.isEditor() || Vars.state.rules.infiniteResources;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            if(!沙盒模式() && !(资源要求(team) && 数量要求(team) && 覆盖要求(tile)))return false;
            return super.canPlaceOn(tile, team, rotation);
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            Team team = Vars.player.team();

            if(沙盒模式()){}
            else if(!资源要求(team))drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
            else if (!数量要求(team))drawPlaceText(Core.bundle.get("QuantityLimit.缺少前置方块") + 场上数量要求方块.localizedName + " X" + 数量, x, y, false);
            else if (!覆盖要求(world.tile(x, y)))drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 被覆盖方块.localizedName, x, y, valid);;

            super.drawPlace(x, y, rotation, valid);
        }

        //瞬间替换和扣除物品
        @Override
        public void placeBegan(Tile tile, Block previous) {
            Team team = Vars.player.team();

            if(立即放置 && 资源要求(team) && !沙盒模式()){
                CoreBlock.CoreBuild core = Vars.player.team().core();
                core.items.remove(requirements);
                tile.setBlock(this, tile.team());
                tile.block().placeEffect.at(tile, tile.block().size);
            }
            else super.placeBegan(tile, previous);
        }

        @Override
        public boolean canReplace(Block other) {
            return super.canReplace(other) || other == 被覆盖方块;
        }
    }
}