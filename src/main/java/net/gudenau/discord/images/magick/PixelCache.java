package net.gudenau.discord.images.magick;

import java.nio.ByteBuffer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.Memory;

public final class PixelCache{
    @Nullable
    public static ByteBuffer AcquireImagePixels(@Nonnull Image image, long x, long y, long columns, long rows, @Nonnull ExceptionInfo exception){
        long result = AcquireImagePixels(image.getPointer(), x, y, columns, rows, exception.getPointer());
        if(result == 0L){
            return null;
        }
        return Memory.createBuffer(result, (int)(columns * rows * 4 * 2)).asReadOnlyBuffer();
    }
    
    private static native long AcquireImagePixels(long image, long x, long y, long columns, long rows, long exception);
}
