package net.gudenau.discord.images.magick;

import java.nio.ByteBuffer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.Memory;
import net.gudenau.discord.images.internal.NativeString;

public final class Constitute{
    @Nullable
    public static Image ConstituteImage(long width, long height, String map, int type, @Nonnull ByteBuffer pixels, @Nonnull ExceptionInfo exception){
        try(var nativeMap = NativeString.of(map)){
            return Image.of(ConstituteImage(width, height, nativeMap.getPointer(), type, Memory.getBufferPointer(pixels), exception.getPointer()));
        }
    }
    
    public static int DispatchImage(@Nonnull Image image, long xOffset, long yOffset, long columns, long rows, @Nonnull String map, int type, @Nonnull ByteBuffer pixels, @Nonnull ExceptionInfo exception){
        try(var nativeMap = NativeString.of(map)){
            return DispatchImage(image.getPointer(), xOffset, yOffset, columns, rows, nativeMap.getPointer(), type, Memory.getBufferPointer(pixels), exception.getPointer());
        }
    }
    
    private static native long ConstituteImage(long width, long height, long map, int type, long pixels, long exception);
    private static native int DispatchImage(long image, long xOffset, long yOffset, long columns, long rows, long map, int type, long pixels, long exception);
}
