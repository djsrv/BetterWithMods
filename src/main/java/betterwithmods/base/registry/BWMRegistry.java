package betterwithmods.base.registry;

import betterwithmods.api.capabilities.MechanicalCapability;
import betterwithmods.api.crafting.ChoppingRecipe;
import betterwithmods.api.crafting.blockmeta.SawInteraction;
import betterwithmods.api.crafting.heat.BWMHeatRegistry;
import betterwithmods.api.tile.IMechanicalPower;
import betterwithmods.base.BWMod;
import betterwithmods.base.client.container.BWGuiHandler;
import betterwithmods.base.entity.EntityBroadheadArrow;
import betterwithmods.base.entity.EntityDynamite;
import betterwithmods.base.entity.EntityExtendingRope;
import betterwithmods.base.entity.EntityFallingGourd;
import betterwithmods.base.entity.EntityMiningCharge;
import betterwithmods.base.entity.EntityShearedCreeper;
import betterwithmods.base.entity.item.EntityItemBuoy;
import betterwithmods.base.items.ItemMaterial;
import betterwithmods.base.modules.config.BWConfig;
import betterwithmods.base.network.BWNetwork;
import betterwithmods.base.util.BWMPotion;
import betterwithmods.base.util.BWMSounds;
import betterwithmods.base.util.ColorUtils;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.RecipeUtils;
import betterwithmods.integration.ICompatModule;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BWMRegistry {
    public static final Potion POTION_TRUESIGHT = new BWMPotion(false, 14270531, 4, 1).setRegistryName("true_sight");
    private static int availableEntityId = 0;
    public static void preInit() {
        registerEntities();
        BWMBlocks.registerBlocks();
        BWMItems.registerItems();
        BWMBlocks.registerTileEntities();
        BWMSounds.registerSounds();
        NetworkRegistry.INSTANCE.registerGuiHandler(BWMod.instance, new BWGuiHandler());
        CapabilityManager.INSTANCE.register(IMechanicalPower.class, new MechanicalCapability.CapabilityMechanicalPower(), MechanicalCapability.DefaultMechanicalPower.class);
        loadCompatibilityModules();
        getLoadedModules().forEach(ICompatModule::preInit);
    }
    public static void init() {
        registerOres();
        registerPotions();
        registerHeatSources();
        BWNetwork.INSTANCE.init();
        getLoadedModules().forEach(ICompatModule::init);
    }

    public static void postInit() {
        registerWood();
        ColorUtils.initColors();
        RecipeUtils.refreshRecipes();
        InvUtils.postInitOreDictGathering();
        getLoadedModules().forEach(ICompatModule::postInit);
    }


    private static final Map<String, String> compatClasses;
    /**
     * Mod ID => Compatibility module class path.
     */
    static {
        //Avoid all direct references to class so
        //they are actually loaded only if necessary.
        Map<String, String> map = new HashMap<>();
        map.put("biomesoplenty", "betterwithmods.integration.BiomesOPlenty");
        map.put("harvestcraft", "betterwithmods.integration.Harvestcraft");
        map.put("immersiveengineering", "betterwithmods.integration.immersiveengineering.ImmersiveEngineering");
        map.put("MineTweaker3", "betterwithmods.integration.minetweaker.MineTweaker");
        map.put("Quark", "betterwithmods.integration.Quark");
        map.put("tconstruct", "betterwithmods.integration.tcon.TConstruct");
        map.put("nethercore", "betterwithmods.integration.NetherCore");
        compatClasses = Collections.unmodifiableMap(map);
    }
    private static final Set<ICompatModule> loadedModules = new HashSet<>();
    public static Set<ICompatModule> getLoadedModules() {
        return loadedModules;
    }

    public static void loadCompatibilityModules() {
        for (Map.Entry<String, String> entry : compatClasses.entrySet()) {
            String modId = entry.getKey();
            String classPath = entry.getValue();
            if (isLoaded(modId)) try {
                loadedModules.add(Class.forName(classPath).asSubclass(ICompatModule.class).newInstance());
                BWMod.logger.info("Successfully load compat for " + modId);
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                BWMod.logger.error("Compatibility class " + classPath + " could not be loaded. Report this!");
                e.printStackTrace();
            }
        }
    }

    private static boolean isLoaded(String modId) {
        boolean loaded = Loader.isModLoaded(modId)
                && BWConfig.config.get(BWConfig.MOD_COMPAT, modId.toLowerCase() + "_compat", true).getBoolean();
        BWMod.logger.debug("Compat for " + modId + " is " + (loaded ? "loaded" : "not loaded"));
        BWConfig.config.save();
        return loaded;
    }


    /**
     * Registers an entity for this mod. Handles automatic available ID
     * assignment.
     */
    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
                                      int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(entityClass, entityName, availableEntityId, BWMod.instance, trackingRange,
                updateFrequency, sendsVelocityUpdates);
        availableEntityId++;
    }

    private static void registerEntities() {
        BWMRegistry.registerEntity(EntityExtendingRope.class, "ExtendingRope", 64, 20, true);
        BWMRegistry.registerEntity(EntityDynamite.class, "BWMDynamite", 10, 50, true);
        BWMRegistry.registerEntity(EntityMiningCharge.class, "BWMMiningCharge", 10, 50, true);
        BWMRegistry.registerEntity(EntityItemBuoy.class, "entityItemBuoy", 64, 20, true);
        BWMRegistry.registerEntity(EntityShearedCreeper.class, "entityShearedCreeper", 64, 1, true);
        BWMRegistry.registerEntity(EntityBroadheadArrow.class, "entityBroadheadArrow", 64, 1, true);
        BWMRegistry.registerEntity(EntityFallingGourd.class, "entityFallingGourd", 64, 1, true);
    }

    public static void registerOres() {
        OreDictionary.registerOre("gearWood", new ItemStack(BWMItems.MATERIAL, 1, 0));
        OreDictionary.registerOre("cropHemp", new ItemStack(BWMItems.MATERIAL, 1, 2));
        OreDictionary.registerOre("dyeBrown", new ItemStack(BWMItems.MATERIAL, 1, 5));
        OreDictionary.registerOre("slimeball", new ItemStack(BWMItems.MATERIAL, 1, 12));
        OreDictionary.registerOre("ingotSoulforgedSteel", new ItemStack(BWMItems.MATERIAL, 1, 14));
        OreDictionary.registerOre("dustNetherrack", new ItemStack(BWMItems.MATERIAL, 1, 15));
        OreDictionary.registerOre("dustHellfire", new ItemStack(BWMItems.MATERIAL, 1, 16));
        OreDictionary.registerOre("dustSoul", new ItemStack(BWMItems.MATERIAL, 1, 23));
        OreDictionary.registerOre("ingotHellfire", new ItemStack(BWMItems.MATERIAL, 1, 17));
        OreDictionary.registerOre("dustCoal", new ItemStack(BWMItems.MATERIAL, 1, 18));
        OreDictionary.registerOre("dustPotash", new ItemStack(BWMItems.MATERIAL, 1, 21));
        OreDictionary.registerOre("dustWood", new ItemStack(BWMItems.MATERIAL, 1, 22));
        OreDictionary.registerOre("dustSulfur", new ItemStack(BWMItems.MATERIAL, 1, 25));
        OreDictionary.registerOre("dustSaltpeter", new ItemStack(BWMItems.MATERIAL, 1, 26));
        OreDictionary.registerOre("nuggetIron", new ItemStack(BWMItems.MATERIAL, 1, 30));
        OreDictionary.registerOre("nuggetSoulforgedSteel", new ItemStack(BWMItems.MATERIAL, 1, 31));
        OreDictionary.registerOre("foodFlour", new ItemStack(BWMItems.MATERIAL, 1, 37));
        OreDictionary.registerOre("dustCharcoal", new ItemStack(BWMItems.MATERIAL, 1, 39));

        OreDictionary.registerOre("blockSoulforgedSteel", new ItemStack(BWMBlocks.AESTHETIC, 1, 2));
        OreDictionary.registerOre("blockHellfire", new ItemStack(BWMBlocks.AESTHETIC, 1, 3));
        //Added bark subtype entries for Roots compatibility
        OreDictionary.registerOre("barkWood", new ItemStack(BWMItems.BARK, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("barkOak", new ItemStack(BWMItems.BARK, 1, 0));
        OreDictionary.registerOre("barkSpruce", new ItemStack(BWMItems.BARK, 1, 1));
        OreDictionary.registerOre("barkBirch", new ItemStack(BWMItems.BARK, 1, 2));
        OreDictionary.registerOre("barkJungle", new ItemStack(BWMItems.BARK, 1, 3));
        OreDictionary.registerOre("barkAcacia", new ItemStack(BWMItems.BARK, 1, 4));
        OreDictionary.registerOre("barkDarkOak", new ItemStack(BWMItems.BARK, 1, 5));
        OreDictionary.registerOre("craftingToolKnife", new ItemStack(BWMItems.KNIFE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("slabWood", new ItemStack(BWMBlocks.WOOD_SIDING, 1, OreDictionary.WILDCARD_VALUE));
        // TFC compatibility
        OreDictionary.registerOre("itemKnife", new ItemStack(BWMItems.KNIFE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fiberHemp", new ItemStack(BWMItems.MATERIAL, 1, 3));
        OreDictionary.registerOre("fabricHemp", new ItemStack(BWMItems.MATERIAL, 1, 4));

        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_PORKCHOP);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_BEEF);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_CHICKEN);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_FISH);
        OreDictionary.registerOre("listAllmeatcooked", new ItemStack(Items.COOKED_FISH, 1, ItemFishFood.FishType.SALMON.getMetadata()));
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_MUTTON);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_RABBIT);
    }

    public static void registerHeatSources() {
        BWMHeatRegistry.setBlockHeatRegistry(Blocks.FIRE, 3);
        BWMHeatRegistry.setBlockHeatRegistry(BWMBlocks.STOKED_FLAME, 8);
    }
    //TODO I hate this
    public static void registerWood() {
        //TODO I hate this
        //TODO I hate this
        //TODO I hate this
        boolean hardcoreLumber = true;
        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
            ItemStack log;
            ItemStack plank = new ItemStack(Blocks.PLANKS, hardcoreLumber ? 4 : 6, type.getMetadata());
            if (type.getMetadata() < 4) {
                log = new ItemStack(Blocks.LOG, 1, type.getMetadata());

            } else {
                log = new ItemStack(Blocks.LOG2, 1, type.getMetadata() - 4);
            }
            Block block = ((ItemBlock) log.getItem()).getBlock();
            ItemStack bark = new ItemStack(BWMItems.BARK, 1, type.getMetadata());
            ItemStack sawdust = ItemMaterial.getMaterial("sawdust", 2);
            if (hardcoreLumber) {
                removeRecipe(plank, log);
                GameRegistry.addRecipe(new ChoppingRecipe(new ItemStack(Blocks.PLANKS, 2, type.getMetadata()), bark, sawdust, log));
            }
            SawInteraction.INSTANCE.addRecipe(block, log.getMetadata(), plank, bark, sawdust);
            SawInteraction.INSTANCE.addRecipe(Blocks.PLANKS, type.getMetadata(),
                    new ItemStack(BWMBlocks.WOOD_SIDING, 2, type.getMetadata()));
            plank = new ItemStack(Blocks.PLANKS, hardcoreLumber ? 3 : 5, type.getMetadata());
            if (type.getMetadata() < 4) {
                log = new ItemStack(BWMBlocks.DEBARKED_OLD, 1, type.getMetadata());
            } else {
                log = new ItemStack(BWMBlocks.DEBARKED_NEW, 1, type.getMetadata() - 4);
            }
            block = ((ItemBlock) log.getItem()).getBlock();
            SawInteraction.INSTANCE.addRecipe(block, log.getMetadata(), plank, sawdust);
        }
        List<ItemStack> logs = OreDictionary.getOres("logWood");
        for (ItemStack log : logs) {
            if (log.getItem() != null && log.getItem() instanceof ItemBlock) {
                Block block = ((ItemBlock) log.getItem()).getBlock();
                // only if not vanilla
                if (!block.getRegistryName().getResourceDomain().equals("minecraft")) {
                    if (log.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
                        for (int i = 0; i < 4; i++) {
                            ItemStack planks = getRecipeOutput(new ItemStack(log.getItem(), 1, i));
                            if (planks != null) {
                                ItemStack[] output = new ItemStack[3];
                                output[0] = new ItemStack(planks.getItem(), hardcoreLumber ? 4 : 6, planks.getMetadata());
                                output[1] = new ItemStack(BWMItems.BARK, 1, 0);
                                output[2] = ItemMaterial.getMaterial("sawdust", 2);
                                if (hardcoreLumber) {
                                    removeRecipe(output[0], log);
                                    GameRegistry.addRecipe(new ChoppingRecipe(new ItemStack(planks.getItem(), 2, planks.getMetadata()), output[1], output[2], log));
                                }
                                SawInteraction.INSTANCE.addRecipe(block, i, output);
                                SawInteraction.INSTANCE.addRecipe(planks, new ItemStack(BWMBlocks.WOOD_SIDING, 2, 0));
                            }
                        }
                    } else {
                        ItemStack planks = getRecipeOutput(log);
                        if (planks != null) {
                            ItemStack[] output = new ItemStack[3];
                            output[0] = new ItemStack(planks.getItem(), hardcoreLumber ? 4 : 6, planks.getMetadata());
                            output[1] = new ItemStack(BWMItems.BARK, 1, 0);
                            output[2] = ItemMaterial.getMaterial("sawdust", 2);
                            if (hardcoreLumber) {
                                removeRecipe(output[0], log);
                                GameRegistry.addRecipe(new ChoppingRecipe(new ItemStack(planks.getItem(), 2, planks.getMetadata()), output[1], output[2], log));
                            }
                            SawInteraction.INSTANCE.addRecipe(block, log.getMetadata(), output);
                            SawInteraction.INSTANCE.addRecipe(planks, new ItemStack(BWMBlocks.WOOD_SIDING, 2, 0));
                        }
                    }
                }
            }
        }
    }

    private static ItemStack getRecipeOutput(ItemStack input) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        for (IRecipe recipe : recipes) {
            if (recipe instanceof ShapelessRecipes) {
                ShapelessRecipes shapeless = (ShapelessRecipes) recipe;
                if (shapeless.recipeItems.size() == 1 && shapeless.recipeItems.get(0).isItemEqual(input)) {
                    return shapeless.getRecipeOutput();
                }
            } else if (recipe instanceof ShapelessOreRecipe) {
                ShapelessOreRecipe shapeless = (ShapelessOreRecipe) recipe;
                if (shapeless.getRecipeSize() == 1) {
                    if (shapeless.getInput().get(0) instanceof ItemStack) {
                        if (((ItemStack) shapeless.getInput().get(0)).isItemEqual(input)) {
                            return shapeless.getRecipeOutput();
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void removeRecipe(ItemStack output, ItemStack input) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        List<IRecipe> toRemove = new ArrayList<>();
        for (IRecipe recipe : recipes) {
            if (recipe instanceof ShapedRecipes) {
                ShapedRecipes shaped = (ShapedRecipes) recipe;
                if (shaped.getRecipeSize() == 1) {
                    if (shaped.recipeItems[0].isItemEqual(input)) {
                        if(output.isItemEqual(shaped.getRecipeOutput()))
                            toRemove.add(recipe);
                    }
                }
            }
            else if (recipe instanceof ShapelessRecipes) {
                ShapelessRecipes shapeless = (ShapelessRecipes) recipe;
                if (shapeless.recipeItems.size() == 1 && shapeless.recipeItems.get(0).isItemEqual(input)) {
                    if(output.isItemEqual(shapeless.getRecipeOutput()))
                        toRemove.add(recipe);
                }
            } else if (recipe instanceof ShapelessOreRecipe) {
                ShapelessOreRecipe shapeless = (ShapelessOreRecipe) recipe;
                if (shapeless.getRecipeSize() == 1) {
                    if (shapeless.getInput().get(0) instanceof ItemStack) {
                        if (((ItemStack) shapeless.getInput().get(0)).isItemEqual(input)) {
                            if(output.isItemEqual(shapeless.getRecipeOutput()))
                                toRemove.add(recipe);
                        }
                    }
                }
            }
        }
        for(IRecipe remove : toRemove) {
            CraftingManager.getInstance().getRecipeList().remove(remove);
        }
    }

    private static void registerPotions() {
        registerPotion(POTION_TRUESIGHT);
    }

    private static void registerPotion(Potion potion) {
        String potionName = potion.getRegistryName().toString().substring(BWMod.MODID.length() + ":".length());
        potion.setPotionName("bwm.effect." + potionName);
        GameRegistry.register(potion);
    }


}
