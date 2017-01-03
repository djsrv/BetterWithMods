package betterwithmods.base.client.gui;

import betterwithmods.modules.utilities.client.ui.ContainerBlockDispenser;
import betterwithmods.modules.core.client.ui.ContainerCookingPot;
import betterwithmods.modules.core.client.ui.ContainerFilteredHopper;
import betterwithmods.modules.core.client.ui.ContainerMill;
import betterwithmods.modules.core.client.ui.ContainerPulley;
import betterwithmods.modules.core.client.ui.ContainerSteelAnvil;
import betterwithmods.modules.utilities.client.ui.GuiBlockDispenser;
import betterwithmods.modules.core.client.ui.GuiCauldron;
import betterwithmods.modules.core.client.ui.GuiCrucible;
import betterwithmods.modules.core.client.ui.GuiFilteredHopper;
import betterwithmods.modules.core.client.ui.GuiMill;
import betterwithmods.modules.core.client.ui.GuiPulley;
import betterwithmods.modules.core.client.ui.GuiSteelAnvil;
import betterwithmods.modules.core.tiles.TileEntityCauldron;
import betterwithmods.modules.core.tiles.TileEntityCrucible;
import betterwithmods.modules.core.tiles.TileEntityFilteredHopper;
import betterwithmods.modules.core.tiles.TileEntityMill;
import betterwithmods.modules.core.tiles.TileEntityPulley;
import betterwithmods.modules.core.tiles.TileEntitySteelAnvil;
import betterwithmods.modules.utilities.tiles.TileEntityBlockDispenser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BWGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (ID == 0) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityPulley)
                return new ContainerPulley(player, (TileEntityPulley) tile);
            if (tile instanceof TileEntityBlockDispenser)
                return new ContainerBlockDispenser(player, (TileEntityBlockDispenser) tile);
            if (tile instanceof TileEntityCrucible)
                return new ContainerCookingPot(player, (TileEntityCrucible) tile);
            if (tile instanceof TileEntityCauldron)
                return new ContainerCookingPot(player, (TileEntityCauldron) tile);
            if (tile instanceof TileEntityMill)
                return new ContainerMill(player, (TileEntityMill) tile);
            if (tile instanceof TileEntityFilteredHopper)
                return new ContainerFilteredHopper(player, (TileEntityFilteredHopper) tile);
            if (tile instanceof TileEntitySteelAnvil)
                return new ContainerSteelAnvil(player.inventory, world, pos, (TileEntitySteelAnvil) tile);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (ID == 0) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityPulley)
                return new GuiPulley(player, (TileEntityPulley) tile);
            if (tile instanceof TileEntityBlockDispenser)
                return new GuiBlockDispenser(player, (TileEntityBlockDispenser) tile);
            if (tile instanceof TileEntityCrucible)
                return new GuiCrucible(player, (TileEntityCrucible) tile);
            if (tile instanceof TileEntityCauldron)
                return new GuiCauldron(player, (TileEntityCauldron) tile);
            if (tile instanceof TileEntityMill)
                return new GuiMill(player, (TileEntityMill) tile);
            if (tile instanceof TileEntityFilteredHopper)
                return new GuiFilteredHopper(player, (TileEntityFilteredHopper) tile);
            if (tile instanceof TileEntitySteelAnvil)
                return new GuiSteelAnvil(player.inventory, world, pos, (TileEntitySteelAnvil) tile);
        }
        return null;
    }

}
