package betterwithmods.base;

import betterwithmods.base.proxy.IProxy;
import betterwithmods.base.registry.BWMBlocks;
import net.minecraft.item.Item;
import net.minecraft.world.MinecraftException;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(modid = BWMod.MODID, name = BWMod.NAME, version = BWMod.VERSION, dependencies = "required-after:Forge@[12.18.1.2076,);before:survivalist;after:tconstruct;after:minechem;after:natura;after:terrafirmacraft;after:immersiveengineering", guiFactory = "BWGuiFactory")
public class BWMod {
    public static final String MODID = "betterwithmods";
    public static final String VERSION = "0.13.1 Beta hotfix 3";
    public static final String NAME = "Better With Mods";




    public static Logger logger;
    @SuppressWarnings({"CanBeFinal", "unused"})
    @SidedProxy(serverSide = "betterwithmods.base.proxy.ServerProxy", clientSide = "betterwithmods.base.proxy.ClientProxy")
    public static IProxy proxy;
    @SuppressWarnings({"CanBeFinal", "unused"})
    @Mod.Instance(BWMod.MODID)
    public static BWMod instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }


    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
        proxy.serverStarting(e);
    }

    @Mod.EventHandler
    public void remap(FMLMissingMappingsEvent evt) throws MinecraftException {
        for (FMLMissingMappingsEvent.MissingMapping mapping : evt.get()) {
            switch (mapping.type) {
                case ITEM:
                    if (Objects.equals(mapping.name, "betterwithmods:creativeGenerator")) {
                        Item creativeGeneratorItem = Item.getItemFromBlock(BWMBlocks.CREATIVE_GENERATOR);
                        if (creativeGeneratorItem == null)
                            throw new MinecraftException("Creative Generator don't have an item. Can't remap.");
                        mapping.remap(creativeGeneratorItem);
                    }
                    break;
                case BLOCK:
                    if (Objects.equals(mapping.name, "betterwithmods:creativeGenerator")) {
                        mapping.remap(BWMBlocks.CREATIVE_GENERATOR);
                    }
                    break;
            }
        }
    }


}
