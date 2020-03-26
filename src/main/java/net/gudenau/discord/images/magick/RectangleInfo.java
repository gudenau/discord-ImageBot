package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeObject;

public class RectangleInfo extends NativeObject{
    public RectangleInfo(){
        super(init(), RectangleInfo::free);
    }
    
    RectangleInfo(long pointer){
        super(pointer);
    }
    
    public long width(){
        return width0(pointer);
    }
    
    public long height(){
        return height0(pointer);
    }
    
    public long x(){
        return x0(pointer);
    }
    
    public long y(){
        return y0(pointer);
    }
    
    public void width(long value){
        width0(pointer, value);
    }
    
    public void height(long value){
        height0(pointer, value);
    }
    
    public void x(long value){
        x0(pointer, value);
    }
    
    public void y(long value){
        y0(pointer, value);
    }
    
    long getPointer(){
        return pointer;
    }
    
    private static native void free(long pointer);
    private static native long init();
    
    private static native long width0(long pointer);
    private static native long height0(long pointer);
    private static native long x0(long pointer);
    private static native long y0(long pointer);
    
    private static native void width0(long pointer, long value);
    private static native void height0(long pointer, long value);
    private static native void x0(long pointer, long value);
    private static native void y0(long pointer, long value);
}
