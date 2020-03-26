package net.gudenau.discord.images.magick;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Shear{
    @Nullable
    public static Image AffineTransformImage(@Nonnull Image image, @Nonnull AffineMatrix affine, @Nonnull ExceptionInfo exception){
        return Image.of(AffineTransformImage(image.getPointer(), affine.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image AutoOrientImage(@Nonnull Image image, int current_orientation, @Nonnull ExceptionInfo exception){
        return Image.of(AutoOrientImage(image.getPointer(), current_orientation, exception.getPointer()));
    }
    
    @Nullable
    public static Image RotateImage(@Nonnull Image image, double degrees, @Nonnull ExceptionInfo exception){
        return Image.of(RotateImage(image.getPointer(), degrees, exception.getPointer()));
    }
    
    @Nullable
    public static Image ShearImage(@Nonnull Image image, double x_shear, double y_shear, @Nonnull ExceptionInfo exception){
        return Image.of(ShearImage(image.getPointer(), x_shear, y_shear, exception.getPointer()));
    }
    
    private static native long AffineTransformImage(long image, long affine, long exception);
    private static native long AutoOrientImage(long image, int current_orientation, long exception);
    private static native long RotateImage(long image, double degrees, long exception);
    private static native long ShearImage(long image, double x_shear, double y_shear, long exception);
}
