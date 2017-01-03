package betterwithmods.modules.core.client.ui;

import betterwithmods.modules.core.tiles.TileEntityCauldron;
import net.minecraft.entity.player.EntityPlayer;

public class GuiCauldron extends GuiCookingPot {
    public GuiCauldron(EntityPlayer player, TileEntityCauldron cauldron) {
        super(player, cauldron);
    }
}
