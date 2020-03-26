extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Magick.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagick
    (jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagickEx
    (jlong, jint, jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Magick_InitializeMagick
(JNIEnv* env, jclass klass, jlong path){
    UNUSED(env);
    UNUSED(klass);    
    JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagick(path);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagick
(jlong path){
    InitializeMagick((const char*)path);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Magick_InitializeMagickEx
(JNIEnv* env, jclass klass, jlong path, jint options, jlong exception){
    UNUSED(env);
    UNUSED(klass);    
    return JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagickEx(path, options, exception);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Magick_InitializeMagickEx
(jlong path, jint options, jlong exception){
    return InitializeMagickEx((const char*)path, (unsigned int)options, (ExceptionInfo*)exception);
}
