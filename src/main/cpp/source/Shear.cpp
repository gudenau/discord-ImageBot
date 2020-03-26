extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Shear.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_AffineTransformImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_AutoOrientImage
    (jlong, jint, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_RotateImage
    (jlong, jdouble, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_ShearImage
    (jlong, jdouble, jdouble, jlong);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Shear_AffineTransformImage
(JNIEnv* env, jclass klass, jlong image, jlong affine, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Shear_AffineTransformImage(image, affine, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_AffineTransformImage
(jlong image, jlong affine, jlong exception){
    return (jlong)AffineTransformImage((const Image*)image, (const AffineMatrix*)affine, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Shear_AutoOrientImage
(JNIEnv* env, jclass klass, jlong image, jint current_orientation, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Shear_AutoOrientImage(image, current_orientation, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_AutoOrientImage
(jlong image, jint current_orientation, jlong exception){
    return (jlong)AutoOrientImage((const Image*)image, (const OrientationType)current_orientation, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Shear_RotateImage
(JNIEnv* env, jclass klass, jlong image, jdouble degrees, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Shear_RotateImage(image, degrees, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_RotateImage
(jlong image, jdouble degrees, jlong exception){
    return (jlong)RotateImage((const Image*)image, (const double)degrees, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Shear_ShearImage
(JNIEnv* env, jclass klass, jlong image, jdouble x_shear, jdouble y_shear, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Shear_ShearImage(image, x_shear, y_shear, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Shear_ShearImage
(jlong image, jdouble x_shear, jdouble y_shear, jlong exception){
    return (jlong)ShearImage((const Image*)image, (const double)x_shear, (const double)y_shear, (ExceptionInfo*)exception);
}
