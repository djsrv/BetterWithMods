package betterwithmods.modules.recipes.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.base.util.RecipeUtils;
import betterwithmods.modules.hardcore.feature.HCHunger;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class CraftingRecipes extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        shapeless();
        shaped();
        //TODO
//        GameRegistry.addRecipe(new CuttingRecipe(ItemMaterial.getMaterial("leather_strap", 4), ItemMaterial.getMaterial("tanned_leather_cut")));
//        GameRegistry.addRecipe(new CuttingRecipe(ItemMaterial.getMaterial("leather_cut", 2), new ItemStack(Items.LEATHER)));
//        GameRegistry.addRecipe(new CuttingRecipe(ItemMaterial.getMaterial("tanned_leather_cut", 2), ItemMaterial.getMaterial("tanned_leather")));
//        GameRegistry.addRecipe(new CuttingRecipe(ItemMaterial.getMaterial("scoured_leather_cut", 2), ItemMaterial.getMaterial("scoured_leather")));

        if (ModuleLoader.isFeatureEnabled(HCHunger.class)) {
            RecipeUtils.removeRecipes(Items.BREAD, 0);
            RecipeUtils.removeRecipes(Items.MUSHROOM_STEW, 0);
            RecipeUtils.removeRecipes(Items.CAKE, 0);
            RecipeUtils.removeRecipes(Items.COOKIE, 0);
            RecipeUtils.removeRecipes(Items.PUMPKIN_PIE, 0);
            RecipeUtils.removeRecipes(Items.RABBIT_STEW, 0); //Eat Hearty Stew Instead
            RecipeUtils.removeRecipes(Items.BEETROOT_SOUP, 0);
        }

        //TODO
