package net.derex.mace.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.derex.mace.init.MaceBackportModItems;

public class WindBurstEnchantment extends Enchantment {
	public WindBurstEnchantment() {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}

	public WindBurstEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canEnchant(ItemStack itemstack) {
		return itemstack.is(MaceBackportModItems.MACE);
	}
}
