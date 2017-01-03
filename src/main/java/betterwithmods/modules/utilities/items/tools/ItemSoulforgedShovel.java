package betterwithmods.modules.utilities.items.tools;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.item.ItemSpade;

public class ItemSoulforgedShovel extends ItemSpade {
    public ItemSoulforgedShovel() {
        super(Tools.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
