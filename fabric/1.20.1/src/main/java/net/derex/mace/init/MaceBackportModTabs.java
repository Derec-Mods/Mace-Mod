package net.derex.mace.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.derex.mace.MaceBackportMod;

public class MaceBackportModTabs {
	public static final ResourceKey<CreativeModeTab> MACE_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MaceBackportMod.MODID, "mace_tab"));
	public static final CreativeModeTab MACE_TAB = FabricItemGroup.builder()
		.icon(() -> new ItemStack(MaceBackportModItems.MACE))
		.title(Component.translatable("itemGroup.mace_backport.mace_tab"))
		.displayItems((itemDisplayParameters, output) -> {
			output.accept(MaceBackportModItems.MACE);
		})
		.build();

	public static void registerCreativeTabs() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MACE_TAB_KEY, MACE_TAB);
	}
}