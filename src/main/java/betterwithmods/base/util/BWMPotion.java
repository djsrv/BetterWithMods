package betterwithmods.base.util;

import net.minecraft.potion.Potion;

public class BWMPotion extends Potion {

    public BWMPotion(boolean isBadEffectIn, int liquidColorIn, int x, int y) {
        this(isBadEffectIn, liquidColorIn);
        setIconIndex(x, y);
    }

    public BWMPotion(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
    }
}
