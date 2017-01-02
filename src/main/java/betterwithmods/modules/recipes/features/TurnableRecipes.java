package betterwithmods.modules.recipes.features;

import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.base.blocks.BlockUnfiredPottery.EnumPotteryType;
import betterwithmods.api.crafting.blockmeta.TurntableInteraction;
import betterwithmods.base.modules.Feature;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class TurnableRecipes extends Feature {

    @Override
    public void init(FMLInitializationEvent event) {
        addTurntableRecipe(Blocks.CLAY, 0, BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.CRUCIBLE.getMeta(), new ItemStack(Items.CLAY_BALL));
        addTurntableRecipe(BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.CRUCIBLE.getMeta(), BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.PLANTER.getMeta(), null);
        addTurntableRecipe(BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.PLANTER.getMeta(), BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.VASE.getMeta(), new ItemStack(Items.CLAY_BALL));
        addTurntableRecipe(BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.VASE.getMeta(), BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.URN.getMeta(), new ItemStack(Items.CLAY_BALL));
        addTurntableRecipe(BWMBlocks.UNFIRED_POTTERY, EnumPotteryType.URN.getMeta(), null, 0, new ItemStack(Items.CLAY_BALL));
    }

    public static void addTurntableRecipe(Block inputBlock, int iMeta, Block outputBlock, int oMeta, ItemStack... scraps) {
        TurntableInteraction.INSTANCE.addTurntableRecipe(inputBlock, iMeta, outputBlock, oMeta, scraps);
    }

}
