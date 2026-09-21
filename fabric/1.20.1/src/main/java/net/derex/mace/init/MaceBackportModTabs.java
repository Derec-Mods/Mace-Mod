package net.derex.mace.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.derex.mace.MaceBackportMod;

public class MaceBackportModTabs {
	public static final CreativeModeTab MACE_TAB = FabricItemGroupBuilder.build(
		new ResourceLocation(MaceBackportMod.MODID, "mace_tab"),
		() -> new ItemStack(MaceBackportModItems.MACE)
	);

	public static void registerCreativeTabs() {
	}
}