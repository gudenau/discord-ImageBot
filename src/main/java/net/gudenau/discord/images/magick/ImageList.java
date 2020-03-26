package net.gudenau.discord.images.magick;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ImageList{
    public static void AppendImageToList(@Nonnull Image.Pointer images, @Nonnull Image image){
        AppendImageToList(images.getPointer(), image.getPointer());
    }
    
    public static long GetImageListLength(@Nonnull Image images){
        return GetImageListLength(images.getPointer());
    }
    
    @Nullable
    public static Image GetNextImageInList(@Nonnull Image image){
        return Image.of(GetNextImageInList(image.getPointer()));
    }
    
    private static native void AppendImageToList(long images, long image);
    private static native long GetImageListLength(long images);
    private static native long GetNextImageInList(long images);
}
