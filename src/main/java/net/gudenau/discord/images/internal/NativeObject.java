package net.gudenau.discord.images.internal;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;

import static net.gudenau.discord.images.internal.Memory.NULL;

public abstract class NativeObject implements AutoCloseable{
    protected final long pointer;
    private final Consumer<Long> cleaner;
    protected final AtomicBoolean cleaned = new AtomicBoolean(false);

    protected NativeObject(long pointer){
        this(pointer, null);
    }
    
    protected NativeObject(long pointer, @Nullable Consumer<Long> cleaner){
        if(pointer == NULL){
            throw new IllegalArgumentException("pointer was NULL");
        }
        this.pointer = pointer;
        this.cleaner = cleaner;
        if(cleaner == null){
            cleaned.set(true);
        }
    }

    @Override
    public void close(){
        if(!cleaned.getAndSet(true)){
            cleaner.accept(pointer);
        }
    }
    
    public static class Buffer<T extends java.nio.Buffer> extends NativeObject{
        protected final T buffer;
        private final Consumer<T> cleaner;
    
        protected Buffer(T buffer, @Nullable Consumer<T> cleaner){
            super(Memory.getBufferAddress(buffer));
            this.buffer = buffer;
            this.cleaner = cleaner;
        }
    
        @Override
        public void close(){
            if(!cleaned.getAndSet(true)){
                cleaner.accept(buffer);
            }
        }
    }
    
    public static class Pointer<T extends NativeObject> extends Buffer<ByteBuffer>{
        private final Function<Long, T> factory;
    
        protected Pointer(T initial, Function<Long, T> factory){
            super(Memory.allocate(Long.BYTES), Memory::free);
            this.factory = factory;
            setValue(initial);
        }
        
        public T getValue(){
            return factory.apply(buffer.getLong(0));
        }
        
        public void setValue(@Nullable T value){
            buffer.putLong(0, value == null ? NULL : value.pointer);
        }
    }
}
