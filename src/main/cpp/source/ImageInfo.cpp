extern "C"{
    #include <magick/api.h>
}

#include <cstdlib>

#include "net_gudenau_discord_images_magick_ImageInfo.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageInfo_adjoin
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageInfo_magick
    (jlong);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_ImageInfo_adjoin
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ImageInfo_adjoin(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageInfo_adjoin
(jlong pointer){
    return ((ImageInfo*)pointer)->adjoin;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ImageInfo_magick
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ImageInfo_magick(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageInfo_magick
(jlong pointer){
    return (jlong)((ImageInfo*)pointer)->magick;
}
