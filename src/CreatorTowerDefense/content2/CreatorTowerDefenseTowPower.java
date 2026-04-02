package CreatorTowerDefense.content2;

import CtCoreSystem.CoreSystem.type.PowerNetTower;
import CtCoreSystem.CoreSystem.type.VXV.TDpowerShowBlock;
import CtCoreSystem.CoreSystem.type.VXV.powerShowBlock;
import CtCoreSystem.CoreSystem.type.LYBF.power.CoreConsumeGenerator;
import arc.Core;
import arc.scene.event.Touchable;
import arc.scene.ui.Label;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.core.UI;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawWarmupRegion;

import java.util.Iterator;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static mindustry.Vars.world;
import static mindustry.type.Category.power;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTowPower {

    //电力
    public static Block 电量查看器2,能量网络器, 能量释放器1, 能量释放器2, 能量释放器3, 能量释放器4, 能量释放器5;



    public static void load() {
        电量查看器2 = new TDpowerShowBlock("电量查看器2") {{
                health = 10;
                size = 1;
                solid= targetable = false;//被单位攻击？
                requirements(power, with(
                        TD微晶, 1
                ));
            }};
        能量网络器=  new PowerNetTower("能量网络器"){{
            health = 10;
            requirements(Category.power, with(TD微晶, 2));
            canOverdrive = false;
            hasLiquids = false;
            size = 2;
            range = 50;
             targetable = false;//被单位攻击？
            consumePowerBuffered(100f);;
        }};
        能量释放器1=  new TD2ConsumeGenerator("1级能量释放器"){{
            requirements(Category.power, with(TD微晶, 50));
            powerProduction = 60/60f;
        }};
        能量释放器2=  new TD2ConsumeGenerator("2级能量释放器"){{
            requirements(Category.power, with(TD微晶, 100));
            powerProduction = 120/60f;
        }};
        能量释放器3=  new TD2CoreConsumeGenerator("3级能量释放器"){{
            requirements(Category.power, with(TD微晶, 200));
            powerProduction = 240/60f;
            itemDuration = 60*2f;
            consumeItem(TD微晶,2);
        }};
        能量释放器4=  new TD2CoreConsumeGenerator("4级能量释放器"){{
            requirements(Category.power, with(TD微晶, 400));
            powerProduction = 480/60f;
            itemDuration = 60*2f;
            consumeItem(TD微晶,4);
        }};
        能量释放器5=  new TD2CoreConsumeGenerator("5级能量释放器"){{
            requirements(Category.power, with(TD微晶, 800, TD魔能晶, 100));
            powerProduction = 960/60f;
            itemDuration = 60*2f;
            consumeItem(TD微晶,8);
        }};
    }
    public static class  TD2ConsumeGenerator extends ConsumeGenerator {

        public TD2ConsumeGenerator(String name) {
            super(name);
            canOverdrive = false;
            description="";
            solid= targetable = false;//被单位攻击？
            health = 10;
            armor = 0;
            itemDuration = 60f;
            hasLiquids = false;
            size = 2;
            generateEffect = Fx.none;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.02f;
            drawer = new DrawDefault();
        }
        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = false; //true是启用资源不足的条件限制

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
    public static class  TD2CoreConsumeGenerator extends CoreConsumeGenerator {

        public TD2CoreConsumeGenerator(String name) {
            super(name);
            canOverdrive = false;
            solid= targetable = false;//被单位攻击？
            health = 10;
            armor = 0;
            hasLiquids = false;
            size = 2;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.04f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }
        //是否立即放置, 立即放置则禁止资源不足时禁止放置
        public boolean 立即放置 = false; //true是启用资源不足的条件限制

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