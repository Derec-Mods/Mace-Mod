
package net.derex.mace.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.derex.mace.MaceBackportMod;

public class MaceBackportModTabs {

    public static final CreativeModeTab MACE_TAB = Registry.register(
            Registries.CREATIVE_MODE_TAB,
            new ResourceLocation(MaceBackportMod.MODID, "mace_tab"),
            net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup.builder()
                    .icon(() -> new ItemStack(MaceBackportModItems.MACE))
                    .title(net.minecraft.network.chat.Component.translatable("itemGroup.mace_backport.mace_tab"))
                    .displayItems((itemDisplayContext, entries) -> {
                        entries.add(MaceBackportModItems.MACE);
                    })
                    .build()
    );

    public static void registerCreativeTabs() {
        // This method is primarily for ensuring the static initializer of MACE_TAB is run.
        // The actual registration happens during the static initialization.
    }
}