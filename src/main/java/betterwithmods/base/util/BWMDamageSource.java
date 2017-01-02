package betterwithmods.base.util;

import net.minecraft.util.DamageSource;

public class BWMDamageSource extends DamageSource {
    public static final BWMDamageSource saw = new BWMDamageSource("saw", false);
    public static final BWMDamageSource choppingBlock = new BWMDamageSource("choppingBlock", false);

    protected BWMDamageSource(String name, boolean ignoreArmor) {
        super(name);
        if (ignoreArmor)
            setDamageBypassesArmor();
    }
}
