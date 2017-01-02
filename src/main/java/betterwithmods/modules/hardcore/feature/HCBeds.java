package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.player.EntityPlayerExt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCBeds extends Feature {
    /**
     * Disable Beds
     */
    @SubscribeEvent
    public void onSleepInBed(PlayerSleepInBedEvent event) {
        if (EntityPlayerExt.isSurvival(event.getEntityPlayer())) event.setResult(EntityPlayer.SleepResult.NOT_POSSIBLE_NOW);
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
