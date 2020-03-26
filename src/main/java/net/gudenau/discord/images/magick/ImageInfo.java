package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeObject;
import net.gudenau.discord.images.internal.NativeString;

import static net.gudenau.discord.images.internal.Memory.NULL;

public final class ImageInfo extends NativeObject{
    ImageInfo(long pointer){
        super(pointer);
    }
    
    public boolean adjoin(){
        return adjoin(pointer) != 0;
    }
    
    public String magick(){
        return NativeString.toString(magick(pointer));
    }
    
    private static native int adjoin(long pointer);
    private static native long magick(long pointer);
    
    long getPointer(){
        return pointer;
    }
    
    static ImageInfo of(long pointer){
        return pointer == NULL ? null : new ImageInfo(pointer);
    }
}
