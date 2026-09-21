package net.derex.mace.init;

import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.derex.mace.item.MaceItem;
import net.derex.mace.MaceBackportMod;

public class MaceBackportModItems {
	public static final Item MACE = new MaceItem();

	public static void registerItems() {
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MaceBackportMod.MODID, "mace"), MACE);
	}
}