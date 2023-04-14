package net.acasualpancake.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.acasualpancake.CivilizationMod;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class VersionCommand {
    private static int run(@NotNull CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        // ServerPlayerEntity player = context.getSource().getPlayer();
        ServerCommandSource source = context.getSource();
        source.sendFeedback(new LiteralText("Running on CivilizationMod.v" + CivilizationMod.VERSION), false);
        return 1;
    }

    public static void register(@NotNull CommandDispatcher<ServerCommandSource> dispatcher, boolean b) {
        dispatcher.register(CommandManager.literal("civ-version").executes(VersionCommand::run));
    }
}
