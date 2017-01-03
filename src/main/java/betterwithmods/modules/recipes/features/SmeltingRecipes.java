package betterwithmods.modules.recipes.features;

import betterwithmods.base.modules.Feature;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class SmeltingRecipes extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        //TODO
//        GameRegistry.addSmelting(ItemMaterial.getMaterial("flour"), new ItemStack(Items.BREAD), 0.1F);
//        GameRegistry.addSmelting(ItemMaterial.getMaterial("nether_sludge"), new ItemStack(Items.NETHERBRICK), 0.2F);
//        GameRegistry.addSmelting(BWMBlocks.DEBARKED_OLD, new ItemStack(Items.COAL, 1, 1), 0.1F);
//        GameRegistry.addSmelting(BWMBlocks.DEBARKED_NEW, new ItemStack(Items.COAL, 1, 1), 0.1F);
//        GameRegistry.addSmelting(new ItemStack(BWMBlocks.AESTHETIC, 1, 7), new ItemStack(BWMBlocks.AESTHETIC, 1, 6), 0.1F);
//        GameRegistry.addSmelting(BWMItems.RAW_EGG, new ItemStack(BWMItems.COOKED_EGG), 0.1F);
//        GameRegistry.addSmelting(BWMItems.RAW_SCRAMBLED_EGG, new ItemStack(BWMItems.COOKED_SCRAMBLED_EGG), 0.1F);
//        GameRegistry.addSmelting(BWMItems.RAW_OMELET, new ItemStack(BWMItems.COOKED_OMELET), 0.1F);
//        GameRegistry.addSmelting(BWMItems.RAW_KEBAB, new ItemStack(BWMItems.COOKED_KEBAB), 0.1F);
//        GameRegistry.addSmelting(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 0), new ItemStack(Items.CAKE), 0.1F);
//        if (ModuleLoader.isFeatureEnabled(HCHunger.class)) {
//            GameRegistry.addSmelting(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 2), new ItemStack(Items.COOKIE, 8), 0.1F);
//            GameRegistry.addSmelting(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 1), new ItemStack(Items.PUMPKIN_PIE, 1), 0.1F);
//        } else {
//            GameRegistry.addSmelting(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 2), new ItemStack(Items.COOKIE, 16), 0.1F);
//            GameRegistry.addSmelting(new ItemStack(BWMBlocks.RAW_PASTRY, 1, 1), new ItemStack(Items.PUMPKIN_PIE, 2), 0.1F);
//        }
        GameRegistry.registerFuelHandler(new BWFuelHandler());
    }


    public class BWFuelHandler implements IFuelHandler {
        @Override
        public int getBurnTime(ItemStack fuel) {
            //TODO
//            Item item = fuel.getItem();
//            int meta = fuel.getItemDamage();
//            if (item == BWMItems.MATERIAL && meta == 1)
//                return 3200;
//            else if (item == BWMItems.MATERIAL && meta == 22)
//                return 25;
//            else if (item == BWMItems.MATERIAL && meta == 23)
//                return 25;
//            else if (item == BWMItems.BARK)
//                return 25;
//            else if (item == Item.getItemFromBlock(BWMBlocks.WOOD_SIDING))
//                return 150;
//            else if (item == Item.getItemFromBlock(BWMBlocks.WOOD_MOULDING))
//                return 75;
//            else if (item == Item.getItemFromBlock(BWMBlocks.WOOD_CORNER))
//                return 38;
            return 0;
        }

    }
}
