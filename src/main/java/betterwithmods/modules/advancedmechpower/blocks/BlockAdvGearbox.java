package betterwithmods.modules.advancedmechpower.blocks;

import betterwithmods.modules.advancedmechpower.tiles.TileEntityAdvancedGearbox;
import betterwithmods.modules.mechpower.blocks.BlockGearbox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdvGearbox extends BlockGearbox {
    public BlockAdvGearbox() {
        super();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityAdvancedGearbox();
    }
}
