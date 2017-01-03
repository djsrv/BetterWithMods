package betterwithmods.modules.utilities.items.tools;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.item.ItemAxe;

public class ItemSoulforgedAxe extends ItemAxe {
    public ItemSoulforgedAxe() {
        super(Tools.SOULFORGED_STEEL, 8.0F, -3.0F);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
