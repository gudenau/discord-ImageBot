package net.gudenau.discord.images.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Manages the native libs.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class Natives{
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    
    private static final String[] LIBS = new String[]{
        "magick"
    };
    
    public static void loadNatives(){
        synchronized(INITIALIZED){
            if(INITIALIZED.getAndSet(true)){
                return;
            }
        }
        
        Os os = getOs();
        Arch arch = getArch();
        
        if(os == Os.UNKNOWN || arch == Arch.UNKNOWN){
            throw new RuntimeException(String.format(
                "Unsupported OS and arch combo: %s %s",
                System.getProperty("os.name"),
                System.getProperty("os.arch")
            ));
        }
    
        try{
            extractNatives(os, arch);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        loadNatives(os);
    }
    
    private static Os getOs(){
        var osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("linux")){
            return Os.LINUX;
        }else{
            return Os.UNKNOWN;
        }
    }
    
    private static Arch getArch(){
        var arch = System.getProperty("os.arch").toLowerCase();
        if(arch.contains("amd64")){
            return Arch.AMD64;
        }else{
            return Arch.UNKNOWN;
        }
    }
    
    private static void extractNatives(Os os, Arch arch) throws IOException{
        var locator = ResourceLocator.getInstance();
        for(String lib : LIBS){
            var libFile = os.prefix + lib + os.extension;
            try(
                var input = locator.getResource("res/natives", arch.directory, libFile);
                var output = Files.newOutputStream(Path.of(libFile), StandardOpenOption.CREATE)
            ){
                input.transferTo(output);
            }
        }
    }
    
    private static void loadNatives(Os os){
        for(var lib : LIBS){
            var libFile = os.prefix + lib + os.extension;
            var libPath = Path.of(libFile).toAbsolutePath();
            System.load(libPath.toString());
        }
    }
    
    private enum Os{
        UNKNOWN("", ""),
        LINUX("lib", ".so");
    
        private final String prefix;
        private final String extension;
    
        Os(String prefix, String extension){
            this.prefix = prefix;
            this.extension = extension;
        }
    }
    
    private enum Arch{
        UNKNOWN(""),
        AMD64("amd64");
    
        private final String directory;
    
        Arch(String directory){
            this.directory = directory;
        }
    }
    
    // Because IDEA is stupid
    private static abstract class ResourceLocator{
        private static ResourceLocator INSTANCE;
        
        public static ResourceLocator getInstance(){
            if(INSTANCE == null){
                Path location;
                try{
                    location = Path.of(ResourceLocator.class.getProtectionDomain().getCodeSource().getLocation().toURI());
                }catch(URISyntaxException e){
                    throw new RuntimeException(e);
                }
                if(Files.isRegularFile(location)){
                    INSTANCE = new ClassLocator();
                }else{
                    INSTANCE = new DirectoryLocator(location);
                }
            }
            return INSTANCE;
        }
        
        InputStream getResource(String... segments){
            var builder = new StringBuilder();
            for(String segment : segments){
                builder.append(segment).append("/");
            }
            builder.setLength(builder.length() - 1);
            return getResource(builder.toString());
        }
        
        abstract InputStream getResource(String resource);
    
        private static class ClassLocator extends ResourceLocator{
            @Override
            InputStream getResource(String resource){
                return ClassLocator.class.getResourceAsStream("/" + resource);
            }
        }
    
        private static class DirectoryLocator extends ResourceLocator{
            private final Path location;
    
            public DirectoryLocator(Path location){
                this.location = location.getParent().getParent().resolveSibling("resources/main");
            }
    
            @Override
            InputStream getResource(String resource){
                try{
                    return Files.newInputStream(location.resolve(resource));
                }catch(IOException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
