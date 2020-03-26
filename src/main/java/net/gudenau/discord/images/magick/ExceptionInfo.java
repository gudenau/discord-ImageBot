package net.gudenau.discord.images.magick;

import javax.annotation.Nullable;
import net.gudenau.discord.images.internal.NativeObject;
import net.gudenau.discord.images.internal.NativeString;

public final class ExceptionInfo extends NativeObject{
    public static final int
        UndefinedException = 0,
        WarningException = 300,
        ResourceLimitWarning = 300,
        TypeWarning = 305,
        OptionWarning = 310,
        DelegateWarning = 315,
        MissingDelegateWarning = 320,
        CorruptImageWarning = 325,
        FileOpenWarning = 330,
        BlobWarning = 335,
        StreamWarning = 340,
        CacheWarning = 345,
        CoderWarning = 350,
        ModuleWarning = 355,
        DrawWarning = 360,
        ImageWarning = 365,
        XServerWarning = 380,
        MonitorWarning = 385,
        RegistryWarning = 390,
        ConfigureWarning = 395,
        ErrorException = 400,
        ResourceLimitError = 400,
        TypeError = 405,
        OptionError = 410,
        DelegateError = 415,
        MissingDelegateError = 420,
        CorruptImageError = 425,
        FileOpenError = 430,
        BlobError = 435,
        StreamError = 440,
        CacheError = 445,
        CoderError = 450,
        ModuleError = 455,
        DrawError = 460,
        ImageError = 465,
        XServerError = 480,
        MonitorError = 485,
        RegistryError = 490,
        ConfigureError = 495,
        FatalErrorException = 700,
        ResourceLimitFatalError = 700,
        TypeFatalError = 705,
        OptionFatalError = 710,
        DelegateFatalError = 715,
        MissingDelegateFatalError = 720,
        CorruptImageFatalError = 725,
        FileOpenFatalError = 730,
        BlobFatalError = 735,
        StreamFatalError = 740,
        CacheFatalError = 745,
        CoderFatalError = 750,
        ModuleFatalError = 755,
        DrawFatalError = 760,
        ImageFatalError = 765,
        XServerFatalError = 780,
        MonitorFatalError = 785,
        RegistryFatalError = 790,
        ConfigureFatalError = 795;
    
    public ExceptionInfo(){
        super(init(), ExceptionInfo::free);
    }
    
    @Nullable
    public String reason(){
        return NativeString.toString(reason(pointer));
    }
    
    @Nullable
    public String description(){
        return NativeString.toString(description(pointer));
    }
    
    public int severity(){
        return severity(pointer);
    }
    
    public long signature(){
        return signature(pointer);
    }
    
    public int error_number(){
        return error_number(pointer);
    }
    
    public String module(){
        return NativeString.toString(module(pointer));
    }
    
    public String function(){
        return NativeString.toString(function(pointer));
    }
    
    public long line(){
        return line(pointer);
    }
    
    long getPointer(){
        return pointer;
    }
    
    private static native void free(long pointer);
    private static native long init();
    
    private static native int severity(long pointer);
    private static native long reason(long pointer);
    private static native long description(long pointer);
    private static native int error_number(long pointer);
    private static native long module(long pointer);
    private static native long function(long pointer);
    private static native long line(long pointer);
    private static native long signature(long pointer);
}
