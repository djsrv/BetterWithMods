package betterwithmods.base.items.tools;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSoulforgedSword extends ItemSword {
    public ItemSoulforgedSword() {
        super(BWMItems.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
