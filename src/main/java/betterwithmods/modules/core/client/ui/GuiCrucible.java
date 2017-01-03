package betterwithmods.modules.core.client.ui;

import betterwithmods.modules.core.tiles.TileEntityCrucible;
import net.minecraft.entity.player.EntityPlayer;

public class GuiCrucible extends GuiCookingPot {
    public GuiCrucible(EntityPlayer player, TileEntityCrucible crucible) {
        super(player, crucible);
    }
}
