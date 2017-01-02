package betterwithmods.base.items.tools;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemSoulforgedShovel extends ItemSpade {
    public ItemSoulforgedShovel() {
        super(BWMItems.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
