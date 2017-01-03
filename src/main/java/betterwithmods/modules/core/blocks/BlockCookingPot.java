package betterwithmods.modules.core.blocks;

import betterwithmods.api.block.IMechanicalBlock;
import betterwithmods.api.block.IMultiVariants;
import betterwithmods.base.BWMod;
import betterwithmods.base.blocks.BWMBlock;
import betterwithmods.base.util.DirUtils;
import betterwithmods.modules.core.tiles.TileEntityCauldron;
import betterwithmods.modules.core.tiles.TileEntityCookingPot;
import betterwithmods.modules.core.tiles.TileEntityCrucible;
import betterwithmods.modules.core.tiles.TileEntityTurntable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BlockCookingPot extends BWMBlock implements IMechanicalBlock, ITileEntityProvider, IMultiVariants {
    public static final PropertyBool ISACTIVE = PropertyBool.create("ison");

    public enum EnumType implements IStringSerializable {
        CRUCIBLE("crucible"), CAULDRON("cauldron");
        private String name;

        private static final EnumType[] META_LOOKUP = values();

        public static EnumType byMeta(int meta) {
            return META_LOOKUP[meta >> 1];
        }

        EnumType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getMeta() {
            return ordinal();
        }
    }

    public static final PropertyEnum<EnumType> TYPE = PropertyEnum.create("type", EnumType.class);
    //TODO
    public BlockCookingPot() {
        super(Material.IRON);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(itemIn,1,0));
        list.add(new ItemStack(itemIn,1,1));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ISACTIVE, TYPE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, EnumType.byMeta(meta)).withProperty(ISACTIVE, (meta & 1) == 1);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int type = state.getValue(TYPE).getMeta();
        int isOn = state.getValue(ISACTIVE) ? 1 : 0;
        return type << 1 | isOn;
    }


    public boolean isCurrentStateValid(World world, BlockPos pos) {
        boolean gettingPower = isInputtingMechPower(world, pos);
        boolean isOn = isMechanicalOn(world, pos);
        return isOn == gettingPower;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos).hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
                player.openGui(BWMod.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
            } else {
                if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntityTurntable) {
                    return ((TileEntityTurntable) world.getTileEntity(pos)).processRightClick(player);
                }
            }
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        updateCookingPot(world, pos, rand);
    }

    private void updateCookingPot(World world, BlockPos pos, Random rand) {
        if (!isMechanicalOn(world, pos)) {
            TileEntityCookingPot tile = (TileEntityCookingPot) world.getTileEntity(pos);
            int heat = tile.fireIntensity;
            if (heat > 4) {
                emitSmoke(world, pos, rand, heat);
            }
        }
    }

    private void emitSmoke(World world, BlockPos pos, Random rand, int heat) {
        for (int i = 0; i < heat; i++) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            float fX = x + rand.nextFloat();
            float fY = y + rand.nextFloat() * 0.5F + 1.0F;
            float fZ = z + rand.nextFloat();
            world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, fX, fY, fZ, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        int facing = 1;
        TileEntity tile = world.getTileEntity(pos);
        if (tile != null) {
            if (tile instanceof TileEntityCookingPot) {
                //TODO Kills performance from rendering updates, should be fixed by separating cooking pots out
                facing = ((TileEntityCookingPot) tile).facing;
            }
        }
        return state.withProperty(DirUtils.TILTING, EnumFacing.getFront(facing));
    }


    @Override
    public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity) {
        switch (state.getValue(TYPE)) {
            case CRUCIBLE:
                return SoundType.GLASS;
            case CAULDRON:
                return SoundType.METAL;
            default:
                return super.getSoundType(state, world, pos, entity);
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        if (!isCurrentStateValid(world, pos)) {
            world.scheduleBlockUpdate(pos, this, 1, 5);
        }
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        switch (state.getValue(TYPE)) {
            case CRUCIBLE:
                return new TileEntityCrucible();
            case CAULDRON:
                return new TileEntityCauldron();
        }
        return null;
    }

    @Override
    public boolean canOutputMechanicalPower() {
        return false;
    }

    @Override
    public boolean canInputMechanicalPower() {
        return false;
    }

    @Override
    public boolean isInputtingMechPower(World world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isOutputtingMechPower(World world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canInputPowerToSide(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return false;
    }

    @Override
    public void overpower(World world, BlockPos pos) {

    }

    @Override
    public boolean isMechanicalOn(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public void setMechanicalOn(World world, BlockPos pos, boolean isOn) {

    }

    @Override
    public boolean isMechanicalOnFromState(IBlockState state) {
        return false;
    }

    @Override
    public String[] getVariants() {
        return new String[]{
                "facing=up,ison=false,machinetype=cauldron",
                "facing=up,ison=false,machinetype=hopper"
        };
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
