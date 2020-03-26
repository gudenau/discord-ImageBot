extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Constitute.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Constitute_ConstituteImage
    (jlong width, jlong height, jlong map, jint type, jlong pixels, jlong exception);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Constitute_DispatchImage
    (jlong image, jlong xOffset, jlong yOffset, jlong columns, jlong rows, jlong map, jint type, jlong pixels, jlong exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Constitute_ConstituteImage
(JNIEnv* env, jclass klass, jlong width, jlong height, jlong map, jint type, jlong pixels, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Constitute_ConstituteImage(width, height, map, type, pixels, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Constitute_ConstituteImage
(jlong width, jlong height, jlong map, jint type, jlong pixels, jlong exception){
    return (jlong)ConstituteImage(width, height, (const char*)map, (StorageType)type, (const void*)pixels, (ExceptionInfo*)exception);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Constitute_DispatchImage
(JNIEnv* env, jclass klass, jlong image, jlong xOffset, jlong yOffset, jlong columns, jlong rows, jlong map, jint type, jlong pixels, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Constitute_DispatchImage(image, xOffset, yOffset, columns, rows, map, type, pixels, exception);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Constitute_DispatchImage
(jlong image, jlong xOffset, jlong yOffset, jlong columns, jlong rows, jlong map, jint type, jlong pixels, jlong exception){
    return DispatchImage((const Image*)image, xOffset, yOffset, columns, rows, (const char*)map, (StorageType)type, (void*)pixels, (ExceptionInfo*)exception);
}
