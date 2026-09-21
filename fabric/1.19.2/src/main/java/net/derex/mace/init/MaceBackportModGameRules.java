
package net.derex.mace.init;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public class MaceBackportModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> MACEDEBUGMODE = GameRuleRegistry.register("maceDebugMode", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> MACE_DAMAGE_CAP = GameRuleRegistry.register("maceDamageCap", GameRules.Category.PLAYER, GameRules.IntegerValue.create(-1));

	public static void registerGameRules() {
		// Game rules are registered when their static fields are accessed.
		// Accessing them here ensures they are initialized.
		MACEDEBUGMODE.toString();
		MACE_DAMAGE_CAP.toString();
	}
}