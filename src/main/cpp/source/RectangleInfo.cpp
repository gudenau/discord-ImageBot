extern "C"{
    #include <magick/api.h>
}

#include <cstdlib>

#include "net_gudenau_discord_images_magick_RectangleInfo.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_free
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_init
    (void);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__J
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__J
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__J
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__JJ
    (jlong, jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__JJ
    (jlong, jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__JJ
    (jlong, jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__JJ
    (jlong, jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_free
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_free(pointer);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_free
(jlong pointer){
    free((void*)pointer);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_init
(JNIEnv* env, jclass klass){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_init();
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_init
(void){
    return (jlong)malloc(sizeof(RectangleInfo));
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_width0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__J
(jlong pointer){
    return ((RectangleInfo*)pointer)->width;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_height0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__J
(jlong pointer){
    return ((RectangleInfo*)pointer)->height;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_x0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__J
(jlong pointer){
    return ((RectangleInfo*)pointer)->x;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_y0__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__J(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__J
(jlong pointer){
    return ((RectangleInfo*)pointer)->y;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_width0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_width0__JJ
(jlong pointer, jlong value){
    ((RectangleInfo*)pointer)->width = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_height0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_height0__JJ
(jlong pointer, jlong value){
    ((RectangleInfo*)pointer)->height = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_x0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_x0__JJ
(jlong pointer, jlong value){
    ((RectangleInfo*)pointer)->x = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_RectangleInfo_y0__JJ
(JNIEnv* env, jclass klass, jlong pointer, jlong value){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__JJ(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_RectangleInfo_y0__JJ
(jlong pointer, jlong value){
    ((RectangleInfo*)pointer)->y = value;
}
