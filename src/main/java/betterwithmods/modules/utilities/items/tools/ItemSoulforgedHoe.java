package betterwithmods.modules.utilities.items.tools;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.item.ItemHoe;

public class ItemSoulforgedHoe extends ItemHoe {
    public ItemSoulforgedHoe() {
        super(Tools.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
