package betterwithmods.base.items.tools;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.client.BWCreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemSoulforgedBattleAxe extends ItemAxe {
    public ItemSoulforgedBattleAxe() {
        super(BWMItems.SOULFORGED_STEEL, 9F, -2.4f);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
