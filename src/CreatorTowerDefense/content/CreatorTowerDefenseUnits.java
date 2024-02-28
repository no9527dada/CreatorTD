package CreatorTowerDefense.content;

import ct.Asystem.type.UnitDeathReward;
import mindustry.type.ItemStack;

import static CreatorTowerDefense.content.CreatorTowerDefenseItems.*;
import static CreatorTowerDefense.content.CreatorTowerDefenseType.TDUnitType;
//方块
public class CreatorTowerDefenseUnits {
    public static TDUnitType
            黄沙,黑沙,黄铜,
            单位;

    public static void load() {
      黄沙 =new TDUnitType("dt黄沙",1,30,0.5f);
        UnitDeathReward.getInstance().init().add(黄沙,new ItemStack(魂,1));

        黑沙 =new TDUnitType("dt黑沙",1,30,0.5f);
        UnitDeathReward.getInstance().init().add(黑沙,new ItemStack(魄,2));
        黄铜 =new TDUnitType("dt黄铜",1,30,0.5f);
        UnitDeathReward.getInstance().init().add(黄铜,new ItemStack(魄,3));
    }
}