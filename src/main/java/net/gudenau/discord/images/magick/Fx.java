package net.gudenau.discord.images.magick;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.Memory;

public final class Fx{
    @Nullable
    public static Image CharcoalImage(@Nonnull Image image, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(CharcoalImage(image.getPointer(), radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image ColorizeImage(@Nonnull Image image, @Nonnull ByteBuffer opacity, @Nonnull PixelPacket target, @Nonnull ExceptionInfo exception){
        return Image.of(ColorizeImage(image.getPointer(), Memory.getBufferPointer(opacity), target.getPointer(), exception.getPointer()));
    }
    
    public static boolean ColorMatrixImage(@Nonnull Image image, int order, @Nonnull DoubleBuffer color_matrix){
        return ColorMatrixImage(image.getPointer(), order, Memory.getBufferPointer(color_matrix)) != 0;
    }
    
    @Nullable
    public static Image ImplodeImage(@Nonnull Image image, double amount, @Nonnull ExceptionInfo exception){
        return Image.of(ImplodeImage(image.getPointer(), amount, exception.getPointer()));
    }
    
    @Nullable
    public static Image MorphImages(@Nonnull Image image, long number_frames, @Nonnull ExceptionInfo exception){
        return Image.of(MorphImages(image.getPointer(), number_frames, exception.getPointer()));
    }
    
    @Nullable
    public static Image OilPaintImage(@Nonnull Image image, double radius, @Nonnull ExceptionInfo exception){
        return Image.of(OilPaintImage(image.getPointer(), radius, exception.getPointer()));
    }
    
    public static boolean SolarizeImage(@Nonnull Image image, double threshold){
        return SolarizeImage(image.getPointer(), threshold) != 0;
    }
    
    @Nullable
    public static Image SteganoImage(@Nonnull Image image, @Nonnull Image watermark, @Nonnull ExceptionInfo exception){
        return Image.of(SteganoImage(image.getPointer(), watermark.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image StereoImage(@Nonnull Image image, @Nonnull Image offset_image, @Nonnull ExceptionInfo exception){
        return Image.of(StereoImage(image.getPointer(), offset_image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image SwirlImage(@Nonnull Image image, double degrees, @Nonnull ExceptionInfo exception){
        return Image.of(SwirlImage(image.getPointer(), degrees, exception.getPointer()));
    }
    
    @Nullable
    public static Image WaveImage(@Nonnull Image image, double amplitude, double wave_length, @Nonnull ExceptionInfo exception){
        return Image.of(WaveImage(image.getPointer(), amplitude, wave_length, exception.getPointer()));
    }
    
    private static native long CharcoalImage(long image, double radius, double sigma, long exception);
    private static native long ColorizeImage(long image, long opacity, long target, long exception);
    private static native int ColorMatrixImage(long image, int order, long color_matrix);
    private static native long ImplodeImage(long image, double amount, long exception);
    private static native long MorphImages(long image, long number_frames, long exception);
    private static native long OilPaintImage(long image, double radius, long exception);
    private static native int SolarizeImage(long image, double threshold);
    private static native long SteganoImage(long image, long watermark, long exception);
    private static native long StereoImage(long image, long offset_image, long exception);
    private static native long SwirlImage(long image, double degrees, long exception);
    private static native long WaveImage(long image, double amplitude, double wave_length, long exception);
}
