package net.gudenau.discord.images.magick;

import net.gudenau.discord.images.internal.NativeObject;

public final class BlobInfo extends NativeObject{
    BlobInfo(long pointer){
        super(pointer);
    }
    
    long getPointer(){
        return pointer;
    }
}
