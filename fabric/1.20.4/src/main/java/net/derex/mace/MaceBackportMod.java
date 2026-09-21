package net.derex.mace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

import net.derex.mace.init.MaceBackportModSounds;
import net.derex.mace.init.MaceBackportModItems;
import net.derex.mace.init.MaceBackportModEnchantments;
import net.derex.mace.init.MaceBackportModGameRules;
import net.derex.mace.init.MaceBackportModTabs;
import net.derex.mace.procedures.WindBurstFunctionProcedure;

public class MaceBackportMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mace_backport");
	public static final String MODID = "mace_backport";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing MaceBackportMod");
		MaceBackportModItems.registerItems();
		MaceBackportModSounds.registerSounds();
		MaceBackportModEnchantments.registerEnchantments();
		MaceBackportModGameRules.registerGameRules();
		MaceBackportModTabs.registerCreativeTabs();
		WindBurstFunctionProcedure.registerEvent();
	}
}
