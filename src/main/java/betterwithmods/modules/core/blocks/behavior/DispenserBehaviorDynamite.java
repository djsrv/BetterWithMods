package betterwithmods.modules.core.blocks.behavior;

import betterwithmods.modules.utilities.entity.EntityDynamite;
import betterwithmods.modules.utilities.features.Explosives;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DispenserBehaviorDynamite extends BehaviorProjectileDispense {

    @Override
    protected IProjectile getProjectileEntity(World world, IPosition pos, ItemStack stack) {
        return new EntityDynamite(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Explosives.DYNAMITE, 1));
    }

}
