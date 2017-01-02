package betterwithmods.api.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public interface IDebarkable {
    ItemStack getBark(IBlockState state);
}
