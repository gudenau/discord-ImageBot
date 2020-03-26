extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Enhance.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_ContrastImage
    (jlong, jint);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_EqualizeImage
    (jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_GammaImage
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImage
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImageChannel
    (jlong, jint, jdouble, jdouble, jdouble);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_ModulateImage
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_NegateImage
    (jlong, jint);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_NormalizeImage
    (jlong);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_ContrastImage
(JNIEnv* env, jclass klass, jlong image, jint sharpen){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_ContrastImage(image, sharpen);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_ContrastImage
(jlong image, jint sharpen){
    return ContrastImage((Image*)image, (const unsigned int)sharpen);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_EqualizeImage
(JNIEnv* env, jclass klass, jlong image){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_EqualizeImage(image);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_EqualizeImage
(jlong image){
    return EqualizeImage((Image*)image);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_GammaImage
(JNIEnv* env, jclass klass, jlong image, jlong level){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_GammaImage(image, level);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_GammaImage
(jlong image, jlong level){
    return GammaImage((Image*)image, (const char*)level);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_LevelImage
(JNIEnv* env, jclass klass, jlong image, jlong level){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImage(image, level);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImage
(jlong image, jlong level){
    return LevelImage((Image*)image, (const char*)level);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_LevelImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jdouble black_point, jdouble mid_point, jdouble white_point){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImageChannel(image, channel, black_point, mid_point, white_point);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_LevelImageChannel
(jlong image, jint channel, jdouble black_point, jdouble mid_point, jdouble white_point){
    return LevelImageChannel((Image*)image, (const ChannelType)channel, black_point, mid_point, white_point);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_ModulateImage
(JNIEnv* env, jclass klass, jlong image, jlong modulate){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_ModulateImage(image, modulate);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_ModulateImage
(jlong image, jlong modulate){
    return ModulateImage((Image*)image, (const char*)modulate);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_NegateImage
(JNIEnv* env, jclass klass, jlong image, jint grayscale){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_NegateImage(image, grayscale);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_NegateImage
(jlong image, jint grayscale){
    return NegateImage((Image*)image, (const unsigned int)grayscale);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Enhance_NormalizeImage
(JNIEnv* env, jclass klass, jlong image){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Enhance_NormalizeImage(image);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Enhance_NormalizeImage
(jlong image){
    return NormalizeImage((Image*)image);
}
