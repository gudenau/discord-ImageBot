extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_PixelCache.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelCache_AcquireImagePixels
    (jlong, jlong, jlong, jlong, jlong, jlong);    
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_PixelCache_AcquireImagePixels
(JNIEnv* env, jclass klass, jlong image, jlong x, jlong y, jlong columns, jlong rows, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelCache_AcquireImagePixels(image, x, y, columns, rows, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelCache_AcquireImagePixels
(jlong image, jlong x, jlong y, jlong columns, jlong rows, jlong exception){
    return (jlong)AcquireImagePixels((const Image*)image, (const long)x, (const long)y, (const unsigned long)columns, (const unsigned long)rows, (ExceptionInfo*)exception);
}

