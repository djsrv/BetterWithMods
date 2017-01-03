package betterwithmods.modules.recipes.features;

import betterwithmods.base.modules.Feature;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class EffeciencyRecipes extends Feature {

    @Override
    public void init(FMLInitializationEvent event) {
        //TODO
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 1), "PIP", "GLG", "PIP", 'P', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 'I', "ingotIron", 'G', "gearWood", 'L', ItemMaterial.getMaterial("redstone_latch")));
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BWMBlocks.PLATFORM), "MWM", " M ", "MWM", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, 32767), 'W', new ItemStack(BWMBlocks.PANE, 1, 2)));
//        GameRegistry.addShapedRecipe(new ItemStack(BWMBlocks.AXLE), "M", "R", "M", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE), 'R', BWMBlocks.ROPE);
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BWMBlocks.GEARBOX), "SGS", "GLG", "SGS", 'L', ItemMaterial.getMaterial("redstone_latch"), 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'G', "gearWood"));
//
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.STONE_BRICK_STAIRS, "M ", "MM", 'M', new ItemStack(BWMBlocks.STONE_MOULDING, 1, BlockMini.EnumType.STONEBRICK.getMetadata())).setMirrored(true));
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.NETHER_BRICK_STAIRS, "M ", "MM", 'M', new ItemStack(BWMBlocks.STONE_MOULDING, 1, BlockMini.EnumType.NETHERBRICK.getMetadata())).setMirrored(true));
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.BRICK_STAIRS, "M ", "MM", 'M', new ItemStack(BWMBlocks.STONE_MOULDING, 1, BlockMini.EnumType.BRICK.getMetadata())).setMirrored(true));
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.SANDSTONE_STAIRS, "M ", "MM", 'M', new ItemStack(BWMBlocks.STONE_MOULDING, 1, BlockMini.EnumType.SANDSTONE.getMetadata())).setMirrored(true));
//
//
//        GameRegistry.addShapedRecipe(new ItemStack(Blocks.BOOKSHELF), "SSS", "BBB", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'B', Items.BOOK);
//        GameRegistry.addShapedRecipe(new ItemStack(Blocks.CHEST), "SSS", "S S", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.NOTEBLOCK), "SSS", "SRS", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone"));
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.JUKEBOX), "SSS", "SDS", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'D', "gemDiamond"));
//        GameRegistry.addShapedRecipe(new ItemStack(Blocks.LADDER, 4), "M M", "MMM", "M M", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addShapedRecipe(new ItemStack(Blocks.TRAPDOOR, 2), "SSS", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addShapedRecipe(new ItemStack(Items.SIGN, 3), "S", "M", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK), new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.BOOK), ItemMaterial.getMaterial("leather_cut"), "paper", "paper", "paper"));
//        GameRegistry.addShapedRecipe(new ItemStack(Items.ITEM_FRAME), "MMM", "MLM", "MMM", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE), 'L', ItemMaterial.getMaterial("leather_cut"));
//        GameRegistry.addShapedRecipe(new ItemStack(Items.BOWL, 6), "S S", " S ", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE));
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BWMBlocks.SAW), "III", "GBG", "WGW", 'I', "ingotIron", 'G', "gearWood", 'W', BWMBlocks.WOOD_SIDING, 'B', ItemMaterial.getMaterial("leather_belt")));
//
//        ItemStack[] doors = {new ItemStack(Items.OAK_DOOR, 3), new ItemStack(Items.SPRUCE_DOOR, 3), new ItemStack(Items.BIRCH_DOOR, 3), new ItemStack(Items.JUNGLE_DOOR, 3), new ItemStack(Items.ACACIA_DOOR, 3), new ItemStack(Items.DARK_OAK_DOOR, 3)};
//        ItemStack[] boats = {new ItemStack(Items.BOAT), new ItemStack(Items.SPRUCE_BOAT), new ItemStack(Items.BIRCH_BOAT), new ItemStack(Items.JUNGLE_BOAT), new ItemStack(Items.ACACIA_BOAT), new ItemStack(Items.DARK_OAK_BOAT)};
//        ItemStack[] fences = {new ItemStack(Blocks.OAK_FENCE, 2), new ItemStack(Blocks.SPRUCE_FENCE, 2), new ItemStack(Blocks.BIRCH_FENCE, 2), new ItemStack(Blocks.JUNGLE_FENCE, 2), new ItemStack(Blocks.ACACIA_FENCE, 2), new ItemStack(Blocks.DARK_OAK_FENCE, 2)};
//        ItemStack[] gates = {new ItemStack(Blocks.OAK_FENCE_GATE), new ItemStack(Blocks.SPRUCE_FENCE_GATE), new ItemStack(Blocks.BIRCH_FENCE_GATE), new ItemStack(Blocks.JUNGLE_FENCE_GATE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(Blocks.DARK_OAK_FENCE_GATE)};
//        ItemStack[] stairs = {new ItemStack(Blocks.OAK_STAIRS), new ItemStack(Blocks.SPRUCE_STAIRS), new ItemStack(Blocks.BIRCH_STAIRS), new ItemStack(Blocks.JUNGLE_STAIRS), new ItemStack(Blocks.ACACIA_STAIRS), new ItemStack(Blocks.DARK_OAK_STAIRS)};
//
//        GameRegistry.addShapedRecipe(doors[0], "SS", "SS", "SS", 'S', BWMBlocks.WOOD_SIDING);
//        GameRegistry.addShapedRecipe(boats[0], "S S", "SSS", 'S', BWMBlocks.WOOD_SIDING);
//        GameRegistry.addShapedRecipe(fences[0], "MMM", 'M', BWMBlocks.WOOD_MOULDING);
//        GameRegistry.addShapedRecipe(gates[0], "MSM", 'M', BWMBlocks.WOOD_MOULDING, 'S', BWMBlocks.WOOD_SIDING);
//        GameRegistry.addRecipe(new ShapedOreRecipe(stairs[0], "M ", "MM", 'M', BWMBlocks.WOOD_MOULDING).setMirrored(true));
//
//        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            int meta = type.getMetadata();
//            GameRegistry.addShapedRecipe(doors[meta], "SS", "SS", "SS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, meta));
//            GameRegistry.addShapedRecipe(boats[meta], "S S", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, meta));
//            GameRegistry.addShapedRecipe(fences[meta], "MMM", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, meta));
//            GameRegistry.addShapedRecipe(gates[meta], "MSM", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, meta), 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, meta));
//            GameRegistry.addRecipe(new ShapedOreRecipe(stairs[meta], "M ", "MM", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, meta)).setMirrored(true));
//        }
//
//        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            GameRegistry.addShapelessRecipe(new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_CORNER, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_CORNER, 1, type.getMetadata()));
//            GameRegistry.addShapelessRecipe(new ItemStack(BWMBlocks.WOOD_SIDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()));
//            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_SIDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.WOOD_SIDING, 1, type.getMetadata()));
//            GameRegistry.addShapedRecipe(new ItemStack(BWMBlocks.WOOD_TABLE, 4, type.getMetadata()), "SSS", " M ", " M ", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, type.getMetadata()), 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()));
//            GameRegistry.addShapedRecipe(new ItemStack(BWMBlocks.WOOD_BENCH, 4, type.getMetadata()), "SSS", " M ", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, type.getMetadata()), 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()));
//        }
//
//        for (BlockMini.EnumType type : BlockMini.EnumType.values()) {
//            GameRegistry.addShapelessRecipe(new ItemStack(BWMBlocks.STONE_MOULDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.STONE_CORNER, 1, type.getMetadata()), new ItemStack(BWMBlocks.STONE_CORNER, 1, type.getMetadata()));
//            GameRegistry.addShapelessRecipe(new ItemStack(BWMBlocks.STONE_SIDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.STONE_MOULDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.STONE_MOULDING, 1, type.getMetadata()));
//            GameRegistry.addShapelessRecipe(type.getBlock(), new ItemStack(BWMBlocks.STONE_SIDING, 1, type.getMetadata()), new ItemStack(BWMBlocks.STONE_SIDING, 1, type.getMetadata()));
//        }
//
//        if (ModuleLoader.isFeatureEnabled(HCLumber.class)) {
//            for (int i = 0; i < 4; i++)
//                GameRegistry.addRecipe(new ChoppingRecipe(new ItemStack(Blocks.PLANKS, 1, i), null, ItemMaterial.getMaterial("sawdust", 2), new ItemStack(BWMBlocks.DEBARKED_OLD, 1, i)));
//            for (int i = 0; i < 2; i++)
//                GameRegistry.addRecipe(new ChoppingRecipe(new ItemStack(Blocks.PLANKS, 1, 4 + i), null, ItemMaterial.getMaterial("sawdust", 2), new ItemStack(BWMBlocks.DEBARKED_NEW, 1, i)));
//        } else {
//            for (int i = 0; i < 4; i++)
//                GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 3, i), new ItemStack(BWMBlocks.DEBARKED_OLD, 1, i));
//            for (int i = 0; i < 2; i++)
//                GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 3, 4 + i), new ItemStack(BWMBlocks.DEBARKED_NEW, 1, i));
//        }
    }

}
