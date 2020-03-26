extern "C"{
    #include <magick/api.h>
}

#include <cstdlib>

#include "net_gudenau_discord_images_magick_PixelPacket.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_free
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_init
    (void);
    JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__J
    (jlong);
    JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__J
    (jlong);
    JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__J
    (jlong);
    JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__JB
    (jlong, jbyte);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__JB
    (jlong, jbyte);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__JB
    (jlong, jbyte);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__JB
    (jlong, jbyte);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_free
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_PixelPacket_free(pointer);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_free
(jlong pointer){
    free((void*)pointer);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_init
(JNIEnv* env, jclass klass){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelPacket_init();
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_init
(void){
    return (jlong)(malloc(sizeof(PixelPacket)));
}

JNIEXPORT jbyte JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_red__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__J(pointer);
}
JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__J
(jlong pointer){
    return ((PixelPacket*)pointer)->red;
}

JNIEXPORT jbyte JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_green__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__J(pointer);
}
JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__J
(jlong pointer){
    return ((PixelPacket*)pointer)->green;
}

JNIEXPORT jbyte JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_blue__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__J(pointer);
}
JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__J
(jlong pointer){
    return ((PixelPacket*)pointer)->blue;
}

JNIEXPORT jbyte JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_opacity__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__J(pointer);
}
JNIEXPORT jbyte JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__J
(jlong pointer){
    return ((PixelPacket*)pointer)->opacity;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_red__JB
(JNIEnv* env, jclass klass, jlong pointer, jbyte value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__JB(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_red__JB
(jlong pointer, jbyte value){
    ((PixelPacket*)pointer)->red = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_green__JB
(JNIEnv* env, jclass klass, jlong pointer, jbyte value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__JB(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_green__JB
(jlong pointer, jbyte value){
    ((PixelPacket*)pointer)->green = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_blue__JB
(JNIEnv* env, jclass klass, jlong pointer, jbyte value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__JB(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_blue__JB
(jlong pointer, jbyte value){
    ((PixelPacket*)pointer)->blue = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_PixelPacket_opacity__JB
(JNIEnv* env, jclass klass, jlong pointer, jbyte value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__JB(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_PixelPacket_opacity__JB
(jlong pointer, jbyte value){
    ((PixelPacket*)pointer)->opacity = value;
}
