/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [18/03/2016, 22:46:32 (GMT)]
 */
package betterwithmods.base.modules;

import betterwithmods.base.BWMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Objects;

public class Feature {

    public Module module;

    public boolean loadtimeDone;
    public boolean enabledAtLoadtime;

    public boolean enabledByDefault;
    public boolean enabled;
    public boolean prevEnabled;
    public String configCategory;
    public String configName;

    public boolean forceLoad;

    public final void setupConstantConfig() {
        String[] incompat = getIncompatibleMods();
        if(incompat != null && incompat.length > 0) {
            String desc = "This feature disables itself if any of the following mods are loaded: \n";
            for(String s : incompat)
                desc += (" - " + s + "\n");
            desc += "This is done to prevent content overlap.\nYou can turn this on to force the feature to be loaded even if the above mods are also loaded.";

            ConfigHelper.needsRestart = true;
            forceLoad = loadPropBool("Force Enabled", desc, false);
        }
    }

    public void setupConfig() {
        // NO-OP
    }

    public void preInit(FMLPreInitializationEvent event) {
        // NO-OP
    }

    public void init(FMLInitializationEvent event) {
        // NO-OP
    }

    public void postInit(FMLPostInitializationEvent event) {
        // NO-OP
    }

    @SideOnly(Side.CLIENT)
    public void preInitClient(FMLPreInitializationEvent event) {
        // NO-OP
    }

    @SideOnly(Side.CLIENT)
    public void initClient(FMLInitializationEvent event) {
        // NO-OP
    }

    @SideOnly(Side.CLIENT)
    public void postInitClient(FMLPostInitializationEvent event) {
        // NO-OP
    }

    public void serverStarting(FMLServerStartingEvent event) {
        // NO-OP
    }

    public String[] getIncompatibleMods() {
        return null;
    }

    public boolean hasSubscriptions() {
        return false;
    }

    public boolean hasTerrainSubscriptions() {
        return false;
    }

    public boolean hasOreGenSubscriptions() {
        return false;
    }

    public String getFeatureDescription() {
        return "";
    }

    public boolean requiresMinecraftRestartToEnable() {
        return false;
    }

    public static void registerTile(Class<? extends TileEntity> clazz, String key) {
        GameRegistry.registerTileEntity(clazz, BWMod.MODID + key);
    }

    /**
     * Register an Item.
     *
     * @param item Item instance to register.
     * @return Registered item.
     */
    public static Item registerItem(Item item) {
        if (Objects.equals(item.getUnlocalizedName(), "item.null")) {
            //betterwithmods:name => bwm:name
            item.setUnlocalizedName("bwm" + item.getRegistryName().toString().substring(BWMod.MODID.length()));
        }
        return GameRegistry.register(item);
    }

    /**
     * Register a blocks with its specified linked item. Block's registry name
     * prevail and must be set before call.
     *
     * @param block Block instance to register.
     * @param item  Item instance to register. Will have the same registered name
     *              as the blocks. If null, then no item will be linked to the
     *              blocks.
     */
    public static Block registerBlock(Block block, @Nullable Item item) {
        if (Objects.equals(block.getUnlocalizedName(), "tile.null")) {
            //betterwithmods:name => bwm:name
            block.setUnlocalizedName("bwm" + block.getRegistryName().toString().substring(BWMod.MODID.length()));
        }
        Block registeredBlock = GameRegistry.register(block);
        if (item != null)
            GameRegistry.register(item.setRegistryName(block.getRegistryName()));
        return registeredBlock;
    }

    /**
     * Register a Block and a new ItemBlock generated from it.
     *
     * @param block Block instance to register.
     * @return Registered blocks.
     */
    public static Block registerBlock(Block block) {
        return registerBlock(block, new ItemBlock(block));
    }

    public final boolean isClient() {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    public final int loadPropInt(String propName, String desc, int default_, int min, int max) {
        return ConfigHelper.loadPropInt(propName, configCategory, desc, MathHelper.clamp(default_,min,max));
    }

    public final int loadPropInt(String propName, String desc, int default_) {
        return loadPropInt(propName, desc, default_,0,Integer.MAX_VALUE);
    }

    public final double loadPropDouble(String propName, String desc, double default_, double min, double max) {
        return ConfigHelper.loadPropDouble(propName, configCategory, desc, MathHelper.clamp(default_,min,max));
    }

    public final double loadPropDouble(String propName, String desc, int default_) {
        return loadPropDouble(propName, desc, default_,0,Double.MAX_VALUE);
    }

    public final boolean loadPropBool(String propName, String desc, boolean default_) {
        return ConfigHelper.loadPropBool(propName, configCategory, desc, default_);
    }

    public final String loadPropString(String propName, String desc, String default_) {
        return ConfigHelper.loadPropString(propName, configCategory, desc, default_);
    }

    public final String[] loadPropStringList(String propName, String desc, String[] default_) {
        return ConfigHelper.loadPropStringList(propName, configCategory, desc, default_);
    }
}