package net.derex.mace.init;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public class MaceBackportModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> MACEDEBUGMODE = GameRuleRegistry.register("maceDebugMode", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));
	public static final GameRules.Key<GameRules.IntegerValue> MACE_DAMAGE_CAP = GameRuleRegistry.register("maceDamageCap", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(-1));

	public static void registerGameRules() {
		MACEDEBUGMODE.toString();
		MACE_DAMAGE_CAP.toString();
	}
}