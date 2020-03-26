package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeString;

public final class Enhance{
    public static boolean ContrastImage(Image image, boolean sharpen){
        return ContrastImage(image.getPointer(), sharpen ? 1 : 0) != 0;
    }
    
    public static boolean EqualizeImage(Image image){
        return EqualizeImage(image.getPointer()) != 0;
    }
    
    public static boolean GammaImage(Image image, String level){
        try(var nativeLevel = NativeString.of(level)){
            return GammaImage(image.getPointer(), nativeLevel.getPointer()) != 0;
        }
    }
    
    public static boolean LevelImage(Image image, String level){
        try(var nativeLevel = NativeString.of(level)){
            return LevelImage(image.getPointer(), nativeLevel.getPointer()) != 0;
        }
    }
    
    public static boolean LevelImageChannel(Image image, int channel, double black_point, double mid_point, double white_point){
        return LevelImageChannel(image.getPointer(), channel, black_point, mid_point, white_point) != 0;
    }
    
    public static boolean ModulateImage(Image image, String modulate){
        try(var nativeModulate = NativeString.of(modulate)){
            return ModulateImage(image.getPointer(), nativeModulate.getPointer()) != 0;
        }
    }
    
    public static boolean NegateImage(Image image, boolean grayscale){
        return NegateImage(image.getPointer(), grayscale ? 1 : 0) != 0;
    }
    
    public static boolean NormalizeImage(Image image){
        return NormalizeImage(image.getPointer()) != 0;
    }
    
    private static native int ContrastImage(long image, int sharpen);
    private static native int EqualizeImage(long image);
    private static native int GammaImage(long image, long level);
    private static native int LevelImage(long image, long level);
    private static native int LevelImageChannel(long image, int channel, double black_point, double mid_point, double white_point);
    private static native int ModulateImage(long image, long modulate);
    private static native int NegateImage(long image, int grayscale);
    private static native int NormalizeImage(long image);
}
