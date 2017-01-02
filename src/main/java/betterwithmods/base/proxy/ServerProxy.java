package betterwithmods.base.proxy;

import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.base.registry.BWMRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("unused")
public class ServerProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        BWMRegistry.preInit();
        ModuleLoader.preInit(e);


    }

    @Override
    public void init(FMLInitializationEvent e) {
        ModuleLoader.init(e);
        BWMRegistry.init();

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        BWMRegistry.postInit();
        ModuleLoader.postInit(e);

    }

    @Override
    public void serverStarting(FMLServerStartingEvent e) {
        ModuleLoader.serverStarting(e);
    }

}
