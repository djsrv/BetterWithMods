package betterwithmods.modules.recipes.features;

import betterwithmods.api.crafting.bulk.CraftingManagerCauldron;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldronStoked;
import betterwithmods.base.modules.Feature;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.Map;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class CauldronRecipes extends Feature {

    @Override
    public void init(FMLInitializationEvent event) {
        unstoked();
        stoked();
        cookableFoods();
    }

    public void cookableFoods() {
        Map<ItemStack, ItemStack> furnace = FurnaceRecipes.instance().getSmeltingList();
        for (ItemStack input : furnace.keySet()) {
            if (input != null) {
                if (input.getItem() instanceof ItemFood && input.getItem() != Items.BREAD) {
                    ItemStack output = FurnaceRecipes.instance().getSmeltingResult(input);
                    if (output != null) {
                        CauldronRecipes.addCauldronRecipe(output.copy(), new ItemStack[]{input.copy()});
                    }
                }
            }
        }
    }
    public void unstoked() {
    //TODO
//        addCauldronRecipe(new ItemStack(BWMItems.CHICKEN_SOUP, 3), new ItemStack[]{new ItemStack(Items.COOKED_CHICKEN), new ItemStack(Items.CARROT), new ItemStack(Items.BAKED_POTATO), new ItemStack(Items.BOWL, 3)});
//        addCauldronRecipe(new ItemStack(BWMItems.CHOCOLATE, 2), new ItemStack(Items.BUCKET), new ItemStack[]{ItemMaterial.getMaterial("cocoa_powder"), new ItemStack(Items.SUGAR), new ItemStack(Items.MILK_BUCKET)});
//        addCauldronRecipe(new ItemStack(BWMItems.CHOWDER, 2), new ItemStack(Items.BUCKET), new ItemStack[]{new ItemStack(Items.COOKED_FISH), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.BOWL, 2)});
//        addCauldronRecipe(new ItemStack(BWMItems.CHOWDER, 2), new ItemStack(Items.BUCKET), new ItemStack[]{new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.BOWL, 2)});
//        addCauldronRecipe(ItemMaterial.getMaterial("tanned_leather"), new ItemStack[]{ItemMaterial.getMaterial("scoured_leather"), ItemMaterial.getMaterial("dung")});
//        addCauldronRecipe(ItemMaterial.getMaterial("tanned_leather_cut", 2), new ItemStack[]{ItemMaterial.getMaterial("scoured_leather_cut", 2), ItemMaterial.getMaterial("dung")});
//
//        addOreCauldronRecipe(ItemMaterial.getMaterial("nether_sludge", 8), new Object[]{"dustPotash", new OreStack("dustHellfire", 4)});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("nethercoal", 4), new Object[]{"dustHellfire", "dustCoal"});
//        addOreCauldronRecipe(new ItemStack(BWMItems.DONUT, 4, 0), new Object[]{"foodFlour", Items.SUGAR});
//        addOreCauldronRecipe(new ItemStack(Items.BREAD), new Object[]{"foodFlour"});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("concentrated_hellfire"), new Object[]{new OreStack("dustHellfire", 8)});
//        addOreCauldronRecipe(new ItemStack(Items.DYE, 1, 2), new Object[]{"blockCactus"});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("filament"), new Object[]{"string", "dustGlowstone", "dustRedstone"});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("element"), new Object[]{Items.BLAZE_POWDER, "dustRedstone", "string"});
//        addOreCauldronRecipe(new ItemStack(Items.GUNPOWDER, 2, 0), new Object[]{"dustSulfur", "dustSaltpeter", "dustCharcoal"});
//        addOreCauldronRecipe(new ItemStack(Items.GUNPOWDER, 2, 0), new Object[]{"dustSulfur", "dustSaltpeter", "dustCoal"});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("blasting_oil", 2), new Object[]{"dustHellfire", ItemMaterial.getMaterial("tallow")});
//        addOreCauldronRecipe(ItemMaterial.getMaterial("fuse"), new Object[]{Items.GUNPOWDER, "string"});
//        addOreCauldronRecipe(new ItemStack(BWMItems.HEARTY_STEW, 5), new Object[]{"listAllmeatcooked", Items.CARROT, Items.BAKED_POTATO, new ItemStack(Items.BOWL, 5), new ItemStack(Blocks.BROWN_MUSHROOM, 3), "foodFlour"});
//
//        String[] barkNames = {"barkOak", "barkSpruce", "barkBirch", "barkJungle", "barkAcacia", "barkDarkOak"};
//        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            int meta = type.getMetadata();
//            addOreCauldronRecipe(ItemMaterial.getMaterial("tanned_leather"), new Object[]{ItemMaterial.getMaterial("scoured_leather"), new OreStack(barkNames[meta], ItemBark.getTanningStackSize(meta))});
//            addOreCauldronRecipe(ItemMaterial.getMaterial("tanned_leather_cut", 2), new Object[]{ItemMaterial.getMaterial("scoured_leather_cut", 2), new OreStack(barkNames[meta], ItemBark.getTanningStackSize(meta))});
//        }
//        if (ModuleLoader.isFeatureEnabled(HCHunger.class)) {
//            addCauldronRecipe(new ItemStack(Items.MUSHROOM_STEW), new ItemStack(Items.BUCKET), new ItemStack[]{new ItemStack(Blocks.BROWN_MUSHROOM, 3), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.BOWL)});
//            addCauldronRecipe(new ItemStack(Items.BEETROOT_SOUP), new ItemStack[]{new ItemStack(Items.BEETROOT, 6), new ItemStack(Items.BOWL)});
//        }
    }

    public void stoked() {
        //TODO
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{new ItemStack(Items.LEATHER)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("tanned_leather")});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("scoured_leather")});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("leather_strap", 8)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("leather_cut", 2)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("tanned_leather_cut", 2)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue"), new ItemStack[]{ItemMaterial.getMaterial("scoured_leather_cut", 2)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue", 2), new ItemStack[]{new ItemStack(Items.LEATHER_HELMET, 1, OreDictionary.WILDCARD_VALUE)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue", 2), new ItemStack[]{new ItemStack(Items.LEATHER_BOOTS, 1, OreDictionary.WILDCARD_VALUE)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue", 3), new ItemStack[]{new ItemStack(Items.LEATHER_LEGGINGS, 1, OreDictionary.WILDCARD_VALUE)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("glue", 4), new ItemStack[]{new ItemStack(Items.LEATHER_CHESTPLATE, 1, OreDictionary.WILDCARD_VALUE)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.COOKED_PORKCHOP)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.PORKCHOP)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.COOKED_BEEF, 4)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.BEEF, 4)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.MUTTON, 6)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.COOKED_MUTTON, 6)});
//        addStokedCauldronRecipe(ItemMaterial.getMaterial("tallow"), new ItemStack[]{new ItemStack(Items.ROTTEN_FLESH, 10)});
//        addOreStokedCauldronRecipe(ItemMaterial.getMaterial("potash"), new Object[]{"logWood"});
//        addOreStokedCauldronRecipe(ItemMaterial.getMaterial("potash"), new Object[]{new OreStack("plankWood", 6)});
//        addOreStokedCauldronRecipe(ItemMaterial.getMaterial("potash"), new Object[]{new OreStack("dustWood", 16)});
    }

    public static void addOreCauldronRecipe(ItemStack output, Object[] inputs) {
        CraftingManagerCauldron.getInstance().addOreRecipe(output, inputs);
    }

    public static void addCauldronRecipe(ItemStack output, ItemStack[] inputs) {
        CraftingManagerCauldron.getInstance().addRecipe(output, inputs);
    }


    public static void addCauldronRecipe(ItemStack output, ItemStack secondary, ItemStack[] inputs) {
        CraftingManagerCauldron.getInstance().addRecipe(output, secondary, inputs);
    }

    public static void addOreStokedCauldronRecipe(ItemStack output, Object[] inputs) {
        CraftingManagerCauldronStoked.getInstance().addOreRecipe(output, inputs);
    }


    public static void addStokedCauldronRecipe(ItemStack output, ItemStack[] inputs) {
        CraftingManagerCauldronStoked.getInstance().addRecipe(output, inputs);
    }

    public static void addStokedCauldronRecipe(ItemStack output, ItemStack secondary, ItemStack[] inputs) {
        CraftingManagerCauldronStoked.getInstance().addRecipe(output, secondary, inputs);
    }

}
