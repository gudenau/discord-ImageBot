package net.gudenau.discord.images.magick;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.NativeObject;
import net.gudenau.discord.images.internal.NativeString;

import static net.gudenau.discord.images.internal.Memory.NULL;

public final class Image extends NativeObject{
    public static final int
        UndefinedFilter = 0,
        PointFilter = 1,
        BoxFilter = 2,
        TriangleFilter = 3,
        HermiteFilter = 4,
        HanningFilter = 5,
        HammingFilter = 6,
        BlackmanFilter = 7,
        GaussianFilter = 8,
        QuadraticFilter = 9,
        CubicFilter = 10,
        CatromFilter = 11,
        MitchellFilter = 12,
        LanczosFilter = 13,
        BesselFilter = 14,
        SincFilter = 15;
    
    public static final int
        UndefinedDispose = 0,
        NoneDispose = 1,
        BackgroundDispose = 2,
        PreviousDispose = 3;
    
    public static final int
        UndefinedCompositeOp = 0,
        OverCompositeOp = 1,
        InCompositeOp = 2,
        OutCompositeOp = 3,
        AtopCompositeOp = 4,
        XorCompositeOp = 5,
        PlusCompositeOp = 6,
        MinusCompositeOp = 7,
        AddCompositeOp = 8,
        SubtractCompositeOp = 9,
        DifferenceCompositeOp = 10,
        MultiplyCompositeOp = 11,
        BumpmapCompositeOp = 12,
        CopyCompositeOp = 13,
        CopyRedCompositeOp = 14,
        CopyGreenCompositeOp = 15,
        CopyBlueCompositeOp = 16,
        CopyOpacityCompositeOp = 17,
        ClearCompositeOp = 18,
        DissolveCompositeOp = 19,
        DisplaceCompositeOp = 20,
        ModulateCompositeOp = 21,
        ThresholdCompositeOp = 22,
        NoCompositeOp = 23,
        DarkenCompositeOp = 24,
        LightenCompositeOp = 25,
        HueCompositeOp = 26,
        SaturateCompositeOp = 27,
        ColorizeCompositeOp = 28,
        LuminizeCompositeOp = 29,
        ScreenCompositeOp = 30,
        OverlayCompositeOp = 31,
        CopyCyanCompositeOp = 32,
        CopyMagentaCompositeOp = 33,
        CopyYellowCompositeOp = 34,
        CopyBlackCompositeOp = 35,
        DivideCompositeOp = 36,
        HardLightCompositeOp = 37,
        ExclusionCompositeOp = 38,
        ColorDodgeCompositeOp = 39,
        ColorBurnCompositeOp = 40,
        SoftLightCompositeOp = 41,
        LinearBurnCompositeOp = 42,
        LinearDodgeCompositeOp = 43,
        LinearLightCompositeOp = 44,
        VividLightCompositeOp = 45,
        PinLightCompositeOp = 46,
        HardMixCompositeOp = 47;
    
    private int refCount = 0;
    
    private Image(long pointer){
        super(pointer);
    }
    
    @Nullable
    public static ImageInfo CloneImageInfo(@Nullable ImageInfo image_info){
        return ImageInfo.of(CloneImageInfo(image_info == null ? NULL : image_info.getPointer()));
    }
    
    public void client_data(ImageInfo imageInfo){
        client_data(pointer, imageInfo.getPointer());
    }
    
    @Nullable
    public ImageInfo client_data(){
        return ImageInfo.of(client_data(pointer));
    }
    
    public int columns(){
        return columns(pointer);
    }
    
    public PixelPacket background_color(){
        return new PixelPacket(background_color(pointer));
    }
    
    public void background_color(@Nonnull PixelPacket color){
        background_color(pointer, color.getPointer());
    }
    
    public void page(RectangleInfo value){
        page(pointer, value.getPointer());
    }
    
    public RectangleInfo page(){
        return new RectangleInfo(page(pointer));
    }
    
    public int dispose(){
        return dispose(pointer);
    }
    
    public void dispose(int value){
        dispose(pointer, value);
    }
    
    public long delay(){
        return delay0(pointer);
    }
    
    public void delay(long value){
        delay0(pointer, value);
    }
    
    public String magick(){
        return NativeString.toString(magick(pointer));
    }
    
    public void magick(String value){
        try(var nativeValue = NativeString.of(value)){
            magick(pointer, nativeValue.getPointer());
        }
    }
    
    public int rows(){
        return rows(pointer);
    }
    
    public long scene(){
        return scene0(pointer);
    }
    
    public void scene(long value){
        scene0(pointer, value);
    }
    
    private static native void client_data(long pointer, long client_data);
    private static native long client_data(long pointer);
    private static native int columns(long pointer);
    private static native void background_color(long pointer, long value);
    private static native long background_color(long pointer);
    private static native void page(long pointer, long value);
    private static native long page(long pointer);
    private static native int dispose(long pointer);
    private static native void dispose(long pointer, int value);
    private static native long delay0(long pointer);
    private static native void delay0(long pointer, long value);
    private static native long magick(long pointer);
    private static native void magick(long pointer, long value);
    private static native int rows(long pointer);
    private static native long scene0(long pointer);
    private static native void scene0(long pointer, long value);
    
    long getPointer(){
        return pointer;
    }
    
    public static void DestroyImage(@Nullable Image image){
        if(image == null){
            return;
        }
        DestroyImage(image.getPointer());
        image.refCount--;
        if(image.refCount == 0){
            allocatedImages.remove(image.getPointer());
        }
    }
    
    public static void DestroyImageInfo(@Nonnull ImageInfo image_info){
        DestroyImageInfo(image_info.getPointer());
    }
    
    private static final Map<Long, Image> allocatedImages = new HashMap<>();
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            if(allocatedImages.isEmpty()){
                System.out.println("No images leaked, good job!");
            }else{
                System.out.printf("%d images leaked\n", allocatedImages.size());
            }
        }));
    }
    
    @Nullable
    public static Image of(long pointer){
        if(pointer == NULL){
            return null;
        }
        Image image = allocatedImages.computeIfAbsent(pointer, Image::new);
        image.refCount++;
        return image;
    }
    
    @Nonnull
    public static Image ReferenceImage(@Nonnull Image image){
        ReferenceImage(image.getPointer());
        image.refCount++;
        return image;
    }
    
    private static native long CloneImageInfo(long image_info);
    private static native void DestroyImage(long image);
    private static native void DestroyImageInfo(long image_info);
    private static native long ReferenceImage(long image);
    
    public static class Pointer extends NativeObject.Pointer<Image>{
        public Pointer(){
            this(null);
        }
        
        public Pointer(@Nullable Image image){
            super(image, Image::new);
        }
    
        long getPointer(){
            return pointer;
        }
    }
}
