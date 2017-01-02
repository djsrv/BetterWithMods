package betterwithmods.modules.recipes.features;

import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.base.items.ItemMaterial;
import betterwithmods.base.modules.Feature;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class SteelRecipe extends Feature {
    public boolean requiresSoulFlux;

    @Override
    public void setupConfig() {
        requiresSoulFlux = loadPropBool("requiresSoulFlux","Whether the steel recipes requires soulflux, requires going to the end",true);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        CrucibleRecipes.addOreStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel"), new ItemStack(BWMBlocks.URN, 1, 0), new Object[]{"dustCoal", new ItemStack(BWMBlocks.URN, 1, 8), "ingotIron", requiresSoulFlux ? ItemMaterial.getMaterial("soul_flux") : null});
        CauldronRecipes.addStokedCauldronRecipe(ItemMaterial.getMaterial("brimstone"), (requiresSoulFlux ?  ItemMaterial.getMaterial("soul_flux"): null),new ItemStack[]{ItemMaterial.getMaterial("ender_slag")});
        KilnRecipes.addKilnRecipe(Blocks.END_STONE, 0, new ItemStack(BWMBlocks.AESTHETIC, 1, 7), ItemMaterial.getMaterial(requiresSoulFlux ? "ender_slag" : "brimstone"));
    }
}
