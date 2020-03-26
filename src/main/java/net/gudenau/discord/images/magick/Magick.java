package net.gudenau.discord.images.magick;

import static net.gudenau.discord.images.internal.Memory.NULL;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.NativeString;

public final class Magick{
    public static final int
        UniformNoise = 0,
        GaussianNoise = 1,
        MultiplicativeGaussianNoise = 2,
        ImpulseNoise = 3,
        LaplacianNoise = 4,
        PoissonNoise = 5,
        RandomNoise = 6,
        UndefinedNoise = 7;
    
    public static final int
        UndefinedChannel = 0,
        RedChannel = 1,
        CyanChannel = 2,
        GreenChannel = 3,
        MagentaChannel = 4,
        BlueChannel = 5,
        YellowChannel = 6,
        OpacityChannel = 7,
        BlackChannel = 8,
        MatteChannel = 9,
        AllChannels = 10,
        GrayChannel = 11;
    
    public static final int
        MAGICK_OPT_NO_SIGNAL_HANDER = 0x0001;
    
    public static final int
        UndefinedOrientation = 0,
        TopLeftOrientation = 1,
        TopRightOrientation = 2,
        BottomRightOrientation = 3,
        BottomLeftOrientation = 4,
        LeftTopOrientation = 5,
        RightTopOrientation = 6,
        RightBottomOrientation = 7,
        LeftBottomOrientation = 8;
    
    public static void InitializeMagick(@Nullable String path){
        if(path != null){
            try(var nativePath = NativeString.of(path)){
                InitializeMagick(nativePath.getPointer());
            }
        }else{
            InitializeMagick(NULL);
        }
    }
    
    public static boolean InitializeMagickEx(@Nullable String path, int options, @Nonnull ExceptionInfo exception){
        if(path != null){
            try(var nativePath = NativeString.of(path)){
                return InitializeMagickEx(nativePath.getPointer(), options, exception.getPointer()) != 0;
            }
        }else{
            return InitializeMagickEx(NULL, options, exception.getPointer()) != 0;
        }
    }
    
    private static native void InitializeMagick(long path);
    private static native int InitializeMagickEx(long path, int options, long exception);
}
