package betterwithmods.modules.core.features;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import betterwithmods.modules.core.blocks.BlockRope;
import betterwithmods.modules.aesthetic.features.Panes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/13/16
 */
public class HopperFilters extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        //TODO can probably config this more
        HopperFilters.addFilter(1, Blocks.LADDER, 0, HopperFilters::isNotBlock);
        HopperFilters.addFilter(2, Blocks.TRAPDOOR, 0, stack -> isNarrow(stack) || isParticulate(stack));
        HopperFilters.addFilter(3, Panes.GRATE, OreDictionary.WILDCARD_VALUE, stack -> isNarrow(stack) || isFlat(stack) || isParticulate(stack));
        HopperFilters.addFilter(4, Panes.SLATS, OreDictionary.WILDCARD_VALUE, stack -> isParticulate(stack) || isFlat(stack));
        HopperFilters.addFilter(5, Panes.WICKER, OreDictionary.WILDCARD_VALUE, HopperFilters::isParticulate);
        HopperFilters.addFilter(6, Blocks.SOUL_SAND, 0, stack -> false);
        HopperFilters.addFilter(7, Blocks.IRON_BARS, 0, stack -> isNotBlock(stack) && stack.getMaxStackSize() > 1);
    }

    public static final HashMap<Integer, Predicate<ItemStack>> filters = new HashMap<>();
    public static final HashMap<ItemStack, Integer> filterTypes = new HashMap<>();

    public static boolean containsStack(Set<ItemStack> set, ItemStack stack) {
        Optional<ItemStack> found = set.stream().filter(s -> s.isItemEqual(stack)).findFirst();
        return found.isPresent();
    }

    public static void addFilter(ItemStack stack, Set<ItemStack> allowedItems) {
        addFilter(filters.size() + 1, stack, s -> containsStack(allowedItems, s));
    }

    public static void addFilter(int type, Block block, int meta, Predicate<ItemStack> allowed) {
        addFilter(type, new ItemStack(block, 1, meta), allowed);
    }

    public static void addFilter(int type, ItemStack filter, Predicate<ItemStack> allowed) {
        if (filterTypes.containsKey(filter)) {
            throw new IllegalArgumentException("Filter " + filter.getDisplayName() + "For Type " + type + " Already exists");
        }
        if (filters.containsKey(type)) {
            throw new IllegalArgumentException("Filter " + type + " Already exists");
        }
        BWMod.logger.info("Adding Filter " + filter.getDisplayName() + "," + type);
        filterTypes.put(filter, type);
        filters.put(type, allowed);
    }

    public static List<ItemStack> getFilter(int type) {
        return filterTypes.entrySet().stream().filter(entry -> entry.getValue() == type).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static Predicate<ItemStack> getAllowedItems(int type) {
        return filters.get(type);
    }

    public static int getFilterType(ItemStack filter) {
        Optional<Integer> type = filterTypes.entrySet().stream().
                filter(e -> e.getKey().getItem() == filter.getItem() && (e.getKey().getMetadata() == filter.getMetadata() || e.getKey().getMetadata() == OreDictionary.WILDCARD_VALUE))
                .map(Map.Entry::getValue).findAny();
        if (type.isPresent())
            return type.get();
        return 0;
    }

    private static boolean isNotBlock(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof ItemBlock) {
            Block block = ((ItemBlock) item).getBlock();
            return block instanceof BlockRope || block instanceof BlockBush || block instanceof BlockTorch || block instanceof BlockSand || block instanceof BlockGravel || InvUtils.isOre(stack, "treeSapling");
        }
        return true;
    }

    private static boolean isParticulate(ItemStack stack) {
        Item item = stack.getItem();
        return InvUtils.listContains(stack, OreDictionary.getOres("sand")) || item instanceof ItemSeeds || InvUtils.listContains(stack, OreDictionary.getOres("listAllseeds")) || item == Items.GUNPOWDER || item == Items.SUGAR || item == Items.BLAZE_POWDER || InvUtils.listContains(stack, OreDictionary.getOres("foodFlour")) || InvUtils.listContains(stack, InvUtils.dustNames);
    }

    private static boolean isFlat(ItemStack stack) {
        Item item = stack.getItem();
        int meta = stack.getMetadata();

        //TODO what are these????
//        if (item == BWMItems.MATERIAL) {
//            return meta == 1 || meta == 4 || (meta > 5 && meta < 10) || (meta > 31 && meta < 35);
//        }
        return item == Item.getItemFromBlock(Blocks.WOOL) || item == Item.getItemFromBlock(Blocks.CARPET) || item == Items.LEATHER || item == Items.MAP || item == Items.FILLED_MAP || InvUtils.listContains(stack, OreDictionary.getOres("string")) || InvUtils.listContains(stack, OreDictionary.getOres("paper"));
    }

    private static boolean isNarrow(ItemStack stack) {
        Item item = stack.getItem();
        int meta = stack.getMetadata();
        //TODO
        return false;
        //return item == Item.getItemFromBlock(Blocks.RED_FLOWER) || item == Item.getItemFromBlock(Blocks.YELLOW_FLOWER) || item == Items.BONE || item == Items.ARROW || item == Items.SPECTRAL_ARROW || item == Items.TIPPED_ARROW || InvUtils.listContains(stack, OreDictionary.getOres("stickWood")) || InvUtils.listContains(stack, InvUtils.cropNames) || item == Items.REEDS || item == Items.BLAZE_ROD || (item == BWMItems.MATERIAL && (meta == 8 || meta == 9));
    }
}
