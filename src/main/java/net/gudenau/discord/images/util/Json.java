package net.gudenau.discord.images.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

/**
 * JSON reading and writing.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class Json{
    /**
     * The GSON instance.
     *
     * @since 1.0.0
     * */
    private static final Gson GSON = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    
    /**
     * Deserialize JSON from an input stream.
     *
     * @param input The input stream.
     * @param type The type of the JSON object.
     *
     * @return The read JSON object.
     *
     * @throws java.io.IOException If there was an error reading the stream.
     *
     * @since 1.0.0
     * */
    public static <T> T read(InputStream input, Class<T> type) throws IOException{
        try(var reader = new InputStreamReader(input)){
            return read(reader, type);
        }
    }
    
    /**
     * Deserialize JSON from a reader.
     *
     * @param reader The reader.
     * @param type The type of the JSON object.
     *
     * @return The read JSON object.
     *
     * @since 1.0.0
     * */
    public static <T> T read(Reader reader, Class<T> type){
        return GSON.fromJson(reader, type);
    }
    
    /**
     * Deserialize JSON from a reader.
     *
     * @param reader The reader.
     * @param type The type of the JSON object.
     *
     * @return The read JSON object.
     *
     * @since 1.0.0
     * */
    public static <T> T read(Reader reader, TypeToken<T> type){
        return GSON.fromJson(reader, type.getType());
    }
    
    /**
     * Serialize an Object to JSON.
     *
     * @param writer The writer.
     * @param object The object to write.
     *
     * @since 1.0.0
     * */
    public static void write(Writer writer, Object object){
        GSON.toJson(object, writer);
    }
    
    /**
     * Serialize an Object to JSON.
     *
     * @param object The object to write.
     *
     * @return The serialized object.
     *
     * @since 1.0.0
     * */
    public static String write(Object object){
        return GSON.toJson(object);
    }
}
