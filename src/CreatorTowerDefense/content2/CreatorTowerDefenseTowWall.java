package CreatorTowerDefense.content2;

import CtCoreSystem.CoreSystem.type.TDTyep.TDhealDamageWall2;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import mindustry.Vars;
import mindustry.core.Version;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.TD微晶;
import static CreatorTowerDefense.content.CreatorTowerDefenseItems.TD魔能晶;
import static mindustry.Vars.state;
import static mindustry.content.Blocks.coreZone;
import static mindustry.type.Category.defense;
import static mindustry.type.ItemStack.with;

//方块
public class CreatorTowerDefenseTowWall {

    //防御
    public static Block 铜墙V0, 铅墙V1, 钛墙V2, 钍墙V3, 塑钢墙V4, 相位墙V5, 合金墙V6, 魔石墙V7, 魔微墙V8, 神威墙V9, 创世墙V10;

    public static void load() {
        铜墙V0 = new TD2Wall("铜墙V0")
        {
            {
            requirements(defense, with(TD微晶, 4));
            health = 300;
            alwaysUnlocked = true;
       }};
        铅墙V1 = new TD2Wall("铅墙V1") {{
            requirements(defense, with(TD微晶, 4));
            health = 300+200;
            升级前置 = 铜墙V0;
        }};
        钛墙V2 = new TD2Wall("钛墙V2") {{
            requirements(defense, with(TD微晶, 4));
            health = 300+200+300;
            升级前置 = 铅墙V1;
        }};
        钍墙V3 = new TD2Wall("钍墙V3") {{
            requirements(defense, with(TD微晶, 4));
            health = 300+200+300+400;
            升级前置 = 钛墙V2;
        }};
        塑钢墙V4 = new TD2Wall("塑钢墙V4") {{
            requirements(defense, with(TD微晶, 4));
            health = 300+200+300+400+500;
            升级前置 = 钍墙V3;
        }};
        相位墙V5 = new TD2Wall("相位墙V5") {{
            requirements(defense, with(TD微晶, 4));
            health = 300+200+300+400+500+600;
            升级前置 = 塑钢墙V4;
        }};
        合金墙V6 = new TD2Wall("合金墙V6") {{
            requirements(defense, with(TD微晶, 4,TD魔能晶,32));
            health = 300+200+300+400+500+600+700;
            升级前置 = 相位墙V5;
        }};
        魔石墙V7 = new TD2Wall("魔石墙V7") {{
            requirements(defense, with(TD微晶, 4,TD魔能晶,128));
            health = 300+200+300+400+500+600+700+800;
            升级前置 = 合金墙V6;
        }};
        魔微墙V8 = new TD2Wall("魔微墙V8") {{
            requirements(defense, with(TD微晶, 4,TD魔能晶,512));
            health = 300+200+300+400+500+600+700+800+900;
            升级前置 = 魔石墙V7;
        }};
        神威墙V9 = new TD2Wall("神威墙V9") {{
            requirements(defense, with(TD微晶, 4,TD魔能晶,2048));
            health = 300+200+300+400+500+600+700+800+900+1000;
            升级前置 = 魔微墙V8;
        }};
        创世墙V10 = new TD2Wall("创世墙V10") {{
            requirements(defense, with(TD微晶, 4,TD魔能晶,2048*2));
            health =  300+200+300+400+500+600+700+800+900+1000+2000;
            升级前置 = 神威墙V9;
        }};
    }
    public static class  TD2Wall extends TDhealDamageWall2.TDhealDamageWall {

        public float y偏移 = 5f;
        public float 血条高度 = 1f;
        public float 底色透明度 = 0.5f;
        public TD2Wall(String name) {
            super(name);
            size = 5;
            // envDisabled = Evn2.TD2标记;
            buildType = TD2WallBuild::new;
            buildCostMultiplier = 0;
            floor = (Floor) coreZone;
            description=Core.bundle.get("TD2Wall.description");
            damageTime = 30f;
            pauseTime = 300f;
            damagePercent = -1f;
            canOverdrive = false;
        }
        //瞬间替换和扣除物品
        @Override
        public void placeBegan(Tile tile, Block previous) {
            if (!Vars.state.rules.infiniteResources) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                core.items.remove(requirements);
            }
            tile.setBlock(this, tile.team());
            tile.block().placeEffect.at(tile, tile.block().size);
        }



        public Floor floor;//需要的地板


        public Block 升级前置 = null;
        public boolean canReplace(Block other) {
            if (other.alwaysReplace) return true;
            return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
        }

        @Override
        public boolean canPlaceOn(Tile tile, Team team, int rotation) {
            CoreBlock.CoreBuild core = team.core();
            if (tile == null) return false;
            if ((!state.rules.infiniteResources && !core.items.has(requirements, state.rules.buildCostMultiplier)))
                return false;
            //  return !tempTiles.contains(o -> o.floor() != floor);

            if (Vars.state.isEditor() || 升级前置 == null || Vars.state.rules.infiniteResources) return true;
            tile.getLinkedTilesAs(this, tempTiles);
            return tempTiles.contains(o -> o.block() == 升级前置)&&(!tempTiles.contains(o -> o.floor() != floor));
        }

        //显示红字
        @Override
        public void drawPlace(int x, int y, int rotation, boolean valid) {
            CoreBlock.CoreBuild core = Vars.player.team().core();
            if (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)) {
                drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
            } else {
                if (!valid && 升级前置 != null)
                    drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);
            }
            super.drawPlace(x, y, rotation, valid);
        }
/*
        //生存模式不可拆
        @Override
        public boolean canBreak(Tile tile) {
            return state.rules.editor || Vars.state.rules.infiniteResources || state.playtestingMap != null;
        }
*/

        public class TD2WallBuild  extends TDhealDamageWallBuild {
            @Override

            public void draw() {
                if(Version.class.getFields().length == 6) {//仅限在原版端显示血条
                    super.draw();
                    float trns = size * 8 / 2f;
                    Draw.color(Color.grays(底色透明度));
                    Fill.rect(x, y + trns + y偏移, size * 8, 血条高度);
                    Draw.color(team.color);
                    Fill.rect(x - size * 4 * (1 - health / maxHealth), y + trns + y偏移, size * 8 * health / maxHealth, 血条高度);
                    Draw.color();
                }
            }

        }

    }
}