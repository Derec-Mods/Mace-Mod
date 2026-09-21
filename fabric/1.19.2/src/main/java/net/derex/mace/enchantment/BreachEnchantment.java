package net.derex.mace.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.derex.mace.init.MaceBackportModItems;

public class BreachEnchantment extends Enchantment {
	public BreachEnchantment() {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}

	public BreachEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public boolean canEnchant(ItemStack itemstack) {
		return itemstack.is(MaceBackportModItems.MACE);
	}
}
