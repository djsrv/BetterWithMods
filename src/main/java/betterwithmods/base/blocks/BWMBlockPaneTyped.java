package betterwithmods.base.blocks;

import betterwithmods.api.block.IMultiVariants;
import betterwithmods.base.util.DirUtils;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class BWMBlockPaneTyped extends BWMBlockPane implements IMultiVariants {
    public static final PropertyEnum<BlockPlanks.EnumType> TYPES = PropertyEnum.create("type", BlockPlanks.EnumType.class);
    public BWMBlockPaneTyped() {
        super();
        setDefaultState(getDefaultState().withProperty(TYPES, BlockPlanks.EnumType.OAK));
    }
    @Override
    public String[] getVariants() {
        String[] var = new String[BlockPlanks.EnumType.values().length];
        for (int i = 0; i < var.length; i++) {
            var[i] = "east=false,north=true,south=true,type=" + BlockPlanks.EnumType.byMetadata(i) + ",west=false";
        }
        return var;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < 6; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(TYPES).getMetadata();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPES).getMetadata();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPES, BlockPlanks.EnumType.byMetadata(meta));
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPES, DirUtils.SOUTH, DirUtils.EAST, DirUtils.NORTH, DirUtils.WEST);
    }

}
