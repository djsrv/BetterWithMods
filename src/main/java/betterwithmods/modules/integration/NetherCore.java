package betterwithmods.modules.integration;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.RecipeUtils;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/26/16
 */
public class NetherCore extends Feature {
    public static final String MODID = "nethercore";

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        BWMod.logger.info("Replacing " + MODID + " nether spore recipe");
        Item nether_spore = Item.REGISTRY.getObject(new ResourceLocation(MODID, "nether_spore"));
        System.out.println(nether_spore);
        RecipeUtils.removeRecipes(nether_spore, 0);

        //TODO
//        CauldronRecipes.addCauldronRecipe(new ItemStack(nether_spore),
//                new ItemStack[]{new ItemStack(Blocks.BROWN_MUSHROOM), new ItemStack(Blocks.RED_MUSHROOM), new ItemStack(Blocks.MYCELIUM), new ItemStack(BWMBlocks.URN, 8, 8), new ItemStack(Items.NETHER_WART)}
//        );
    }

}
