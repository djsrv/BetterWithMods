package betterwithmods.base.items.tools;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemSoulforgedAxe extends ItemAxe {
    public ItemSoulforgedAxe() {
        super(BWMItems.SOULFORGED_STEEL, 8.0F, -3.0F);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
