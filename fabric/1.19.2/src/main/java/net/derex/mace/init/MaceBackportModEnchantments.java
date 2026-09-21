
package net.derex.mace.init;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;

import net.derex.mace.enchantment.WindBurstEnchantment;
import net.derex.mace.enchantment.DensityEnchantment;
import net.derex.mace.enchantment.BreachEnchantment;
import net.derex.mace.MaceBackportMod;

public class MaceBackportModEnchantments {
	public static final Enchantment BREACH = new BreachEnchantment();
	public static final Enchantment DENSITY = new DensityEnchantment();
	public static final Enchantment WIND_BURST = new WindBurstEnchantment();

	public static void registerEnchantments() {
		Registry.register(Registries.ENCHANTMENT, new ResourceLocation(MaceBackportMod.MODID, "breach"), BREACH);
		Registry.register(Registries.ENCHANTMENT, new ResourceLocation(MaceBackportMod.MODID, "density"), DENSITY);
		Registry.register(Registries.ENCHANTMENT, new ResourceLocation(MaceBackportMod.MODID, "wind_burst"), WIND_BURST);
	}
}