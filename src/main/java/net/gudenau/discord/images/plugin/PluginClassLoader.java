package net.gudenau.discord.images.plugin;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * A simple ClassLoader implementation for plugin loading.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class PluginClassLoader extends URLClassLoader{
    public PluginClassLoader(ClassLoader parent){
        super(new URL[0], parent);
    }
    
    @Override
    public void addURL(URL url){
        super.addURL(url);
    }
}
