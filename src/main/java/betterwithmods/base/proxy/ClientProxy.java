package betterwithmods.base.proxy;

import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.base.util.RenderUtils;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("unused")
public class ClientProxy extends ServerProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModuleLoader.preInitClient(e);
        RenderUtils.registerFilters();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ModuleLoader.initClient(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        ModuleLoader.postInitClient(e);
    }

}
