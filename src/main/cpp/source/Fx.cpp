extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Fx.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_CharcoalImage
    (jlong, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ColorizeImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ColorMatrixImage
    (jlong, jint, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ImplodeImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_MorphImages
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_OilPaintImage
    (jlong, jdouble, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SolarizeImage
    (jlong, jdouble);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SteganoImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_StereoImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SwirlImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_WaveImage
    (jlong, jdouble, jdouble, jlong);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_CharcoalImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_CharcoalImage(image, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_CharcoalImage
(jlong image, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)CharcoalImage((Image*)image, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_ColorizeImage
(JNIEnv* env, jclass klass, jlong image, jlong opacity, jlong target, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_ColorizeImage(image, opacity, target, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ColorizeImage
(jlong image, jlong opacity, jlong target, jlong exception){
    return (jlong)ColorizeImage((Image*)image, (const char*)opacity, *((PixelPacket*)target), (ExceptionInfo*)exception);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Fx_ColorMatrixImage
(JNIEnv* env, jclass klass, jlong image, jint order, jlong color_matrix){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_ColorMatrixImage(image, order, color_matrix);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ColorMatrixImage
(jlong image, jint order, jlong color_matrix){
    return (jint)ColorMatrixImage((Image*)image, order, (const double*)color_matrix);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_ImplodeImage
(JNIEnv* env, jclass klass, jlong image, jdouble amount, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_ImplodeImage(image, amount, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_ImplodeImage
(jlong image, jdouble amount, jlong exception){
    return (jlong)ImplodeImage((Image*)image, amount, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_MorphImages
(JNIEnv* env, jclass klass, jlong image, jlong number_frames, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_MorphImages(image, number_frames, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_MorphImages
(jlong image, jlong number_frames, jlong exception){
    return (jlong)MorphImages((Image*)image, number_frames, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_OilPaintImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_OilPaintImage(image, radius, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_OilPaintImage
(jlong image, jdouble radius, jlong exception){
    return (jlong)OilPaintImage((Image*)image, radius, (ExceptionInfo*)exception);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Fx_SolarizeImage
(JNIEnv* env, jclass klass, jlong image, jdouble threshold){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_SolarizeImage(image, threshold);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SolarizeImage
(jlong image, jdouble threshold){
    return (jint)SolarizeImage((Image*)image, threshold);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_SteganoImage
(JNIEnv* env, jclass klass, jlong image, jlong watermark, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_SteganoImage(image, watermark, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SteganoImage
(jlong image, jlong watermark, jlong exception){
    return (jlong)SteganoImage((Image*)image, (Image*)watermark, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_StereoImage
(JNIEnv* env, jclass klass, jlong image, jlong offset_image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_StereoImage(image, offset_image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_StereoImage
(jlong image, jlong offset_image, jlong exception){
    return (jlong)StereoImage((Image*)image, (Image*)offset_image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_SwirlImage
(JNIEnv* env, jclass klass, jlong image, jdouble degrees, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_SwirlImage(image, degrees, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_SwirlImage
(jlong image, jdouble degrees, jlong exception){
    return (jlong)SwirlImage((Image*)image, degrees, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Fx_WaveImage
(JNIEnv* env, jclass klass, jlong image, jdouble amplitude, jdouble wave_length, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Fx_WaveImage(image, amplitude, wave_length, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Fx_WaveImage
(jlong image, jdouble amplitude, jdouble wave_length, jlong exception){
    return (jlong)WaveImage((Image*)image, amplitude, wave_length, (ExceptionInfo*)exception);
}