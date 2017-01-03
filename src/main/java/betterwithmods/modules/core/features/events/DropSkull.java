package betterwithmods.modules.core.features.events;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.base.util.player.EntityPlayerExt;
import betterwithmods.modules.tweaks.feature.Dung;
import betterwithmods.modules.utilities.features.Tools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class DropSkull extends Feature {
    public void addDrop(LivingDropsEvent evt, ItemStack drop) {
        EntityItem item = new EntityItem(evt.getEntityLiving().getEntityWorld(), evt.getEntityLiving().posX, evt.getEntityLiving().posY, evt.getEntityLiving().posZ, drop);
        item.setDefaultPickupDelay();
        evt.getDrops().add(item);
    }


    private boolean isChoppingBlock(World world, BlockPos pos) {
        //TODO chopping blocks
//        if (world.getBlockState(pos).getBlock() == BWMBlocks.AESTHETIC) {
//            IBlockState state = world.getBlockState(pos);
//            return state.getValue(BlockAesthetic.blockType) == BlockAesthetic.EnumType.CHOPBLOCK || state.getValue(BlockAesthetic.blockType) == BlockAesthetic.EnumType.CHOPBLOCKBLOOD;
//        }
        return false;
    }

    private boolean isBattleAxe(EntityLivingBase entity) {
        DamageSource source = entity.getLastDamageSource();
        if (source != null && source.getSourceOfDamage() != null) {
            Entity e = source.getSourceOfDamage();
            if (e instanceof EntityLivingBase) {
                ItemStack held = ((EntityLivingBase) e).getHeldItemMainhand();
                if (held != null && held.isItemEqual(new ItemStack(Tools.STEEL_BATTLEAXE))) {
                    return true;
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public void dropSkull(LivingDropsEvent evt) {
        BlockPos pos = evt.getEntityLiving().getPosition().down();
        if (isChoppingBlock(evt.getEntityLiving().getEntityWorld(), pos) || isBattleAxe(evt.getEntityLiving())) {
            if (!(evt.getEntityLiving() instanceof EntityPlayer)) {
                for (EntityItem item : evt.getDrops()) {
                    ItemStack stack = item.getEntityItem();
                    if (stack.getMaxStackSize() != 1 && evt.getEntity().getEntityWorld().rand.nextBoolean())
                        item.setEntityItemStack(new ItemStack(stack.getItem(), stack.stackSize + 1, stack.getItemDamage()));
                }
            }
            if (ModuleLoader.isFeatureEnabled(Dung.class) && evt.getEntityLiving() instanceof EntityAgeable)
                addDrop(evt, new ItemStack(Dung.DUNG));

            int headChance = evt.getEntityLiving().getEntityWorld().rand.nextInt(12);
            if (headChance < 5) {
                if (evt.getEntityLiving() instanceof EntitySkeleton) {
                    EntitySkeleton skeltal = (EntitySkeleton) evt.getEntityLiving();
                    if (skeltal.getSkeletonType() != SkeletonType.STRAY)
                        addDrop(evt, new ItemStack(Items.SKULL, 1, skeltal.getSkeletonType().getId()));
                } else if (evt.getEntityLiving() instanceof EntityZombie)
                    addDrop(evt, new ItemStack(Items.SKULL, 1, 2));
                else if (evt.getEntityLiving() instanceof EntityCreeper)
                    addDrop(evt, new ItemStack(Items.SKULL, 1, 4));
                else if (evt.getEntityLiving() instanceof EntityPlayer) {
                    addDrop(evt, EntityPlayerExt.getPlayerHead((EntityPlayer) evt.getEntityLiving()));
                }
            }
        }
    }


    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
