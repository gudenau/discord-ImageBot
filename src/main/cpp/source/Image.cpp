extern "C"{
    #include <magick/api.h>
}

#include <cstring>

#include "net_gudenau_discord_images_magick_Image.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__JJ
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__J
    (jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_columns
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__JJ
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_page__JJ
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_page__J
    (jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_dispose__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_dispose__JI
    (jlong, jint);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_delay0__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_delay0__JJ
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_magick__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_magick__JJ
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_rows
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_scene0__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_scene0__JJ
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_CloneImageInfo
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImage
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImageInfo
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_ReferenceImage
    (jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_client_1data__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong client_data){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__JJ(pointer, client_data);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__JJ
(jlong pointer, jlong client_data){
    ((Image*)pointer)->client_data = (void*)client_data;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_client_1data__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_client_1data__J
(jlong pointer){
    return (jlong)((Image*)pointer)->client_data;
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Image_columns
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_columns(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_columns
(jlong pointer){
    return ((Image*)pointer)->columns;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_background_1color__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__JJ
(jlong pointer, jlong value){
    memcpy(&(((Image*)pointer)->background_color), (PixelPacket*)value, sizeof(PixelPacket));
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_background_1color__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_background_1color__J
(jlong pointer){
    return (jlong)(&(((Image*)pointer)->background_color));
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_page__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_page__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_page__JJ
(jlong pointer, jlong value){
    memcpy(&(((Image*)pointer)->page), (RectangleInfo*)value, sizeof(RectangleInfo));
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_page__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_page__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_page__J
(jlong pointer){
    return (jlong)(&(((Image*)pointer)->page));
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Image_dispose__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_dispose__J(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_dispose__J
(jlong pointer){
    return (jint)(((Image*)pointer)->dispose);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_dispose__JI
(JNIEnv* env, jclass klass, jlong pointer, jint value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_dispose__JI(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_dispose__JI
(jlong pointer, jint value){
    ((Image*)pointer)->dispose = (DisposeType)value;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_delay0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_delay0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_delay0__J
(jlong pointer){
    return ((Image*)pointer)->delay;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_delay0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong delay){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_delay0__JJ(pointer, delay);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_delay0__JJ
(jlong pointer, jlong delay){
    ((Image*)pointer)->delay = delay;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_magick__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_magick__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_magick__J
(jlong pointer){
    return (jlong)((Image*)pointer)->magick;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_magick__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong magick){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_magick__JJ(pointer, magick);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_magick__JJ
(jlong pointer, jlong magick){
    strncpy(((Image*)pointer)->magick, (const char*)magick, MaxTextExtent);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Image_rows
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_rows(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_rows
(jlong pointer){
    return ((Image*)pointer)->rows;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_scene0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_scene0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_scene0__J
(jlong pointer){
    return ((Image*)pointer)->scene;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_scene0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_scene0__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_scene0__JJ
(jlong pointer, jlong value){
    ((Image*)pointer)->scene = value;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_CloneImageInfo
(JNIEnv* env, jclass klass, jlong image_info){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_CloneImageInfo(image_info);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_CloneImageInfo
(jlong image_info){
    return (jlong)CloneImageInfo((const ImageInfo*)image_info);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_DestroyImage
(JNIEnv* env, jclass klass, jlong image){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImage(image);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImage
(jlong image){
    DestroyImage((Image*)image);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Image_DestroyImageInfo
(JNIEnv* env, jclass klass, jlong image_info){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImageInfo(image_info);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_DestroyImageInfo
(jlong image_info){
    DestroyImageInfo((ImageInfo*)image_info);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Image_ReferenceImage
(JNIEnv* env, jclass klass, jlong image){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Image_ReferenceImage(image);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Image_ReferenceImage
(jlong image){
    return (jlong)ReferenceImage((Image*)image);
}
