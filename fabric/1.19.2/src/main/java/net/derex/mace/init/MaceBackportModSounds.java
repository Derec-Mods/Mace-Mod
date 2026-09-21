
package net.derex.mace.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;

import net.derex.mace.MaceBackportMod;

public class MaceBackportModSounds {
	public static final SoundEvent MACE_SMASH_GROUND = SoundEvent.createVariableRangeEvent(new ResourceLocation("mace_backport", "mace_smash_ground"));
	public static final SoundEvent MACE_SMASH_AIR = SoundEvent.createVariableRangeEvent(new ResourceLocation("mace_backport", "mace_smash_air"));
	public static final SoundEvent MACE_SMASH_GROUND_HEAVY = SoundEvent.createVariableRangeEvent(new ResourceLocation("mace_backport", "mace_smash_ground_heavy"));

	public static void registerSounds() {
		Registry.register(Registries.SOUND_EVENT, new ResourceLocation(MaceBackportMod.MODID, "mace_smash_ground"), MACE_SMASH_GROUND);
		Registry.register(Registries.SOUND_EVENT, new ResourceLocation(MaceBackportMod.MODID, "mace_smash_air"), MACE_SMASH_AIR);
		Registry.register(Registries.SOUND_EVENT, new ResourceLocation(MaceBackportMod.MODID, "mace_smash_ground_heavy"), MACE_SMASH_GROUND_HEAVY);
	}
}