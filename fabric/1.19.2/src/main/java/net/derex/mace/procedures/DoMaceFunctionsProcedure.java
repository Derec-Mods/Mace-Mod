package net.derex.mace.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.derex.mace.init.MaceBackportModGameRules;
import net.derex.mace.MaceBackportMod;

public class DoMaceFunctionsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double fallDmg = 0;
		double fallHeight = 0;
		fallHeight = sourceentity.fallDistance;/*code*/
		fallDmg = 1 + fallHeight / 2;
		sourceentity.fallDistance = 0;
		if (fallHeight > 1.5) {
			{
				Entity _entToDamage = entity;
				_entToDamage.hurt(new DamageSource(_entToDamage.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) fallDmg);
			}
			if (!entity.isOnGround()) {
				PlayAirSmashSoundsProcedure.execute(world, x, y, z);
			} else {
				if (fallHeight > 5) {
					PlayHeavySmashSoundProcedure.execute(world, x, y, z);
				} else if (fallHeight <= 5) {
					PlayLowSmashSoundsProcedure.execute(world, x, y, z);
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(MaceBackportModGameRules.MACEDEBUGMODE)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("[Debug] Fall Height from Attack: " + fallHeight)), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("[Debug] Mace damage from Attack: " + fallDmg)), false);
				MaceBackportMod.LOGGER.info("[Debug] Fall Height from Attack: " + fallHeight);
				MaceBackportMod.LOGGER.info("[Debug] Mace damage from Attack: " + fallDmg);
			}
		}
	}
}
