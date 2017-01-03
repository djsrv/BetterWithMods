package betterwithmods.modules.utilities.features;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.client.render.RenderBroadheadArrow;
import betterwithmods.modules.utilities.entity.EntityBroadheadArrow;
import betterwithmods.modules.utilities.items.tools.ItemBroadheadArrow;
import betterwithmods.modules.utilities.items.tools.ItemCompositeBow;
import betterwithmods.modules.utilities.items.tools.ItemKnife;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgeArmor;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedAxe;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedBattleAxe;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedHoe;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedMattock;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedPickaxe;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedShovel;
import betterwithmods.modules.utilities.items.tools.ItemSoulforgedSword;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Tools extends Feature {
    public static final Item.ToolMaterial SOULFORGED_STEEL = EnumHelper.addToolMaterial("SOULFORGED_STEEL", 3, 1561, 8, 3, 22);

    public static Item STEEL_AXE;
    public static Item STEEL_HOE;
    public static Item STEEL_PICKAXE;
    public static Item STEEL_SHOVEL;
    public static Item STEEL_SWORD;
    public static Item STEEL_MATTOCK;
    public static Item STEEL_BATTLEAXE;
    public static Item IRON_KNIFE;

    public static Item STEEL_HELMET;
    public static Item STEEL_CHEST;
    public static Item STEEL_PANTS;
    public static Item STEEL_BOOTS;

    public static Item COMPOSITE_BOW;
    public static Item BROADHEAD_ARROW;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        STEEL_AXE = new ItemSoulforgedAxe().setRegistryName("steel_axe");
        STEEL_HOE = new ItemSoulforgedHoe().setRegistryName("steel_hoe");
        STEEL_PICKAXE = new ItemSoulforgedPickaxe().setRegistryName("steel_pickaxe");
        STEEL_SHOVEL = new ItemSoulforgedShovel().setRegistryName("steel_shovel");
        STEEL_SWORD = new ItemSoulforgedSword().setRegistryName("steel_sword");
        STEEL_MATTOCK = new ItemSoulforgedMattock().setRegistryName("steel_mattock");
        STEEL_BATTLEAXE = new ItemSoulforgedBattleAxe().setRegistryName("steel_battleaxe");
        IRON_KNIFE = new ItemKnife(Item.ToolMaterial.IRON).setRegistryName("knife");


        STEEL_HELMET = new ItemSoulforgeArmor(EntityEquipmentSlot.HEAD).setRegistryName("steel_helmet");
        STEEL_CHEST = new ItemSoulforgeArmor(EntityEquipmentSlot.CHEST).setRegistryName("steel_chest");
        STEEL_PANTS = new ItemSoulforgeArmor(EntityEquipmentSlot.LEGS).setRegistryName("steel_pants");
        STEEL_BOOTS = new ItemSoulforgeArmor(EntityEquipmentSlot.FEET).setRegistryName("steel_boots");


        COMPOSITE_BOW = new ItemCompositeBow().setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("composite_bow");
        BROADHEAD_ARROW = new ItemBroadheadArrow().setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("broadhead_arrow");

        registerItem(STEEL_AXE);
        registerItem(STEEL_HOE);
        registerItem(STEEL_PICKAXE);
        registerItem(STEEL_SHOVEL);
        registerItem(STEEL_SWORD);
        registerItem(STEEL_MATTOCK);
        registerItem(STEEL_BATTLEAXE);
        registerItem(STEEL_HELMET);
        registerItem(STEEL_CHEST);
        registerItem(STEEL_PANTS);
        registerItem(STEEL_BOOTS);

        registerItem(IRON_KNIFE);

        registerItem(COMPOSITE_BOW);
        registerItem(BROADHEAD_ARROW);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(STEEL_AXE);
        ModelHandler.setInventoryModel(STEEL_HOE);
        ModelHandler.setInventoryModel(STEEL_PICKAXE);
        ModelHandler.setInventoryModel(STEEL_SHOVEL);
        ModelHandler.setInventoryModel(STEEL_SWORD);
        ModelHandler.setInventoryModel(STEEL_BATTLEAXE);
        ModelHandler.setInventoryModel(STEEL_MATTOCK);
        ModelHandler.setInventoryModel(STEEL_HELMET);
        ModelHandler.setInventoryModel(STEEL_CHEST);
        ModelHandler.setInventoryModel(STEEL_PANTS);
        ModelHandler.setInventoryModel(STEEL_BOOTS);
        ModelHandler.setInventoryModel(COMPOSITE_BOW);
        ModelHandler.setInventoryModel(BROADHEAD_ARROW);
        ModelHandler.setInventoryModel(IRON_KNIFE);


        RenderingRegistry.registerEntityRenderingHandler(EntityBroadheadArrow.class, RenderBroadheadArrow::new);
    }
}
