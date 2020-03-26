package net.gudenau.discord.images.magick;

import java.nio.ByteBuffer;
import javax.annotation.Nonnull;
import net.gudenau.discord.images.internal.Memory;

import static net.gudenau.discord.images.internal.Memory.NULL;

public final class Blob{
    public static void AttachBlob(@Nonnull BlobInfo blob_info, @Nonnull ByteBuffer blob){
        AttachBlob(blob_info.getPointer(), Memory.getBufferPointer(blob), blob.remaining());
    }
    
    public static Image BlobToImage(@Nonnull ImageInfo image_info, @Nonnull ByteBuffer blob, @Nonnull ExceptionInfo exception){
        return Image.of(BlobToImage(image_info.getPointer(), Memory.getBufferPointer(blob), blob.remaining(), exception.getPointer()));
    }
    
    public static void DestroyBlob(@Nonnull Image image){
        DestroyBlob(image.getPointer());
    }
    
    @Deprecated
    public static void DestroyBlobInfo(@Nonnull BlobInfo blob_info){
        DestroyBlobInfo(blob_info.getPointer());
    }
    
    public static void GetBlobInfo(@Nonnull BlobInfo blob_info){
        GetBlobInfo(blob_info.getPointer());
    }
    
    public static ByteBuffer ImageToBlob(@Nonnull ImageInfo image_info, @Nonnull Image image, long length, @Nonnull ExceptionInfo exception){
        var buffer = Memory.allocate(Long.BYTES);
        try{
            buffer.putLong(0, length);
            long pointer = ImageToBlob(image_info.getPointer(), image.getPointer(), Memory.getBufferPointer(buffer), exception.getPointer());
            return pointer == NULL ? null : Memory.createBuffer(pointer, (int)buffer.getLong(0));
        }finally{
            Memory.free(buffer);
        }
    }
    
    private static native void AttachBlob(long blob_info, long blob, long length);
    private static native long BlobToImage(long image_info, long blob, long length, long exception);
    private static native void DestroyBlob(long image);
    private static native void DestroyBlobInfo(long blob);
    private static native void GetBlobInfo(long blob_info);
    private static native long ImageToBlob(long image_info, long image, long length, long exception);
}
