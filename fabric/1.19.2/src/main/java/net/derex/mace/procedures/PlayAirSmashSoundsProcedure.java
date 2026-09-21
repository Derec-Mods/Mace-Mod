package net.derex.mace.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.derex.mace.init.MaceBackportModSounds;

public class PlayAirSmashSoundsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), MaceBackportModSounds.MACE_SMASH_AIR, SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, MaceBackportModSounds.MACE_SMASH_AIR, SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}