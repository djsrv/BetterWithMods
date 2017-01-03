package betterwithmods.modules.utilities.items.tools;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.item.ItemAxe;

public class ItemSoulforgedBattleAxe extends ItemAxe {
    public ItemSoulforgedBattleAxe() {
        super(Tools.SOULFORGED_STEEL, 9F, -2.4f);
        setCreativeTab(BWCreativeTabs.BWTAB);
    }
}
