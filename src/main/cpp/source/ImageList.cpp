extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_ImageList.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_AppendImageToList
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_GetImageListLength
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_GetNextImageInList
    (jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_ImageList_AppendImageToList
(JNIEnv* env, jclass klass, jlong images, jlong image){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ImageList_AppendImageToList(images, image);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_AppendImageToList
(jlong images, jlong image){
    AppendImageToList((Image**)images, (Image*)image);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ImageList_GetImageListLength
(JNIEnv* env, jclass klass, jlong images){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ImageList_GetImageListLength(images);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_GetImageListLength
(jlong images){
    return GetImageListLength((Image*)images);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ImageList_GetNextImageInList
(JNIEnv* env, jclass klass, jlong images){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ImageList_GetNextImageInList(images);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ImageList_GetNextImageInList
(jlong images){
    return (jlong)(GetNextImageInList((Image*)images));
}

