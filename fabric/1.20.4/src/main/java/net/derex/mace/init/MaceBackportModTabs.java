package net.derex.mace.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class MaceBackportModTabs {
	public static void registerCreativeTabs() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
			entries.accept(MaceBackportModItems.MACE);
		});
	}
}