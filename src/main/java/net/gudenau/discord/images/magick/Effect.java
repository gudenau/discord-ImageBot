package net.gudenau.discord.images.magick;

import java.nio.DoubleBuffer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.Memory;
import net.gudenau.discord.images.internal.NativeString;

public final class Effect{
    @Nullable
    public static Image AdaptiveThresholdImage(@Nonnull Image image, long width, long height, double offset, @Nonnull ExceptionInfo exception){
        return Image.of(AdaptiveThresholdImage(image.getPointer(), width, height, offset, exception.getPointer()));
    }
    
    @Nullable
    public static Image AddNoiseImage(@Nonnull Image image, int noise_type, @Nonnull ExceptionInfo exception){
        return Image.of(AddNoiseImage(image.getPointer(), noise_type, exception.getPointer()));
    }
    
    @Nullable
    public static Image AddNoiseImageChannel(@Nonnull Image image, int channel, int noise_type, @Nonnull ExceptionInfo exception){
        return Image.of(AddNoiseImageChannel(image.getPointer(), channel, noise_type, exception.getPointer()));
    }
    
    @Nullable
    public static Image BlurImage(@Nonnull Image image, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(BlurImage(image.getPointer(), radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image BlurImageChannel(@Nonnull Image image, int channel, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(BlurImageChannel(image.getPointer(), channel, radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image ConvolveImage(@Nonnull Image image, int order, @Nonnull DoubleBuffer kernel, @Nonnull ExceptionInfo exception){
        return Image.of(ConvolveImage(image.getPointer(), order, Memory.getBufferPointer(kernel), exception.getPointer()));
    }
    
    @Nullable
    public static Image DespeckleImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(DespeckleImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image EdgeImage(@Nonnull Image image, double radius, @Nonnull ExceptionInfo exception){
        return Image.of(EdgeImage(image.getPointer(), radius, exception.getPointer()));
    }
    
    @Nullable
    public static Image EmbossImage(@Nonnull Image image, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(EmbossImage(image.getPointer(), radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image EnhanceImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(EnhanceImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image GaussianBlurImage(@Nonnull Image image, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(GaussianBlurImage(image.getPointer(), radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image GaussianBlurImageChannel(@Nonnull Image image, int channel, double radius,double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(GaussianBlurImageChannel(image.getPointer(), channel, radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image MedianFilterImage(@Nonnull Image image, double radius, @Nonnull ExceptionInfo exception){
        return Image.of(MedianFilterImage(image.getPointer(), radius, exception.getPointer()));
    }
    
    @Nullable
    public static Image MotionBlurImage(@Nonnull Image image, double radius, double sigma, double angle, @Nonnull ExceptionInfo exception){
        return Image.of(MotionBlurImage(image.getPointer(), radius, sigma, angle, exception.getPointer()));
    }
    
    @Nullable
    public static Image ReduceNoiseImage(@Nonnull Image image, double radius, @Nonnull ExceptionInfo exception){
        return Image.of(ReduceNoiseImage(image.getPointer(), radius, exception.getPointer()));
    }
    
    @Nullable
    public static Image ShadeImage(@Nonnull Image image, int gray, double azimuth, double elevation, @Nonnull ExceptionInfo exception){
        return Image.of(ShadeImage(image.getPointer(), gray, azimuth, elevation, exception.getPointer()));
    }
    
    @Nullable
    public static Image SharpenImage(@Nonnull Image image, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(SharpenImage(image.getPointer(), radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image SharpenImageChannel(@Nonnull Image image,int channel, double radius, double sigma, @Nonnull ExceptionInfo exception){
        return Image.of(SharpenImageChannel(image.getPointer(), channel, radius, sigma, exception.getPointer()));
    }
    
    @Nullable
    public static Image SpreadImage(@Nonnull Image image, int radius, @Nonnull ExceptionInfo exception){
        return Image.of(SpreadImage(image.getPointer(), radius, exception.getPointer()));
    }
    
    @Nullable
    public static Image UnsharpMaskImage(@Nonnull Image image, double radius, double sigma, double amount, double threshold, @Nonnull ExceptionInfo exception){
        return Image.of(UnsharpMaskImage(image.getPointer(), radius, sigma, amount, threshold, exception.getPointer()));
    }
    
    @Nullable
    public static Image UnsharpMaskImageChannel(@Nonnull Image image, int channel, double radius, double sigma, double amount, double threshold, @Nonnull ExceptionInfo exception){
        return Image.of(UnsharpMaskImageChannel(image.getPointer(), channel, radius, sigma, amount, threshold, exception.getPointer()));
    }
    
    public static boolean BlackThresholdImage(@Nonnull Image image, @Nonnull String thresholds){
        try(var nativeThreshold = NativeString.of(thresholds)){
            return BlackThresholdImage(image.getPointer(), nativeThreshold.getPointer()) != 0;
        }
    }
    
    public static boolean ChannelThresholdImage(@Nonnull Image image, @Nonnull String threshold){
        try(var nativeThreshold = NativeString.of(threshold)){
            return ChannelThresholdImage(image.getPointer(), nativeThreshold.getPointer()) != 0;
        }
    }
    
    public static boolean RandomChannelThresholdImage(@Nonnull Image image, @Nonnull String channel, @Nonnull String thresholds, @Nonnull ExceptionInfo exception){
        try(
            var nativeChannel = NativeString.of(channel);
            var nativeThresholds = NativeString.of(thresholds)
        ){
            return RandomChannelThresholdImage(image.getPointer(), nativeChannel.getPointer(), nativeThresholds.getPointer(), exception.getPointer()) != 0;
        }
    }
    
    public static boolean ThresholdImage(@Nonnull Image image, double threshold){
        return ThresholdImage(image.getPointer(), threshold) != 0;
    }
    
    public static boolean WhiteThresholdImage(@Nonnull Image image, @Nonnull String thresholds){
        try(var nativeThresholds = NativeString.of(thresholds)){
            return WhiteThresholdImage(image.getPointer(), nativeThresholds.getPointer()) != 0;
        }
    }
    
    private static native long AdaptiveThresholdImage(long image, long width, long height, double offset, long exception);
    private static native long AddNoiseImage(long image, int noise_type, long exception);
    private static native long AddNoiseImageChannel(long image, int channel, int noise_type, long exception);
    private static native long BlurImage(long image, double radius, double sigma, long exception);
    private static native long BlurImageChannel(long image, int channel, double radius, double sigma, long exception);
    private static native long ConvolveImage(long image, int order, long kernel, long exception);
    private static native long DespeckleImage(long image, long exception);
    private static native long EdgeImage(long image, double radius, long exception);
    private static native long EmbossImage(long image, double radius, double sigma, long exception);
    private static native long EnhanceImage(long image, long exception);
    private static native long GaussianBlurImage(long image, double radius, double sigma, long exception);
    private static native long GaussianBlurImageChannel(long image, int channel, double radius,double sigma, long exception);
    private static native long MedianFilterImage(long image, double radius, long exception);
    private static native long MotionBlurImage(long image, double radius, double sigma, double angle, long exception);
    private static native long ReduceNoiseImage(long image, double radius, long exception);
    private static native long ShadeImage(long image, int gray, double azimuth, double elevation, long exception);
    private static native long SharpenImage(long image, double radius, double sigma, long exception);
    private static native long SharpenImageChannel(long image,int channel, double radius, double sigma, long exception);
    private static native long SpreadImage(long image, int radius, long exception);
    private static native long UnsharpMaskImage(long image, double radius, double sigma, double amount, double threshold, long exception);
    private static native long UnsharpMaskImageChannel(long image, int channel, double radius, double sigma, double amount, double threshold, long exception);
    private static native int BlackThresholdImage(long image, long thresholds);
    private static native int ChannelThresholdImage(long image, long threshold);
    private static native int RandomChannelThresholdImage(long image, long channel, long thresholds, long exception);
    private static native int ThresholdImage(long image, double threshold);
    private static native int WhiteThresholdImage(long image, long thresholds);
}
