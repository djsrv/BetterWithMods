package betterwithmods.modules.aesthetic.blocks;

import betterwithmods.api.block.IMultiVariants;
import betterwithmods.base.blocks.BWMBlock;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockAesthetic extends BWMBlock implements IMultiVariants {
    public static final PropertyEnum<BlockAesthetic.EnumType> blockType = PropertyEnum.create("blocktype", BlockAesthetic.EnumType.class);

    public BlockAesthetic() {
        super(Material.ROCK);
        this.setHardness(2.0F);
        this.setCreativeTab(BWCreativeTabs.BWTAB);
    }

    @Override
    public String[] getVariants() {
        return new String[]{"blocktype=hellfire", "blocktype=rope", "blocktype=flint", "blocktype=whitestone", "blocktype=whitecobble", "blocktype=enderblock"};
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < EnumType.META_LOOKUP.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return (state.getValue(blockType)).getMeta();
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return (world.getBlockState(pos).getValue(blockType)) == EnumType.HELLFIRE;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(blockType, BlockAesthetic.EnumType.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(blockType).getMeta();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, blockType);
    }

    public enum EnumType implements IStringSerializable {
        HELLFIRE(0, "hellfire", MapColor.ADOBE),
        ROPE(1, "rope", MapColor.DIRT),
        FLINT(2, "flint", MapColor.STONE),
        WHITESTONE(3, "whitestone", MapColor.CLOTH),
        WHITECOBBLE(4, "whitecobble", MapColor.CLOTH),
        ENDERBLOCK(5, "enderblock", MapColor.CYAN);

        private static final BlockAesthetic.EnumType[] META_LOOKUP = new BlockAesthetic.EnumType[values().length];

        static {
            for (BlockAesthetic.EnumType blockType : values()) {
                META_LOOKUP[blockType.getMeta()] = blockType;
            }
        }

        private final int meta;
        private final String name;
        private final MapColor color;

        EnumType(int meta, String name, MapColor color) {
            this.meta = meta;
            this.name = name;
            this.color = color;
        }

        public static BlockAesthetic.EnumType byMeta(int meta) {
            return META_LOOKUP[meta];
        }

        @Override
        public String getName() {
            return name;
        }

        public int getMeta() {
            return meta;
        }

    }
}
