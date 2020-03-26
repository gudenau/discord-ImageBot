package net.gudenau.discord.images.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.annotation.Nonnull;
import net.gudenau.discord.images.internal.Memory;

/**
 * Network stuff.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class NetworkUtil{
    /**
     * Download a URL and return a ByteBuffer of the contents.
     *
     * @param url The URL to download.
     *
     * @return The buffer that contains the file.
     *
     * @throws java.io.IOException If there was an error reading the URL.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static ByteBuffer downloadToMemory(@Nonnull URL url) throws IOException{
        var connection = url.openConnection();
        connection.setDoOutput(false);
        connection.setDoInput(true);
        try(var stream = connection.getInputStream()){
            int length = connection.getContentLength();
            if(length == -1){
                var outStream = new ByteArrayOutputStream();
                stream.transferTo(outStream);
                return Memory.allocate(outStream.toByteArray());
            }else{
                var nativeBuffer = Memory.allocate(length);
                var buffer = new byte[1024 * 1024];
                int read;
                while((read = stream.read(buffer)) > 0){
                    nativeBuffer.put(buffer, 0, read);
                }
                return nativeBuffer.position(0);
            }
        }
    }
    
    /**
     * Get's an InputStream from a URL.
     *
     * @param url The URL.
     *
     * @return The InputStream.
     *
     * @throws java.io.IOException If an error occurred creating the stream.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static InputStream getInputStream(@Nonnull String url) throws IOException{
        var connection = new URL(url).openConnection();
        connection.setDoOutput(false);
        connection.setDoInput(true);
        return connection.getInputStream();
    }
}
