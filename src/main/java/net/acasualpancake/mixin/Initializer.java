package net.acasualpancake.mixin;

import com.google.common.io.Files;
import net.acasualpancake.CivilizationMod;
import net.acasualpancake.util.FileAtlas;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.IOException;

@Mixin(MinecraftServer.class)
public class Initializer {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		try {
			// Get files
			File root = FabricLoader.getInstance().getGameDir().toFile();

			File datafolder = new File(root, "Civilization");
			if (!datafolder.exists()) {
				datafolder.mkdirs();
				CivilizationMod.LOGGER.info("Created " + datafolder.getPath());
			}

			File playerdata = new File(datafolder, "playerdata");
			if (!playerdata.exists()) {
				playerdata.mkdirs();
				CivilizationMod.LOGGER.info("Created " + playerdata.getPath());
			}

			File assets = new File(datafolder, "assets");
			if (!assets.exists()) {
				assets.mkdirs();
				CivilizationMod.LOGGER.info("Created " + assets.getPath());
			}

			File config = new File(datafolder, "config.text.dat");
			if (!config.exists()) {
				Files.touch(config);
				CivilizationMod.LOGGER.info("Created " + config.getPath());
			}

			File discord_config = new File(datafolder, "discord.text.dat");
			if (!discord_config.exists()) {
				Files.touch(discord_config);
				CivilizationMod.LOGGER.info("Created " + discord_config.getPath());
			}

			// Register files to file atlas
			FileAtlas.update("root", root);
			FileAtlas.update("datafolder", datafolder);
			FileAtlas.update("config", config);
			FileAtlas.update("discord_config", discord_config);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}