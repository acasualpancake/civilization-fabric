package net.acasualpancake.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

@SuppressWarnings("unused")
public class BotUtil {

    public static JDA JDA;

    /**
     * <p>Utility class.</p>
     */
    private BotUtil() {}

    /**
     * <p>Starts the discord bot and automatically initializes it.</p>
     * @param token The bot token.
     */
    public static void runBot(String token) {
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.enableIntents(
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_INVITES,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_PRESENCES
        );
        builder.setActivity(Activity.listening("Startup"));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        init(builder);
        JDA = builder.build();
    }

    /**
     * <p>Please use this method to register events, etc.</p>
     * @param builder The active discord jda builder.
     */
    public static void init(JDABuilder builder) {
        // Do code here
    }
}
