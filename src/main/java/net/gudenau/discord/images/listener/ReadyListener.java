package net.gudenau.discord.images.listener;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.gudenau.discord.images.plugin.PluginLoader;
import net.gudenau.discord.images.util.DiscordUtil;

public class ReadyListener{
    @SubscribeEvent
    public void onReady(ReadyEvent event){
        var jda = event.getJDA();
        var user = jda.getSelfUser();
        jda.getPresence().setActivity(Activity.playing("@" + user.getName() + " help"));
        DiscordUtil.onReady(jda);
        PluginLoader.onReady(jda);
    }
}
