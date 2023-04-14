package net.acasualpancake;

import net.acasualpancake.util.FileAtlas;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CivilizationMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("civilization");
	public static final String VERSION = "1.0.0-alpha.0";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing civilization mod...");

		// Initialize file atlas
		if (!FileAtlas.init()) throw new RuntimeException("Could not initialize FileAtlas");

		// Register registries
		ModRegistries.runModRegistries();

		LOGGER.info("Done. Initialized civilization mod.");
	}
}