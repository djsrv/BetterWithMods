package betterwithmods.base.util;

import betterwithmods.base.BWMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BWMSounds {
    public static SoundEvent WOODCREAK;
    public static SoundEvent STONEGRIND;
    public static SoundEvent BELLOW;
    public static SoundEvent WOODCHIME;
    public static SoundEvent METALCHIME;

    public static void registerSounds() {
        WOODCREAK = registerSound("blocks.wood.creak");
        STONEGRIND = registerSound("blocks.stone.grind");
        BELLOW = registerSound("blocks.wood.bellow");
        WOODCHIME = registerSound("blocks.wood.chime");
        METALCHIME = registerSound("blocks.metal.chime");
    }

    public static SoundEvent registerSound(String soundName) {
        ResourceLocation soundID = new ResourceLocation(BWMod.MODID, soundName);
        return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
    }
}
