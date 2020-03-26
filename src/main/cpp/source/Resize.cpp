extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Resize.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_MagnifyImage
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_MinifyImage
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ResizeImage
    (jlong, jlong, jlong, jint, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_SampleImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ScaleImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ThumbnailImage
    (jlong, jlong, jlong, jlong);
}


JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_MagnifyImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_MagnifyImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_MagnifyImage
(jlong image, jlong exception){
    return (jlong)MagnifyImage((Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_MinifyImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_MinifyImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_MinifyImage
(jlong image, jlong exception){
    return (jlong)MinifyImage((Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_ResizeImage
(JNIEnv* env, jclass klass, jlong image, jlong columns, jlong rows, jint filter, jdouble blur, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_ResizeImage(image, columns, rows, filter, blur, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ResizeImage
(jlong image, jlong columns, jlong rows, jint filter, jdouble blur, jlong exception){
    return (jlong)ResizeImage((Image*)image, columns, rows, (const FilterTypes)filter, blur, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_SampleImage
(JNIEnv* env, jclass klass, jlong image, jlong columns, jlong rows, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_SampleImage(image, columns, rows, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_SampleImage
(jlong image, jlong columns, jlong rows, jlong exception){
    return (jlong)SampleImage((Image*)image, columns, rows, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_ScaleImage
(JNIEnv* env, jclass klass, jlong image, jlong columns, jlong rows, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_ScaleImage(image, columns, rows, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ScaleImage
(jlong image, jlong columns, jlong rows, jlong exception){
    return (jlong)ScaleImage((Image*)image, columns, rows, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Resize_ThumbnailImage
(JNIEnv* env, jclass klass, jlong image, jlong columns, jlong rows, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Resize_ThumbnailImage(image, columns, rows, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Resize_ThumbnailImage
(jlong image, jlong columns, jlong rows, jlong exception){
    return (jlong)ThumbnailImage((Image*)image, columns, rows, (ExceptionInfo*)exception);
}