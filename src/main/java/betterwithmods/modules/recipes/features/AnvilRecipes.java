package betterwithmods.modules.recipes.features;

import betterwithmods.api.crafting.steelanvil.CraftingManagerSteelAnvil;
import betterwithmods.api.crafting.steelanvil.ShapedSteelAnvilRecipe;
import betterwithmods.base.modules.Feature;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class AnvilRecipes extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {

        //TODO
        /*addShapedSteelAnvilRecipe(BWMBlocks.BLOCK_DISPENSER, "MMMM", "MUUM", "STTS", "SRRS", 'M', Blocks.MOSSY_COBBLESTONE, 'U', new ItemStack(BWMBlocks.URN, 1, 8), 'S', "stone", 'R', "dustRedstone", 'T', Blocks.REDSTONE_TORCH);
        addShapedSteelAnvilRecipe(BWMBlocks.BUDDY_BLOCK, "SSLS", "LTTS", "STTL", "SLSS", 'S', "stone", 'T', Blocks.REDSTONE_TORCH, 'L', ItemMaterial.getMaterial("polished_lapis"));
        addShapedSteelAnvilRecipe(BWMBlocks.DETECTOR, "CCCC", "LTTL", "SRRS", "SRRS", 'C', "cobblestone", 'L', ItemMaterial.getMaterial("polished_lapis"), 'T', Blocks.REDSTONE_TORCH, 'S', "stone", 'R', "dustRedstone");
        addShapedSteelAnvilRecipe(BWMItems.STEEL_HELMET, "SSSS", "S  S", "S  S", " PP ", 'P', ItemMaterial.getMaterial("armor_plate"), 'S', ItemMaterial.getMaterial("ingot_steel"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_CHEST, "P  P", "SSSS", "SSSS", "SSSS", 'P', ItemMaterial.getMaterial("armor_plate"), 'S', ItemMaterial.getMaterial("ingot_steel"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_PANTS, "SSSS", "PSSP", "P  P", "P  P", 'P', ItemMaterial.getMaterial("armor_plate"), 'S', ItemMaterial.getMaterial("ingot_steel"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_BOOTS, " SS ", " SS ", "SPPS", 'P', ItemMaterial.getMaterial("armor_plate"), 'S', ItemMaterial.getMaterial("ingot_steel"));
        addShapedSteelAnvilRecipe(ItemMaterial.getMaterial("polished_lapis", 2), "LLL", "LLL", "GGG", " R ", 'L', "gemLapis", 'R', "dustRedstone", 'G', "nuggetGold");
        addShapedSteelAnvilRecipe(BWMItems.STEEL_AXE, "XX", "XH", " H", " H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft")).setMirrored(true);
        addShapedSteelAnvilRecipe(BWMItems.STEEL_HOE, "XX", " H", " H", " H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft")).setMirrored(true);
        addShapedSteelAnvilRecipe(BWMItems.STEEL_PICKAXE, "XXX", " H ", " H ", " H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_SHOVEL, "X", "H", "H", "H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_SWORD, "X", "X", "X", "H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft"));
        addShapedSteelAnvilRecipe(BWMItems.STEEL_BATTLEAXE, "XXX", "XHX", " H ", " H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft")).setMirrored(true);
        addShapedSteelAnvilRecipe(BWMItems.STEEL_MATTOCK, " XXX", "X H ", "  H ", "  H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial("haft"));
        addShapedSteelAnvilRecipe(ItemMaterial.getMaterial("armor_plate"), "BSPB", 'B', ItemMaterial.getMaterial("leather_strap"), 'S', ItemMaterial.getMaterial("ingot_steel"), 'P', ItemMaterial.getMaterial("padding")).setMirrored(true);
        addShapedSteelAnvilRecipe(ItemMaterial.getMaterial("broadhead", 6), " N ", " N ", "NNN", " N ", 'N', "nuggetSoulforgedSteel");
        addShapedSteelAnvilRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 2), "XXXX", "XXXX", "XXXX", "XXXX", 'X', "ingotSoulforgedSteel");
        addShapedSteelAnvilRecipe(new ItemStack(BWMBlocks.AESTHETIC, 6, 0), "X  X", "XXXX", 'X', "stone");
        addShapedSteelAnvilRecipe(ItemMaterial.getMaterial("chain_mail", 2), "N N ", " N N", "N N ", " N N", 'N', "nuggetIron").setMirrored(true);

        for (BlockMini.EnumType type : BlockMini.EnumType.values()) {
            addShapedSteelAnvilRecipe(new ItemStack(BWMBlocks.STONE_SIDING, 8, type.getMetadata()), "XXXX", 'X', type.getBlock());
            addShapedSteelAnvilRecipe(new ItemStack(BWMBlocks.STONE_MOULDING, 8, type.getMetadata()), "XXXX", 'X', new ItemStack(BWMBlocks.STONE_SIDING, 1, type.getMetadata()));
            addShapedSteelAnvilRecipe(new ItemStack(BWMBlocks.STONE_CORNER, 8, type.getMetadata()), "XXXX", 'X', new ItemStack(BWMBlocks.STONE_MOULDING, 1, type.getMetadata()));
        }*/
    }


    public static ShapedSteelAnvilRecipe addShapedSteelAnvilRecipe(Item result, Object... recipe) {
        return addShapedSteelAnvilRecipe(new ItemStack(result), recipe);
    }

    public static ShapedSteelAnvilRecipe addShapedSteelAnvilRecipe(Block result, Object... recipe) {
        return addShapedSteelAnvilRecipe(new ItemStack(result), recipe);
    }

    public static ShapedSteelAnvilRecipe addShapedSteelAnvilRecipe(ItemStack result, Object... recipe) {
        return CraftingManagerSteelAnvil.INSTANCE.addRecipe(result, recipe);
    }
}
