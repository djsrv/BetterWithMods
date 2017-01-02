package betterwithmods.modules.recipes.features;

import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.modules.config.BWConfig;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucibleStoked;
import betterwithmods.base.items.ItemMaterial;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.hardcore.feature.HCDiamond;
import betterwithmods.modules.hardcore.feature.HCOre;
import betterwithmods.base.util.InvUtils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

import static betterwithmods.modules.recipes.features.CrucibleRecipes.addStokedCrucibleRecipe;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class RecylingRecipes extends Feature {
    public static int reclaimCount;

    @Override
    public void setupConfig() {
        reclaimCount = loadPropInt("Nugget Reclaim", "Amount (in nuggets per ingot) tools and armor in the crucible reclaim. Does not affect diamond or soulforged steel ingot reclamation. (Set to 0 to disable reclamation entirely.)", 9, 0, 9);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if (reclaimCount > 0) {
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 2), new ItemStack[]{new ItemStack(BWMItems.STEEL_HOE, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 2), new ItemStack[]{new ItemStack(BWMItems.STEEL_SWORD, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 3), new ItemStack[]{new ItemStack(BWMItems.STEEL_SWORD, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 3), new ItemStack[]{new ItemStack(BWMItems.STEEL_PICKAXE, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 3), new ItemStack[]{new ItemStack(BWMItems.STEEL_AXE, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel"), new ItemStack[]{new ItemStack(BWMItems.STEEL_SHOVEL, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 4), new ItemStack[]{new ItemStack(BWMItems.STEEL_MATTOCK, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 5), new ItemStack[]{new ItemStack(BWMItems.STEEL_BATTLEAXE, 1, OreDictionary.WILDCARD_VALUE)});
            addReclaimRecipe(new ItemStack(Items.IRON_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE), "Iron", 8);
            addReclaimRecipe(new ItemStack(Items.IRON_AXE, 1, OreDictionary.WILDCARD_VALUE), "Iron", 3);
            addReclaimRecipe(new ItemStack(Items.IRON_BOOTS, 1, OreDictionary.WILDCARD_VALUE), "Iron", 4);
            addReclaimRecipe(new ItemStack(Items.IRON_HELMET, 1, OreDictionary.WILDCARD_VALUE), "Iron", 5);
            addReclaimRecipe(new ItemStack(Items.IRON_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE), "Iron", 7);
            addReclaimRecipe(new ItemStack(Items.IRON_HOE, 1, OreDictionary.WILDCARD_VALUE), "Iron", 2);
            addReclaimRecipe(new ItemStack(Items.IRON_PICKAXE, 1, OreDictionary.WILDCARD_VALUE), "Iron", 3);
            addReclaimRecipe(new ItemStack(Items.IRON_SHOVEL, 1, OreDictionary.WILDCARD_VALUE), "Iron", 1);
            addReclaimRecipe(new ItemStack(Items.IRON_SWORD, 1, OreDictionary.WILDCARD_VALUE), "Iron", 2);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE), "Gold", 8);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_AXE, 1, OreDictionary.WILDCARD_VALUE), "Gold", 3);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_BOOTS, 1, OreDictionary.WILDCARD_VALUE), "Gold", 4);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_HELMET, 1, OreDictionary.WILDCARD_VALUE), "Gold", 5);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE), "Gold", 7);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_HOE, 1, OreDictionary.WILDCARD_VALUE), "Gold", 2);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_PICKAXE, 1, OreDictionary.WILDCARD_VALUE), "Gold", 3);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_SHOVEL, 1, OreDictionary.WILDCARD_VALUE), "Gold", 1);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_SWORD, 1, OreDictionary.WILDCARD_VALUE), "Gold", 2);
            addReclaimRecipe(new ItemStack(Items.SHEARS, 1, OreDictionary.WILDCARD_VALUE), "Iron", 2);
            addReclaimRecipe(new ItemStack(Items.IRON_DOOR), "Iron", 6);
            addReclaimRecipe(new ItemStack(Items.IRON_HORSE_ARMOR, 1, OreDictionary.WILDCARD_VALUE), "Iron", 8);
            addReclaimRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1, OreDictionary.WILDCARD_VALUE), "Gold", 8);
            addReclaimRecipe(new ItemStack(Items.MINECART), "Iron", 5);
            addReclaimRecipe(new ItemStack(Items.CHEST_MINECART), "Iron", 5);
            addReclaimRecipe(new ItemStack(Items.FURNACE_MINECART), "Iron", 5);
            addReclaimRecipe(new ItemStack(Blocks.RAIL, 8), "Iron", 3);
            addReclaimRecipe(new ItemStack(Blocks.IRON_BARS, 8), "Iron", 3);
            addReclaimRecipe(new ItemStack(Items.CAULDRON), "Iron", 7);
            addReclaimRecipe(new ItemStack(Blocks.ANVIL, 1, OreDictionary.WILDCARD_VALUE), "Iron", 31);
            addReclaimRecipe(new ItemStack(Blocks.TRIPWIRE_HOOK, 2, 0), "Iron", 1);
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 10), new ItemStack[]{new ItemStack(BWMItems.STEEL_HELMET, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 14), new ItemStack[]{new ItemStack(BWMItems.STEEL_CHEST, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 12), new ItemStack[]{new ItemStack(BWMItems.STEEL_PANTS, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 8), new ItemStack[]{new ItemStack(BWMItems.STEEL_BOOTS, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("nugget_iron", 4), new ItemStack[]{ItemMaterial.getMaterial("chain_mail")});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("nugget_iron", 25), new ItemStack[]{new ItemStack(Items.CHAINMAIL_HELMET, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("nugget_iron", 40), new ItemStack[]{new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("nugget_iron", 35), new ItemStack[]{new ItemStack(Items.CHAINMAIL_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("nugget_iron", 20), new ItemStack[]{new ItemStack(Items.CHAINMAIL_BOOTS, 1, OreDictionary.WILDCARD_VALUE)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 7), new ItemStack[]{new ItemStack(BWMBlocks.STEEL_ANVIL)});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel"), new ItemStack[]{ItemMaterial.getMaterial("armor_plate")});
            addStokedCrucibleRecipe(ItemMaterial.getMaterial("ingot_steel", 16), new ItemStack[]{new ItemStack(BWMBlocks.AESTHETIC, 1, 2)});
            if (ModuleLoader.isFeatureEnabled(HCDiamond.class)) {
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 3), new ItemStack[]{new ItemStack(Items.DIAMOND_AXE, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 2), new ItemStack[]{new ItemStack(Items.DIAMOND_HOE, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 3), new ItemStack[]{new ItemStack(Items.DIAMOND_PICKAXE, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 1), new ItemStack[]{new ItemStack(Items.DIAMOND_SHOVEL, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 2), new ItemStack[]{new ItemStack(Items.DIAMOND_SWORD, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 5), new ItemStack[]{new ItemStack(Items.DIAMOND_HELMET, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 8), new ItemStack[]{new ItemStack(Items.DIAMOND_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 7), new ItemStack[]{new ItemStack(Items.DIAMOND_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE)});
                addStokedCrucibleRecipe(ItemMaterial.getMaterial("diamond_ingot", 4), new ItemStack[]{new ItemStack(Items.DIAMOND_BOOTS, 1, OreDictionary.WILDCARD_VALUE)});
            }
        }
        if (ModuleLoader.isFeatureEnabled(HCOre.class)) {
            addStokedCrucibleRecipe(new ItemStack(InvUtils.getOreNames("nuggetIron").get(0).getItem(), 3), new ItemStack[]{new ItemStack(Items.BUCKET)});
        } else {
            addStokedCrucibleRecipe(new ItemStack(Items.IRON_INGOT, 3), new ItemStack[]{new ItemStack(Items.BUCKET)});
        }
    }


    public static void addReclaimRecipe(ItemStack input, String oreSuffix, int ingotCount) {
        int totalNuggets = ingotCount * BWConfig.reclaimCount;
        int ingots = totalNuggets / 9;
        int nuggets = totalNuggets % 9;
        ItemStack ingotStack = null;
        ItemStack nuggetStack = null;
        if (ingots > 0 && !OreDictionary.getOres("ingot" + oreSuffix).isEmpty())
            ingotStack = OreDictionary.getOres("ingot" + oreSuffix).get(0);
        if (nuggets > 0 && !OreDictionary.getOres("nugget" + oreSuffix).isEmpty())
            nuggetStack = OreDictionary.getOres("nugget" + oreSuffix).get(0);
        if (ingotStack == null) {
            if (nuggetStack != null) {
                CraftingManagerCrucibleStoked.getInstance().addRecipe(new ItemStack(nuggetStack.getItem(), totalNuggets > nuggets ? totalNuggets : nuggets, nuggetStack.getMetadata()), input.copy());
            }
        } else {
            CraftingManagerCrucibleStoked.getInstance().addRecipe(new ItemStack(ingotStack.getItem(), ingots, ingotStack.getMetadata()), nuggetStack != null ? new ItemStack(nuggetStack.getItem(), nuggets, nuggetStack.getMetadata()) : null, input.copy());
        }
    }

}