//        for (int i = 0; i < 16; i++) {
//            addShapelessRecipe(new ItemStack(BWMBlocks.VASE, 1, i), new ItemStack(BWMBlocks.VASE, 1, OreDictionary.WILDCARD_VALUE), ColorUtils.dyes[i]);
//        }
//
//        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            int meta = type.getMetadata();
//            addShapedRecipe(new ItemStack(BWMBlocks.GRATE, 4, meta), "WSW", "WSW", 'S', "stickWood", 'W', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, meta));
//            ItemStack moulding = new ItemStack(BWMBlocks.WOOD_MOULDING, 1, meta);
//            addShapedRecipe(new ItemStack(BWMBlocks.SLATS, 4, meta), "SS", "SS", 'S', moulding);
//            addShapedRecipe(new ItemStack(BWMBlocks.BAMBOO_CHIME, 1, type.getMetadata()), " S ", "SPS", "BMB", 'S', "string", 'P', Blocks.WOODEN_PRESSURE_PLATE, 'B', "sugarcane", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()));
//            addShapedRecipe(new ItemStack(BWMBlocks.METAL_CHIME, 1, type.getMetadata()), " S ", "SPS", "IMI", 'S', "string", 'P', Blocks.WOODEN_PRESSURE_PLATE, 'I', "ingotIron", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, type.getMetadata()));
//        }
    }

    public void shapeless() {
        //TODO
//        addShapelessRecipe(new ItemStack(Items.ENDER_PEARL, 9), new ItemStack(BWMBlocks.AESTHETIC, 1, 8));
//        addShapelessRecipe(new ItemStack(BWMItems.RAW_SCRAMBLED_EGG, 2), BWMItems.RAW_EGG, Items.MILK_BUCKET);
//        addShapelessRecipe(new ItemStack(BWMItems.RAW_OMELET, 2), BWMItems.RAW_EGG, Blocks.BROWN_MUSHROOM, Blocks.BROWN_MUSHROOM, Blocks.BROWN_MUSHROOM);
//        addShapelessRecipe(new ItemStack(BWMItems.BEEF_DINNER, 3), Items.COOKED_BEEF, Items.CARROT, Items.BAKED_POTATO);
//        addShapelessRecipe(new ItemStack(BWMItems.BEEF_POTATOES, 2), Items.COOKED_BEEF, Items.BAKED_POTATO);
//        addShapelessRecipe(new ItemStack(BWMItems.BEEF_POTATOES, 2), Items.COOKED_BEEF, Items.BAKED_POTATO);
//        addShapelessRecipe(new ItemStack(BWMItems.PORK_DINNER, 3), Items.COOKED_PORKCHOP, Items.CARROT, Items.BAKED_POTATO);
//        addShapelessRecipe(new ItemStack(BWMItems.RAW_KEBAB, 3), Blocks.BROWN_MUSHROOM, Items.CARROT, Items.MUTTON, Items.STICK);
//        addShapelessRecipe(new ItemStack(BWMItems.HAM_AND_EGGS, 2), BWMItems.COOKED_EGG, Items.COOKED_PORKCHOP);
//        addShapelessRecipe(new ItemStack(Items.STRING), "fiberHemp", "fiberHemp", "fiberHemp");
//        addShapelessRecipe(new ItemStack(BWMBlocks.BOOSTER), Blocks.RAIL, BWMBlocks.ROPE, "gearWood");
//        addShapelessRecipe(new ItemStack(BWMBlocks.URN, 1, 9), new ItemStack(BWMBlocks.URN, 1, 8), new ItemStack(Items.ENDER_EYE), "obsidian");
//        addShapelessRecipe(new ItemStack(Items.FLINT, 9, 0), new ItemStack(BWMBlocks.AESTHETIC, 1, 5));
//        addShapelessRecipe(new ItemStack(BWMBlocks.ROPE, 9, 0), new ItemStack(BWMBlocks.AESTHETIC, 1, 4));
//        addShapelessRecipe(new ItemStack(BWMItems.DYNAMITE), "paper", "paper", "paper", ItemMaterial.getMaterial("fuse"), ItemMaterial.getMaterial("blasting_oil"), "dustWood");
//        addShapelessRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 8), "enderpearl", "enderpearl", "enderpearl", "enderpearl", "enderpearl", "enderpearl", "enderpearl", "enderpearl", "enderpearl");
//        addShapelessRecipe(new ItemStack(BWMItems.TASTY_SANDWICH, 2), Items.BREAD, "listAllmeatcooked");
//        addShapelessRecipe(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 1), Blocks.PUMPKIN, Items.SUGAR, BWMItems.RAW_EGG, "foodFlour");
//
//        addShapelessRecipe(ItemMaterial.getMaterial("padding"), new ItemStack(Items.FEATHER), ItemMaterial.getMaterial("hemp_cloth"));
//        addShapelessRecipe(ItemMaterial.getMaterial("hemp_fibers", 6), BWMBlocks.ROPE);
//        addShapelessRecipe(ItemMaterial.getMaterial("nugget_iron", 9), "ingotIron");
//        addShapelessRecipe(ItemMaterial.getMaterial("nugget_steel", 9), "ingotSoulforgedSteel");
//        addShapelessRecipe(ItemMaterial.getMaterial("concentrated_hellfire", 9), new ItemStack(BWMBlocks.AESTHETIC, 1, 3));
//        addShapelessRecipe(ItemMaterial.getMaterial("diamond_ingot"), "gemDiamond", "ingotIron", BWMItems.CREEPER_OYSTER);
    }

    public void shaped() {

        //TODO
//        addShapedRecipe(new ItemStack(BWMBlocks.LENS), "GDG", "G G", "GLG", 'G', "ingotGold", 'D', "gemDiamond", 'L', "blockGlass");
//        addShapedRecipe(new ItemStack(BWMItems.WINDMILL, 1, 2), "XXX", "X X", "XXX", 'X', ItemMaterial.getMaterial("windmill_blade"));
//        addShapedRecipe(new ItemStack(BWMItems.WINDMILL, 1, 1), "XXX", "X X", "XXX", 'X', ItemMaterial.getMaterial("wood_blade"));
//        addShapedRecipe(new ItemStack(BWMItems.WINDMILL, 1, 0), " X ", "X X", " X ", 'X', ItemMaterial.getMaterial("windmill_blade"));
//        addShapedRecipe(new ItemStack(BWMBlocks.ANCHOR), " I ", "SSS", 'S', "stone", 'I', "ingotIron");
//        addShapedRecipe(new ItemStack(BWMBlocks.HIBACHI), "HHH", "SES", "SRS", 'S', "stone", 'R', "dustRedtone", 'H', ItemMaterial.getMaterial("concentrated_hellfire"), 'E', ItemMaterial.getMaterial("element"));
//        addShapedRecipe(new ItemStack(BWMBlocks.BELLOWS), "WWW", "LLL", "BGB", 'W', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'L', ItemMaterial.getMaterial("tanned_leather_cut"), 'B', ItemMaterial.getMaterial("leather_belt"), 'G', "gearWood");
//        addShapedRecipe(new ItemStack(BWMBlocks.GEARBOX), "PGP", "GLG", "PGP", 'P', "plankWood", 'G', "gearWood", 'L', ItemMaterial.getMaterial("redstone_latch"));
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 5), "LLL", "SCS", "SWS", 'L', new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE), 'S', "stone", 'W', "gearWood", 'C', Items.CLOCK);
//        addShapedRecipe(new ItemStack(Blocks.TORCH, 4), "X", "S", 'S', "stickWood", 'X', ItemMaterial.getMaterial("nethercoal"));
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 4), "S S", "GPG", " C ", 'C', BWMBlocks.WOOD_CORNER, 'S', BWMBlocks.WOOD_SIDING, 'G', "gearWood", 'P', Blocks.WOODEN_PRESSURE_PLATE);
//        addShapedRecipe(new ItemStack(BWMBlocks.AXLE), "X", "R", "X", 'X', "plankWood", 'R', new ItemStack(BWMBlocks.ROPE));
//        addShapedRecipe(new ItemStack(BWMBlocks.HAND_CRANK), "  X", " X ", "SWS", 'X', "stickWood", 'S', "cobblestone", 'W', "gearWood");
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 0), "XWX", "XXX", "XXX", 'X', "stone", 'W', "gearWood");
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 3), "XBX", "XWX", "XXX", 'X', "ingotCopper", 'B', Items.BONE, 'W', Items.WATER_BUCKET);
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 3), "XBX", "XWX", "XXX", 'X', "ingotIron", 'B', Items.BONE, 'W', Items.WATER_BUCKET);
//        addShapedRecipe(new ItemStack(BWMBlocks.SLATS, 4, 0), "SS", "SS", 'S', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE));
//        addShapedRecipe(new ItemStack(BWMBlocks.GRATE, 4, 0), "WSW", "WSW", 'S', "stickWood", 'W', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE));
//        addShapedRecipe(new ItemStack(BWMBlocks.PANE, 4, 2), "RRR", "RRR", 'R', Items.REEDS);
//        addShapedRecipe(new ItemStack(BWMBlocks.ROPE), "XX", "XX", "XX", 'X', "fiberHemp");
//        addShapedRecipe(new ItemStack(BWMItems.KNIFE), "I ", " X", 'X', "stickWood", 'I', ItemMaterial.getMaterial("knife_blade"));
//        addShapedRecipe(new ItemStack(BWMBlocks.SINGLE_MACHINES, 1, 1), "PIP", "GLG", "PIP", 'P', "plankWood", 'I', "ingotIron", 'G', "gearWood", 'L', ItemMaterial.getMaterial("redstone_latch"));
//        addShapedRecipe(new ItemStack(BWMBlocks.PLATFORM), "MWM", " M ", "MWM", 'M', "plankWood", 'W', new ItemStack(BWMBlocks.PANE, 1, 2));
//        addShapedRecipe(new ItemStack(BWMBlocks.MINING_CHARGE), "RSR", "DDD", "DDD", 'R', BWMBlocks.ROPE, 'S', "slimeball", 'D', BWMItems.DYNAMITE);
//        addShapedRecipe(new ItemStack(BWMBlocks.PUMP), "xGx", "SsS", "SgS", 'x', ItemMaterial.getMaterial("glue"), 'G', new ItemStack(BWMBlocks.GRATE, 1, 32767), 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 's', ItemMaterial.getMaterial("screw"), 'g', "gearWood");
//        addShapedRecipe(new ItemStack(BWMItems.ENDER_SPECTACLES), "OSO", 'O', ItemMaterial.getMaterial("ender_ocular"), 'S', ItemMaterial.getMaterial("leather_strap"));
//        addShapedRecipe(new ItemStack(BWMItems.BREEDING_HARNESS), "SLS", "LLL", "SLS", 'S', ItemMaterial.getMaterial("leather_strap"), 'L', ItemMaterial.getMaterial("tanned_leather"));
//        addShapedRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 5), "XXX", "XXX", "XXX", 'X', new ItemStack(Items.FLINT));
//        addShapedRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 4), "XXX", "XXX", "XXX", 'X', new ItemStack(BWMBlocks.ROPE));
//        addShapedRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 3), "XXX", "XXX", "XXX", 'X', ItemMaterial.getMaterial("concentrated_hellfire"));
//        addShapedRecipe(new ItemStack(BWMBlocks.SAW), "III", "GBG", "WGW", 'I', "ingotIron", 'G', "gearWood", 'W', "plankWood", 'B', ItemMaterial.getMaterial("leather_belt"));
//        addShapedRecipe(new ItemStack(BWMBlocks.LIGHT), " P ", "PFP", " R ", 'P', "paneGlass", 'R', "dustRedstone", 'F', ItemMaterial.getMaterial("filament"));
//        addShapedRecipe(new ItemStack(Items.IRON_INGOT), "III", "III", "III", 'I', "nuggetIron");
//        addShapedRecipe(new ItemStack(BWMItems.COMPOSITE_BOW), "GMB", "MBS", "GMB", 'G', "slimeball", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, OreDictionary.WILDCARD_VALUE), 'B', "bone", 'S', "string");
//        addShapedRecipe(new ItemStack(BWMItems.BROADHEAD_ARROW), "B", "S", "F", 'B', ItemMaterial.getMaterial("broadhead"), 'S', "stickWood", 'F', "feather");
//        addShapedRecipe(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 0), "SSS", "MEM", "FFF", 'S', Items.SUGAR, 'M', Items.MILK_BUCKET, 'E', BWMItems.RAW_EGG, 'F', "foodFlour");
//        addShapedRecipe(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 2), "FCF", 'F', "foodFlour", 'C', BWMItems.CHOCOLATE);
//        addShapedRecipe(new ItemStack(Items.CHAINMAIL_HELMET), "CCC", "C C", 'C', ItemMaterial.getMaterial("chain_mail"));
//        addShapedRecipe(new ItemStack(Items.CHAINMAIL_CHESTPLATE), "C C", "CCC", "CCC", 'C', ItemMaterial.getMaterial("chain_mail"));
//        addShapedRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), "CCC", "C C", "C C", 'C', ItemMaterial.getMaterial("chain_mail"));
//        addShapedRecipe(new ItemStack(BWMBlocks.VINE_TRAP, 1), "VVV", 'V', new ItemStack(Blocks.VINE));
//        addShapedRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), "C C", "C C", 'C', ItemMaterial.getMaterial("chain_mail"));
//        addShapedRecipe(new ItemStack(BWMBlocks.STEEL_ANVIL), "SSS", " S ", "SSS", 'S', ItemMaterial.getMaterial("ingot_steel"));
//
//        addShapedRecipe(ItemMaterial.getMaterial("wood_blade"), "W  ", "WGW", "W  ", 'G', "slimeball", 'W', BWMBlocks.WOOD_SIDING);
//        addShapedRecipe(ItemMaterial.getMaterial("hemp_cloth"), "XXX", "XXX", "XXX", 'X', "fiberHemp");
//        addShapedRecipe(ItemMaterial.getMaterial("windmill_blade"), "CCC", "CCC", "WWW", 'W', "slabWood", 'C', "fabricHemp");
//        addShapedRecipe(ItemMaterial.getMaterial("leather_belt"), " L ", "L L", " L ", 'L', ItemMaterial.getMaterial("leather_strap"));
//        addShapedRecipe(ItemMaterial.getMaterial("haft"), "S", "G", "X", 'S', ItemMaterial.getMaterial("leather_strap"), 'G', "slimeball", 'X', BWMBlocks.WOOD_MOULDING);
//        addShapedRecipe(ItemMaterial.getMaterial("gear", 2), "SWS", "W W", "SWS", 'S', "stickWood", 'W', "plankWood");
//        addShapedRecipe(ItemMaterial.getMaterial("redstone_latch"), "GGG", " R ", 'G', "nuggetGold", 'R', "dustRedstone");
//        addShapedRecipe(ItemMaterial.getMaterial("sharpening_stone"), "X ", " X", 'X', Items.FLINT);
//        addShapedRecipe(ItemMaterial.getMaterial("knife_blade"), "I ", " X", 'X', ItemMaterial.getMaterial("sharpening_stone"), 'I', "ingotIron");
//        addShapedRecipe(ItemMaterial.getMaterial("screw"), "II ", " II", "II ", 'I', "ingotIron");
//        addShapedRecipe(ItemMaterial.getMaterial("ender_ocular"), "GGG", "GEG", "GGG", 'G', "nuggetGold", 'E', "enderpearl");
//        addShapedRecipe(ItemMaterial.getMaterial("ingot_steel"), "III", "III", "III", 'I', "nuggetSoulforgedSteel");

    }

    public void addShapedRecipe(ItemStack output, Object... input) {
        GameRegistry.addRecipe(new ShapedOreRecipe(output, input));
    }

    public void addShapelessRecipe(ItemStack output, Object... input) {
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, input));
    }
}
