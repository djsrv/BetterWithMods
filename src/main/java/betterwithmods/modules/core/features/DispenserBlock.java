package betterwithmods.modules.core.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.core.blocks.BlockBDispenser;
import betterwithmods.modules.core.blocks.behavior.DispenserBehaviorDiode;
import betterwithmods.modules.core.blocks.behavior.DispenserBehaviorDynamite;
import betterwithmods.modules.utilities.blocks.BlockWolf;
import betterwithmods.modules.utilities.entity.EntityMiningCharge;
import betterwithmods.modules.utilities.features.Explosives;
import betterwithmods.modules.utilities.tiles.TileEntityBlockDispenser;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class DispenserBlock extends Feature {

    public static Block BLOCK_DISPENSER;
    public static Block WOLF;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BLOCK_DISPENSER = new BlockBDispenser().setRegistryName("block_dispenser");
        WOLF = new BlockWolf().setRegistryName("companion_cube");
        registerBlock(BLOCK_DISPENSER);
        registerBlock(WOLF);
        registerTile(TileEntityBlockDispenser.class, "bwm.block_dispenser");
    }

    public static FakePlayer player;

    //Initializing a static fake player for saws, so spawn isn't flooded with player equipping sounds when mobs hit the saw.
    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load evt) {
        if (evt.getWorld() instanceof WorldServer) {
            player = FakePlayerFactory.getMinecraft((WorldServer) evt.getWorld());
        }
    }

    //Not sure if this would be needed, but can't be too safe.
    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload evt) {
        if (evt.getWorld() instanceof WorldServer) {
            player = null;
        }
    }


    @Override
    public void init(FMLInitializationEvent event) {
        if (ModuleLoader.isFeatureEnabled(Explosives.class)) {
            BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Explosives.DYNAMITE, new DispenserBehaviorDynamite());
            BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Explosives.DYNAMITE, new DispenserBehaviorDynamite());
            BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Item.getItemFromBlock(Explosives.MINING_CHARGE),
                    (source, stack) -> {
                        World worldIn = source.getWorld();
                        EnumFacing facing = source.getBlockState().getValue(BlockDispenser.FACING);
                        BlockPos pos = source.getBlockPos().offset(facing);
                        EntityMiningCharge miningCharge = new EntityMiningCharge(worldIn, pos.getX() + 0.5F, pos.getY(),
                                pos.getZ() + 0.5F, null, facing);
                        miningCharge.setNoGravity(false);
                        worldIn.spawnEntity(miningCharge);
                        worldIn.playSound(null, miningCharge.posX, miningCharge.posY, miningCharge.posZ,
                                SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        return stack;
                    });
        }

        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Items.REPEATER, new DispenserBehaviorDiode());
        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Items.COMPARATOR, new DispenserBehaviorDiode());

    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
