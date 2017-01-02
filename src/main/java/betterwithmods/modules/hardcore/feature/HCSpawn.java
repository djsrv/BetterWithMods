package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.player.EntityPlayerExt;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Makes death a problem again.
 *
 * @author Koward
 */
public class HCSpawn extends Feature {
    public static int HARDCORE_SPAWN_RADIUS = 2000;
    public static int HARDCORE_SPAWN_COOLDOWN = 24000;//20 min
    public static final int HARDCORE_SPAWN_MAX_ATTEMPTS = 20;

    @Override
    public void setupConfig() {
        HARDCORE_SPAWN_RADIUS = loadPropInt("Hardcore Spawn Radius","Radius from 0,0 that HC Spawn will randomly spawn you in",2000);
        HARDCORE_SPAWN_RADIUS = loadPropInt("Hardcore Spawn Cooldown","Cooldown to get a new spawn",24000);

        super.setupConfig();
    }

    public static boolean isInRadius(World world, BlockPos pos) {
        return isInRadius(world, pos.getX(), pos.getZ());
    }

    public static boolean isInRadius(World world, int x, int z) {
        BlockPos center = world.getSpawnPoint();
        return Math.sqrt(Math.pow(x - center.getX(), 2) + Math.pow(z - center.getZ(), 2)) < HCSpawn.HARDCORE_SPAWN_RADIUS;
    }

    /**
     * Random Respawn. Less intense when there is a short time since death.
     */
    @SubscribeEvent
    public void randomRespawn(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof EntityPlayerMP)) return;
        EntityPlayerMP player = (EntityPlayerMP) event.getEntity();
        if (EntityPlayerExt.isSurvival(player)) {
            int timeSinceDeath = player.getStatFile().readStat(StatList.TIME_SINCE_DEATH);
            int spawnFuzz = timeSinceDeath >= HARDCORE_SPAWN_COOLDOWN ? HARDCORE_SPAWN_RADIUS : 100;
            BlockPos newPos = getRespawnPoint(player, spawnFuzz);
            player.setSpawnPoint(newPos, true);
        }
    }

    /**
     * Find a random position to respawn. Tries 20 times maximum to find a
     * suitable place. Else, the previous SP will remain unchanged.
     *
     * @param spawnFuzz A "size coefficient" variable. Proportional to distance
     *                  between spawn points.
     * @return The new BlockPos
     */
    public BlockPos getRespawnPoint(EntityPlayer player, int spawnFuzz) {
        World world = player.getEntityWorld();
        BlockPos ret = world.getSpawnPoint();
        if (!world.provider.hasNoSky()) {
            boolean found = false;
            for (int tryCounter = 0; tryCounter < HARDCORE_SPAWN_MAX_ATTEMPTS; tryCounter++) {
                ret = world.getSpawnPoint();
                double fuzzVar = world.rand.nextDouble() * spawnFuzz;
                double angle = world.rand.nextDouble();
                double customX = (double) (-MathHelper
                        .sin((float) (angle * 360.0D))) * fuzzVar;
                double customZ = (double) MathHelper
                        .cos((float) (angle * 360.0D)) * fuzzVar;
                ret = ret.add(MathHelper.floor(customX) + 0.5D, 1.5D,
                        MathHelper.floor(customZ) + 0.5D);
                ret = world.getTopSolidOrLiquidBlock(ret);

                // Check if the position is correct
                int cmp = ret.getY()
                        - world.provider.getAverageGroundLevel();
                Material check = world.getBlockState(ret).getMaterial();
                if (cmp >= 0 && (check == null || !check.isLiquid())) {
                    found = true;
                    break;
                }
            }
            if (!found) BWMod.logger.warn("New respawn point could not be found.");
        }

        return ret;
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
