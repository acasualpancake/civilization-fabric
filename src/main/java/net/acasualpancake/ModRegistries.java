package net.acasualpancake;

import net.acasualpancake.commands.VersionCommand;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

@SuppressWarnings("unused")
public class ModRegistries {

    public static void runModRegistries() {
        registerCommands();
        registerEvents();
    }

    private static void registerCommands() {
        CivilizationMod.LOGGER.info("Registering commands...");

        // Register commands
        registerCommand(VersionCommand::register);
    }

    private static void registerEvents() {
        CivilizationMod.LOGGER.info("Registering events...");

        // Register events
    }

    // Simplification methods

    private static void registerCommand(CommandRegistrationCallback listener) {
        CommandRegistrationCallback.EVENT.register(listener);
    }
}
