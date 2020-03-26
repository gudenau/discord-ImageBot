package net.gudenau.discord.images.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.magick.Blob;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.internal.Memory;

/**
 * Utils related to images.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class ImageUtil{
    /**
     * Downloads an image so that Graphics Magick can manipulate it.
     *
     * @param url The url to download.
     *
     * @return The image or null if there was an error.
     *
     * @since 1.0.0
     * */
    @Nullable
    public static Image downloadImage(@Nonnull String url){
        try{
            return downloadImage(new URL(url));
        }catch(MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Downloads an image so that Graphics Magick can manipulate it.
     *
     * @param url The url to download.
     *
     * @return The image or null if there was an error.
     *
     * @since 1.0.0
     * */
    @Nullable
    public static Image downloadImage(@Nonnull URL url){
        ByteBuffer buffer = null;
        try(var exception = new ExceptionInfo()){
            buffer = NetworkUtil.downloadToMemory(url);
            var imageInfo = Image.CloneImageInfo(null);
            var image = Blob.BlobToImage(imageInfo, buffer, exception);
            image.client_data(imageInfo);
            return image;
        }catch(Throwable t){
            t.printStackTrace();
            return null;
        }finally{
            if(buffer != null){
                Memory.free(buffer);
            }
        }
    }
    
    /**
     * Loads an image from disk.
     *
     * @param path The path the image is at.
     *
     * @return The loaded image.
     * */
    @Nullable
    public static Image loadImage(Path path){
        try(var stream = Files.newInputStream(path)){
            var buffer = Memory.allocate((int)Files.size(path));
            {
                byte[] temp = new byte[1024 * 1024];
                int read;
                while((read = stream.read(temp)) > 0){
                    buffer.put(temp, 0, read);
                }
                buffer.position(0);
            }
            try(var exception = new ExceptionInfo()){
                var imageInfo = Image.CloneImageInfo(null);
                var image = Blob.BlobToImage(imageInfo, buffer, exception);
                image.client_data(imageInfo);
                return image;
            }finally{
                Memory.free(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Writes an image to a byte array.
     *
     * @param image The image to write.
     *
     * @return The byte array of the image.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static byte[] writeImage(@Nonnull Image image){
        try(var exception = new ExceptionInfo()){
            var imageInfo = image.client_data();
            if(imageInfo == null){
                imageInfo = Image.CloneImageInfo(null);
            }
            var blob = Blob.ImageToBlob(imageInfo, image, 0, exception);
            byte[] buffer = new byte[blob.capacity()];
            blob.get(0, buffer);
            Image.DestroyImageInfo(imageInfo);
            return buffer;
        }
    }
    
    /**
     * Writes an image to a file on disk.
     *
     * Useful for debugging.
     *
     * @param image The image to write.
     * @param path The path to save the image at.
     *
     * @since 1.0.0
     * */
    public static void writeImage(@Nonnull Image image, @Nonnull Path path){
        try(
            var exception = new ExceptionInfo();
            var stream = Files.newOutputStream(path)
        ){
            var blob = Blob.ImageToBlob(image.client_data(), image, 0, exception);
            byte[] buffer = new byte[blob.capacity()];
            blob.get(0, buffer);
            stream.write(buffer);
        }catch(IOException e){
            throw new RuntimeException("Failed to save image", e);
        }
    }
}
