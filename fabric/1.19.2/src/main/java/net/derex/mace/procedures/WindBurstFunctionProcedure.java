package net.derex.mace.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.derex.mace.init.MaceBackportModEnchantments;

public class WindBurstFunctionProcedure {

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double windBounceLevel = 0;
		double fallHeight = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(MaceBackportModEnchantments.WIND_BURST) > 0) {
			fallHeight = sourceentity.fallDistance;
			if (fallHeight > 1.5) {
				windBounceLevel = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(MaceBackportModEnchantments.WIND_BURST);
				sourceentity.setDeltaMovement(new Vec3((sourceentity.getDeltaMovement().x()), (1 + windBounceLevel * 0.1), (sourceentity.getDeltaMovement().z())));
				entity.fallDistance = 0;
			}
		}
	}

	public static void registerEvent() {
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (player != null && entity != null && hand == InteractionHand.MAIN_HAND) {
				execute(entity, player);
			}
			return InteractionResult.PASS;
		});
	}
}