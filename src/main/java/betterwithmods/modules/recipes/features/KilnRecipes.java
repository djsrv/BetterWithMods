package betterwithmods.modules.recipes.features;

import betterwithmods.api.crafting.blockmeta.KilnInteraction;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class KilnRecipes extends Feature {
    public static boolean enableOre, enableCharcoal;

    @Override
    public void setupConfig() {
        enableOre = loadPropBool("Enable Ore Recipes", "Allow Ore To Be Smelted In The Kiln (Still follows HCOre)", true);
        enableCharcoal = loadPropBool("Enable Charcoal", "Allows Smelting Logs into Charcoal in the Kiln", true);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        //TODO
//        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 0, new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 2));
//        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 1, new ItemStack(BWMBlocks.PLANTER));
//        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 2, new ItemStack(BWMBlocks.URN));
//        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 3, new ItemStack(BWMBlocks.VASE));
//        addKilnRecipe(Blocks.CLAY, 0, new ItemStack(Blocks.HARDENED_CLAY));
//        addKilnRecipe(BWMBlocks.RAW_PASTRY, 0, new ItemStack(Items.CAKE));
//        if (ModuleLoader.isFeatureEnabled(HCHunger.class)) {
//            addKilnRecipe(BWMBlocks.RAW_PASTRY, 2, new ItemStack(Items.COOKIE, 8));
//            addKilnRecipe(BWMBlocks.RAW_PASTRY, 1, new ItemStack(Items.PUMPKIN_PIE, 1));
//        } else {
//            addKilnRecipe(BWMBlocks.RAW_PASTRY, 2, new ItemStack(Items.COOKIE, 16));
//        }
//        if (enableCharcoal) {
//            for (ItemStack stack : OreDictionary.getOres("logWood")) {
//                if (stack.getItem() instanceof ItemBlock) {
//                    Item item = stack.getItem();
//                    Block blocks = ((ItemBlock) item).getBlock();
//                    int meta = stack.getItemDamage();
//                    if (meta == OreDictionary.WILDCARD_VALUE)
//                        addKilnRecipe(blocks, new ItemStack(Items.COAL, 2, 1));
//                    else {
//                        addKilnRecipe(blocks, meta, new ItemStack(Items.COAL, 2, 1));
//                    }
//                }
//            }
//            addKilnRecipe(BWMBlocks.DEBARKED_OLD, new ItemStack(Items.COAL, 2, 1));
//            addKilnRecipe(BWMBlocks.DEBARKED_NEW, new ItemStack(Items.COAL, 2, 1));
//        }

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        if (enableOre) {
            InvUtils.oreNames.stream().filter(ore -> ore.getItem() instanceof ItemBlock).forEach(ore -> {
                ItemStack output = FurnaceRecipes.instance().getSmeltingResult(ore);
                if (ore != null && output != null)
                    addKilnRecipe(ore, output);
            });
        }
    }

    public static void addKilnRecipe(ItemStack inputBlock, ItemStack... output) {
        KilnInteraction.INSTANCE.addRecipe(inputBlock, output);
    }

    public static void addKilnRecipe(Block inputBlock, ItemStack... output) {
        KilnInteraction.INSTANCE.addRecipe(inputBlock, 0, output);
    }

    public static void addKilnRecipe(Block inputBlock, int inputMeta, ItemStack... output) {
        KilnInteraction.INSTANCE.addRecipe(inputBlock, inputMeta, output);
    }
}
