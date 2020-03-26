package net.gudenau.discord.images.magick;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Resize{
    @Nullable
    public static Image MagnifyImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(MagnifyImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image MinifyImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(MinifyImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image ResizeImage(@Nonnull Image image, long columns, long rows, int filter, double blur, @Nonnull ExceptionInfo exception){
        return Image.of(ResizeImage(image.getPointer(), columns, rows, filter, blur, exception.getPointer()));
    }
    
    @Nullable
    public static Image SampleImage(@Nonnull Image image, long columns, long rows, @Nonnull ExceptionInfo exception){
        return Image.of(SampleImage(image.getPointer(), columns, rows, exception.getPointer()));
    }
    
    @Nullable
    public static Image ScaleImage(@Nonnull Image image, long columns, long rows, @Nonnull ExceptionInfo exception){
        return Image.of(ScaleImage(image.getPointer(), columns, rows, exception.getPointer()));
    }
    
    @Nullable
    public static Image ThumbnailImage(@Nonnull Image image, long columns, long rows, @Nonnull ExceptionInfo exception){
        return Image.of(ThumbnailImage(image.getPointer(), columns, rows, exception.getPointer()));
    }
    
    private static native long MagnifyImage(long image, long exception);
    private static native long MinifyImage(long image, long exception);
    private static native long ResizeImage(long image, long columns, long rows, int filter, double blur, long exception);
    private static native long SampleImage(long image, long columns, long rows, long exception);
    private static native long ScaleImage(long image, long columns, long rows, long exception);
    private static native long ThumbnailImage(long image, long columns, long rows, long exception);
}
