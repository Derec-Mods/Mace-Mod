package net.derex.mace.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.derex.mace.init.MaceBackportModGameRules;
import net.derex.mace.init.MaceBackportModEnchantments;
import net.derex.mace.MaceBackportMod;

public class DoMaceFunctionsUpdatedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double fallDmg = 0;
		double fallHeight = 0;
		double playerBaseDamage = 0;
		double densityDmg = 0;
		double remainingFallHeight = 0;
		double firstDamage = 0;
		double secondDamage = 0;
		double remainingDamage = 0;
		double rawDamage = 0;
		fallHeight = Math.ceil(sourceentity.fallDistance);
		remainingFallHeight = fallHeight;/*code*/
		playerBaseDamage = ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue();
		firstDamage = Math.min(remainingFallHeight, 3) * 4;
		remainingFallHeight = remainingFallHeight - 3;
		secondDamage = Math.min(remainingFallHeight, 5) * 4;
		remainingFallHeight = remainingFallHeight - 5;
		rawDamage = firstDamage + secondDamage + remainingDamage;
		densityDmg = fallHeight * 0.5 * itemstack.getEnchantmentLevel(MaceBackportModEnchantments.DENSITY);
		fallDmg = 1.5 * (rawDamage + densityDmg);
		sourceentity.fallDistance = 0;
		sourceentity.setDeltaMovement(new Vec3(0, 0, 0));
		if (fallHeight > 1.5) {
			if ((world.getLevelData().getGameRules().getInt(MaceBackportModGameRules.MACE_DAMAGE_CAP)) != -1) {
				if (fallDmg > (world.getLevelData().getGameRules().getInt(MaceBackportModGameRules.MACE_DAMAGE_CAP))) {
					fallDmg = (world.getLevelData().getGameRules().getInt(MaceBackportModGameRules.MACE_DAMAGE_CAP));
				} else {
					fallDmg = fallDmg;
				}
			}
			if (itemstack.getEnchantmentLevel(MaceBackportModEnchantments.BREACH) > 0) {
				{
					Entity _entToDamage = entity;
					_entToDamage.hurt(new DamageSource(_entToDamage.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) (fallDmg * 1.15));
				}
			} else {
				{
					Entity _entToDamage = entity;
					_entToDamage.hurt(new DamageSource(_entToDamage.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) fallDmg);
				}
			}
			if (entity instanceof EnderDragon) {
				{
					Entity _entToDamage = entity;
					_entToDamage.hurt(new DamageSource(_entToDamage.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) fallDmg);
				}
			} /*Nonessential Functions below after essential functions execute*/
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, x, (y + 1.5), z, 25, 4, 0, 4, 1);
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
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("[Debug] Base Attack Damage: " + playerBaseDamage)), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("[Debug] Mace damage from Attack: " + fallDmg)), false);
				MaceBackportMod.LOGGER.info("[Debug] Base Attack Damage" + playerBaseDamage);
				MaceBackportMod.LOGGER.info("[Debug] Fall Height from Attack: " + fallHeight);
				MaceBackportMod.LOGGER.info("[Debug] Mace damage from Attack: " + fallDmg);
			}
			if (!(sourceentity instanceof ServerPlayer _plr19 && _plr19.level instanceof ServerLevel
					&& _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("mace_backport:over_overkill"))).isDone()) && fallDmg >= 100) {
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mace_backport:over_overkill"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
