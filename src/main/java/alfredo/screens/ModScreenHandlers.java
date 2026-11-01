package alfredo.screens;

import alfredo.AlFredo;
import alfredo.screens.custom.PlantBombScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
	public static final ScreenHandlerType<PlantBombScreenHandler> PLANTBOMB_SCREEN_HANDLER = Registry.register(
			Registries.SCREEN_HANDLER, Identifier.of(AlFredo.MOD_ID, "plantbomb_screen_handler"),
			new ExtendedScreenHandlerType<>(PlantBombScreenHandler::new, BlockPos.PACKET_CODEC));

	public static void registerScreenHandlers() {
		AlFredo.LOGGER.info("Registering Screen Handlers for " + AlFredo.MOD_ID);
	}
}