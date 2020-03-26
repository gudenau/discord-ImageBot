package net.gudenau.discord.images.internal;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static net.gudenau.discord.images.internal.Memory.NULL;

public class NativeString implements AutoCloseable{
    private final ByteBuffer buffer;
    private final long pointer;

    private NativeString(@Nonnull ByteBuffer buffer){
        this.pointer = Memory.getBufferAddress(buffer);
        this.buffer = buffer;
    }
    
    private NativeString(long pointer){
        this.pointer = pointer;
        this.buffer = null;
    }
    
    @Override
    public void close(){
        if(buffer != null){
            Memory.free(buffer);
        }
    }
    
    @Nullable
    public static NativeString of(@Nullable String value){
        return value == null ? null : new NativeString(Memory.allocate((value + "\u0000").getBytes(StandardCharsets.UTF_8)));
    }
    
    @Nullable
    public static NativeString of(long pointer){
        return pointer == NULL ? null : new NativeString(pointer);
    }

    public long getPointer(){
        return pointer;
    }
    
    @Override
    public String toString(){
        var stream = new ByteArrayOutputStream();
        if(buffer != null){
            buffer.position(0);
            byte value;
            while(buffer.hasRemaining() && (value = buffer.get()) != 0){
                stream.write(value);
            }
            buffer.position(0);
        }else{
            long pointer = this.pointer;
            byte character;
            while((character = Memory.getByte(pointer++)) != 0){
                stream.write(character);
            }
        }
        return new String(stream.toByteArray(), StandardCharsets.UTF_8);
    }
    
    @Nullable
    @SuppressWarnings("ConstantConditions")
    public static String toString(long pointer){
        return pointer == NULL ? null : of(pointer).toString();
    }
}
