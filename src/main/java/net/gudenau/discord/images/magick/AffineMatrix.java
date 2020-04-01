package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeObject;

public final class AffineMatrix extends NativeObject{
    public AffineMatrix(){
        super(init(), AffineMatrix::free);
    }
    
    public double sx(){
        return sx(pointer);
    }
    
    public double rx(){
        return rx(pointer);
    }
    
    public double ry(){
        return ry(pointer);
    }
    
    public double sy(){
        return sy(pointer);
    }
    
    public double tx(){
        return tx(pointer);
    }
    
    public double ty(){
        return ty(pointer);
    }
    
    public void sx(double value){
        sx(pointer, value);
    }
    
    public void rx(double value){
        rx(pointer, value);
    }
    
    public void ry(double value){
        ry(pointer, value);
    }
    
    public void sy(double value){
        sy(pointer, value);
    }
    
    public void tx(double value){
        tx(pointer, value);
    }
    
    public void ty(double value){
        ty(pointer, value);
    }
    
    long getPointer(){
        return pointer;
    }
    
    private native static void free(long pointer);
    private native static long init();
    
    private static native double sx(long pointer);
    private static native double rx(long pointer);
    private static native double ry(long pointer);
    private static native double sy(long pointer);
    private static native double tx(long pointer);
    private static native double ty(long pointer);
    
    private static native void sx(long pointer, double value);
    private static native void rx(long pointer, double value);
    private static native void ry(long pointer, double value);
    private static native void sy(long pointer, double value);
    private static native void tx(long pointer, double value);
    private static native void ty(long pointer, double value);
}
