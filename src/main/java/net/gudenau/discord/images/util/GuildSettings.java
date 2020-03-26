package net.gudenau.discord.images.util;

import com.google.gson.annotations.Expose;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;

/**
 * Settings related to a guild.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class GuildSettings{
    /**
     * The guild that these settings belong to.
     *
     * @since 1.0.0
     * */
    transient Guild guild;
    
    /**
     * The command prefix of the guild.
     *
     * @since 1.0.0
     * */
    @Nullable
    @Expose public String prefix = null;
}
