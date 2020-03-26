package net.gudenau.discord.images.magick;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.NativeString;

public final class Transform{
    @Nullable
    public static Image ChopImage(@Nonnull Image image, @Nonnull RectangleInfo chop_info, @Nonnull ExceptionInfo exception){
        return Image.of(ChopImage(image.getPointer(), chop_info.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image CoalesceImages(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(CoalesceImages(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image CropImage(@Nonnull Image image, @Nonnull RectangleInfo geometry, @Nonnull ExceptionInfo exception){
        return Image.of(CropImage(image.getPointer(), geometry.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image DeconstructImages(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(DeconstructImages(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image ExtentImage(@Nonnull Image image, @Nonnull RectangleInfo geometry, @Nonnull ExceptionInfo exception){
        return Image.of(ExtentImage(image.getPointer(), geometry.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image FlattenImages(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(FlattenImages(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image FlipImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(FlipImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image FlopImage(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(FlopImage(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image MosaicImages(@Nonnull Image image, @Nonnull ExceptionInfo exception){
        return Image.of(MosaicImages(image.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image RollImage(@Nonnull Image image, long x_offset, long y_offset, @Nonnull ExceptionInfo exception){
        return Image.of(RollImage(image.getPointer(), x_offset, y_offset, exception.getPointer()));
    }
    
    @Nullable
    public static Image ShaveImage(@Nonnull Image image, @Nonnull RectangleInfo shave_info, @Nonnull ExceptionInfo exception){
        return Image.of(ShaveImage(image.getPointer(), shave_info.getPointer(), exception.getPointer()));
    }
    
    @Nullable
    public static Image TransformImage(@Nonnull Image.Pointer image, String crop_geometry, String image_geometry){
        try(
            var nativeCrop_geometry = NativeString.of(crop_geometry);
            var nativeImage_geometry = NativeString.of(image_geometry)
        ){
            return Image.of(TransformImage(image.getPointer(), nativeCrop_geometry.getPointer(), nativeImage_geometry.getPointer()));
        }
    }
    
    private static native long ChopImage(long image, long chop_info, long exception);
    private static native long CoalesceImages(long image, long exception);
    private static native long CropImage(long image, long geometry, long exception);
    private static native long DeconstructImages(long image, long exception);
    private static native long ExtentImage(long image, long geometry, long exception);
    private static native long FlattenImages(long image, long exception);
    private static native long FlipImage(long image, long exception);
    private static native long FlopImage(long image, long exception);
    private static native long MosaicImages(long image, long exception);
    private static native long RollImage(long image, long x_offset, long y_offset, long exception);
    private static native long ShaveImage(long image, long shave_info, long exception);
    private static native long TransformImage(long image, long crop_geometry, long image_geometry);
}
