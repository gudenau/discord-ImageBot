package net.gudenau.discord.images.magick;

import javax.annotation.Nonnull;

public final class Composite{
    public static boolean CompositeImage(@Nonnull Image canvas_image, int compose, @Nonnull Image composite_image, long x_offset, long y_offset){
        return CompositeImage(canvas_image.getPointer(), compose, composite_image.getPointer(), x_offset, y_offset) != 0;
    }
    
    private static native int CompositeImage(long canvas_image, int compose, long composite_image, long x_offset, long y_offset);
}
