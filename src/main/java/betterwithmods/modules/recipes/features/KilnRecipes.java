package betterwithmods.modules.recipes.features;

import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.api.crafting.blockmeta.KilnInteraction;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.hardcore.feature.HCHunger;
import betterwithmods.base.util.InvUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

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
        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 0, new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 2));
        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 1, new ItemStack(BWMBlocks.PLANTER));
        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 2, new ItemStack(BWMBlocks.URN));
        addKilnRecipe(BWMBlocks.UNFIRED_POTTERY, 3, new ItemStack(BWMBlocks.VASE));
        addKilnRecipe(Blocks.CLAY, 0, new ItemStack(Blocks.HARDENED_CLAY));
        addKilnRecipe(BWMBlocks.RAW_PASTRY, 0, new ItemStack(Items.CAKE));
        if (ModuleLoader.isFeatureEnabled(HCHunger.class)) {
            addKilnRecipe(BWMBlocks.RAW_PASTRY, 2, new ItemStack(Items.COOKIE, 8));
            addKilnRecipe(BWMBlocks.RAW_PASTRY, 1, new ItemStack(Items.PUMPKIN_PIE, 1));
        } else {
            addKilnRecipe(BWMBlocks.RAW_PASTRY, 2, new ItemStack(Items.COOKIE, 16));
        }
        if (enableOre) {
            InvUtils.oreNames.stream().filter(ore -> ore.getItem() instanceof ItemBlock).forEach(ore -> {
                ItemStack output = FurnaceRecipes.instance().getSmeltingResult(ore);
                if (ore != null && output != null)
                    addKilnRecipe(ore, output);
            });
        }
        if (enableCharcoal) {
            for (ItemStack stack : OreDictionary.getOres("logWood")) {
                if (stack.getItem() instanceof ItemBlock) {
                    Item item = stack.getItem();
                    Block block = ((ItemBlock) item).getBlock();
                    int meta = stack.getItemDamage();
                    if (meta == OreDictionary.WILDCARD_VALUE)
                        addKilnRecipe(block, new ItemStack(Items.COAL, 2, 1));
                    else {
                        addKilnRecipe(block, meta, new ItemStack(Items.COAL, 2, 1));
                    }
                }
            }
            addKilnRecipe(BWMBlocks.DEBARKED_OLD, new ItemStack(Items.COAL, 2, 1));
            addKilnRecipe(BWMBlocks.DEBARKED_NEW, new ItemStack(Items.COAL, 2, 1));
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
