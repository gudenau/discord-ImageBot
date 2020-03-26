package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeObject;

public final class PixelPacket extends NativeObject{
    public PixelPacket(){
        super(init(), PixelPacket::free);
    }
    
    PixelPacket(long pointer){
        super(pointer);
    }
    
    public byte red(){
        return red(pointer);
    }
    
    public byte green(){
        return green(pointer);
    }
    
    public byte blue(){
        return blue(pointer);
    }
    
    public byte opacity(){
        return opacity(pointer);
    }
    
    public void red(byte value){
        red(pointer, value);
    }
    
    public void green(byte value){
        green(pointer, value);
    }
    
    public void blue(byte value){
        blue(pointer, value);
    }
    
    public void opacity(byte value){
        opacity(pointer, value);
    }
    
    long getPointer(){
        return pointer;
    }
    
    private static native void free(long pointer);
    private static native long init();
    
    private static native byte red(long pointer);
    private static native byte green(long pointer);
    private static native byte blue(long pointer);
    private static native byte opacity(long pointer);
    
    private static native void red(long pointer, byte value);
    private static native void green(long pointer, byte value);
    private static native void blue(long pointer, byte value);
    private static native void opacity(long pointer, byte value);
}
