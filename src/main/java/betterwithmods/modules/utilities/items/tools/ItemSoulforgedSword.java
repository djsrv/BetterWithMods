package betterwithmods.modules.utilities.items.tools;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.item.ItemSword;

public class ItemSoulforgedSword extends ItemSword {
    public ItemSoulforgedSword() {
        super(Tools.SOULFORGED_STEEL);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
