extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Effect.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AdaptiveThresholdImage
    (jlong, jlong, jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImage
    (jlong, jint, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImageChannel
    (jlong, jint, jint, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImage
    (jlong, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImageChannel
    (jlong, jint, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ConvolveImage
    (jlong, jint, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_DespeckleImage
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EdgeImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EmbossImage
    (jlong, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EnhanceImage
    (jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImage
    (jlong, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImageChannel
    (jlong, jint, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_MedianFilterImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_MotionBlurImage
    (jlong, jdouble, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ReduceNoiseImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ShadeImage
    (jlong, jint, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImage
    (jlong, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImageChannel
    (jlong, jint, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SpreadImage
    (jlong, jint, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImage
    (jlong, jdouble, jdouble, jdouble, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImageChannel
    (jlong, jint, jdouble, jdouble, jdouble, jdouble, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlackThresholdImage
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ChannelThresholdImage
    (jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_RandomChannelThresholdImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ThresholdImage
    (jlong, jdouble);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_WhiteThresholdImage
    (jlong, jlong);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_AdaptiveThresholdImage
(JNIEnv* env, jclass klass, jlong image, jlong width, jlong height, jdouble offset, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_AdaptiveThresholdImage(image, width, height, offset, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AdaptiveThresholdImage
(jlong image, jlong width, jlong height, jdouble offset, jlong exception){
    return (jlong)AdaptiveThresholdImage((Image*)image, width, height, offset, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_AddNoiseImage
(JNIEnv* env, jclass klass, jlong image, jint noise_type, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImage(image, noise_type, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImage
(jlong image, jint noise_type, jlong exception){
    return (jlong)AddNoiseImage((Image*)image, (const NoiseType)noise_type, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_AddNoiseImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jint noise_type, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImageChannel(image, channel, noise_type, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_AddNoiseImageChannel
(jlong image, jint channel, jint noise_type, jlong exception){
    return (jlong)AddNoiseImageChannel((Image*)image, (const ChannelType)channel, (const NoiseType)noise_type, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_BlurImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImage(image, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImage
(jlong image, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)BlurImage((Image*)image, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_BlurImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImageChannel(image, channel, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlurImageChannel
(jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)BlurImageChannel((Image*)image, (const ChannelType)channel, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_ConvolveImage
(JNIEnv* env, jclass klass, jlong image, jint order, jlong kernel, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_ConvolveImage(image, order, kernel, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ConvolveImage
(jlong image, jint order, jlong kernel, jlong exception){
    return (jlong)ConvolveImage((Image*)image, (const unsigned int)order, (const double*)kernel, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_DespeckleImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_DespeckleImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_DespeckleImage
(jlong image, jlong exception){
    return (jlong)DespeckleImage((Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_EdgeImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_EdgeImage(image, radius, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EdgeImage
(jlong image, jdouble radius, jlong exception){
    return (jlong)EdgeImage((Image*)image, radius, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_EmbossImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_EmbossImage(image, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EmbossImage
(jlong image, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)EmbossImage((Image*)image, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_EnhanceImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_EnhanceImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_EnhanceImage
(jlong image, jlong exception){
    return (jlong)EnhanceImage((Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_GaussianBlurImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImage(image, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImage
(jlong image, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)GaussianBlurImage((Image*)image, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_GaussianBlurImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImageChannel(image, channel, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_GaussianBlurImageChannel
(jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)GaussianBlurImageChannel((Image*)image, (const ChannelType)channel, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_MedianFilterImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_MedianFilterImage(image, radius, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_MedianFilterImage
(jlong image, jdouble radius, jlong exception){
    return (jlong)MedianFilterImage((Image*)image, radius, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_MotionBlurImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jdouble angle, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_MotionBlurImage(image, radius, sigma, angle, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_MotionBlurImage
(jlong image, jdouble radius, jdouble sigma, jdouble angle, jlong exception){
    return (jlong)MotionBlurImage((Image*)image, radius, sigma, angle, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_ReduceNoiseImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_ReduceNoiseImage(image, radius, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ReduceNoiseImage
(jlong image, jdouble radius, jlong exception){
    return (jlong)ReduceNoiseImage((Image*)image, radius, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_ShadeImage
(JNIEnv* env, jclass klass, jlong image, jint gray, jdouble azimuth, jdouble elevation, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_ShadeImage(image, gray, azimuth, elevation, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ShadeImage
(jlong image, jint gray, jdouble azimuth, jdouble elevation, jlong exception){
    return (jlong)ShadeImage((Image*)image, (const unsigned int)gray, azimuth, elevation, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_SharpenImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImage(image, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImage
(jlong image, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)SharpenImage((Image*)image, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_SharpenImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImageChannel(image, channel, radius, sigma, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SharpenImageChannel
(jlong image, jint channel, jdouble radius, jdouble sigma, jlong exception){
    return (jlong)SharpenImageChannel((Image*)image, (const ChannelType)channel, radius, sigma, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_SpreadImage
(JNIEnv* env, jclass klass, jlong image, jint radius, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_SpreadImage(image, radius, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_SpreadImage
(jlong image, jint radius, jlong exception){
    return (jlong)SpreadImage((Image*)image, (const unsigned int)radius, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_UnsharpMaskImage
(JNIEnv* env, jclass klass, jlong image, jdouble radius, jdouble sigma, jdouble amount, jdouble threshold, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImage(image, radius, sigma, amount, threshold, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImage
(jlong image, jdouble radius, jdouble sigma, jdouble amount, jdouble threshold, jlong exception){
    return (jlong)UnsharpMaskImage((Image*)image, radius, sigma, amount, threshold, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Effect_UnsharpMaskImageChannel
(JNIEnv* env, jclass klass, jlong image, jint channel, jdouble radius, jdouble sigma, jdouble amount, jdouble threshold, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImageChannel(image, channel, radius, sigma, amount, threshold, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_UnsharpMaskImageChannel
(jlong image, jint channel, jdouble radius, jdouble sigma, jdouble amount, jdouble threshold, jlong exception){
    return (jlong)UnsharpMaskImageChannel((Image*)image, (const ChannelType)channel, radius, sigma, amount, threshold, (ExceptionInfo*)exception);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Effect_BlackThresholdImage
(JNIEnv* env, jclass klass, jlong image, jlong threshold){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_BlackThresholdImage(image, threshold);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_BlackThresholdImage
(jlong image, jlong threshold){
    return BlackThresholdImage((Image*)image, (const char*)threshold);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Effect_ChannelThresholdImage
(JNIEnv* env, jclass klass, jlong image, jlong threshold){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_ChannelThresholdImage(image, threshold);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ChannelThresholdImage
(jlong image, jlong threshold){
    return ChannelThresholdImage((Image*)image, (const char*)threshold);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Effect_RandomChannelThresholdImage
(JNIEnv* env, jclass klass, jlong image, jlong channel, jlong thresholds, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_RandomChannelThresholdImage(image, channel, thresholds, exception);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_RandomChannelThresholdImage
(jlong image, jlong channel, jlong thresholds, jlong exception){
    return RandomChannelThresholdImage((Image*)image, (const char*)channel, (const char*)thresholds, (ExceptionInfo*)exception);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Effect_ThresholdImage
(JNIEnv* env, jclass klass, jlong image, jdouble threshold){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_ThresholdImage(image, threshold);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_ThresholdImage
(jlong image, jdouble threshold){
    return ThresholdImage((Image*)image, threshold);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Effect_WhiteThresholdImage
(JNIEnv* env, jclass klass, jlong image, jlong thresholds){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Effect_WhiteThresholdImage(image, thresholds);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Effect_WhiteThresholdImage
(jlong image, jlong thresholds){
    return WhiteThresholdImage((Image*)image, (const char*)thresholds);
}
