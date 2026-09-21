package net.derex.mace.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.derex.mace.init.MaceBackportModEnchantments;

public class WindBurstFunctionProcedure {

	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double windBounceLevel = 0;
		double fallHeight = 0;
		ItemStack itemstack = sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
		if (EnchantmentHelper.getItemEnchantmentLevel(MaceBackportModEnchantments.WIND_BURST, itemstack) > 0) {
			fallHeight = sourceentity.fallDistance;
			if (fallHeight > 1.5) {
				windBounceLevel = EnchantmentHelper.getItemEnchantmentLevel(MaceBackportModEnchantments.WIND_BURST, itemstack);
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