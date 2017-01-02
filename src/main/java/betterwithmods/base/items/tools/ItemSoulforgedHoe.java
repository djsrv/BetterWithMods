package betterwithmods.base.items.tools;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemSoulforgedHoe extends ItemHoe {
    public ItemSoulforgedHoe() {
        super(BWMItems.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
