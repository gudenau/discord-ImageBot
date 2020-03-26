package net.gudenau.discord.images.internal;

import javax.annotation.Nonnull;
import sun.misc.Unsafe;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Memory junk, leverages Unsafe.
 * */
public class Memory{
    private static final Unsafe UNSAFE = getUnsafe();

    private static final Class<? extends ByteBuffer> DirectByteBuffer;

    private static final long Buffer_address;
    private static final long Buffer_capacity;
    private static final long Buffer_limit;

    public static final long NULL = 0L;

    static{
        var directBuffer = ByteBuffer.allocateDirect(1);
        DirectByteBuffer = directBuffer.getClass();
        UNSAFE.invokeCleaner(directBuffer);

        try{
            Buffer_address = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("address"));
            Buffer_capacity = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("capacity"));
            Buffer_limit = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("limit"));
        }catch(ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }

    private static Unsafe getUnsafe(){
        for(var field : Unsafe.class.getDeclaredFields()){
            if(field.getType() == Unsafe.class){
                try{
                    field.setAccessible(true);
                    return (Unsafe)field.get(null);
                }catch(ReflectiveOperationException e){
                    throw new RuntimeException("Failed to get Unsafe", e);
                }
            }
        }
        throw new RuntimeException("Failed to find Unsafe");
    }

    /**
     * Allocates a direct ByteBuffer and copies data into it.
     *
     * @param data The data to copy
     * @return The created buffer
     * */
    public static ByteBuffer allocate(@Nonnull byte[] data){
        var buffer = allocate(data.length);
        buffer.put(0, data);
        return buffer;
    }

    /**
     * Allocates a new direct ByteBuffer.
     *
     * @param size The size of the buffer
     * @return The new buffer
     * */
    @Nonnull
    public static ByteBuffer allocate(int size){
        return createBuffer(UNSAFE.allocateMemory(size), size);
    }

    /**
     * Creates a direct buffer from a pointer and size.
     *
     * @param pointer The pointer to the buffer's memory
     * @param size The size of the buffer
     * @return The created buffer
     * */
    @Nonnull
    public static ByteBuffer createBuffer(long pointer, int size){
        if(pointer == NULL){
            throw new RuntimeException("pointer was NULL");
        }
        
        ByteBuffer buffer;
        try{
            buffer = (ByteBuffer)UNSAFE.allocateInstance(DirectByteBuffer);
        }catch(InstantiationException e){
            throw new RuntimeException(e);
        }
        UNSAFE.putLong(buffer, Buffer_address, pointer);
        UNSAFE.putInt(buffer, Buffer_capacity, size);
        UNSAFE.putInt(buffer, Buffer_limit, size);
        return buffer.order(ByteOrder.nativeOrder());
    }

    /**
     * Gets the raw address of a direct buffer.
     *
     * @param buffer The direct buffer
     * @return The address
     * */
    public static long getBufferAddress(@Nonnull Buffer buffer){
        return UNSAFE.getLong(buffer, Buffer_address);
    }
    
    /**
     * Frees a direct buffer.
     *
     * @param buffer The direct buffer
     * */
    public static void free(@Nonnull Buffer buffer){
        UNSAFE.freeMemory(getBufferAddress(buffer));
    }
    
    /**
     * Gets the address of a direct buffer, accounting for it's position.
     *
     * @param buffer The direct buffer
     * @return The address
     * */
    public static long getBufferPointer(@Nonnull Buffer buffer){
        return getBufferAddress(buffer) + buffer.position();
    }
    
    /**
     * Gets a byte from native memory.
     *
     * @param pointer The address to read
     * @return The byte at the address
     * */
    public static byte getByte(long pointer){
        return UNSAFE.getByte(pointer);
    }
}
