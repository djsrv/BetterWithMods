package betterwithmods.modules.aesthetic.blocks;

import betterwithmods.base.blocks.BWMBlock;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BlockChoppingBlock extends BWMBlock {
    public static final PropertyBool DIRTY = PropertyBool.create("dirty");

    public BlockChoppingBlock() {
        super(Material.ROCK);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,DIRTY);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(DIRTY, meta == 1);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(DIRTY) ? 1 : 0;
    }

}
