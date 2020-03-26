extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Transform.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ChopImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_CoalesceImages
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_CropImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_DeconstructImages
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ExtentImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlattenImages
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlipImage
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlopImage
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_MosaicImages
    (jlong image, jlong exception);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_RollImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ShaveImage
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_TransformImage
    (jlong, jlong, jlong);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_ChopImage
(JNIEnv* env, jclass klass, jlong image, jlong chop_info, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_ChopImage(image, chop_info, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ChopImage
(jlong image, jlong chop_info, jlong exception){
    return (jlong)ChopImage((const Image*)image, (const RectangleInfo*)chop_info, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_CoalesceImages
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_CoalesceImages(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_CoalesceImages
(jlong image, jlong exception){
    return (jlong)CoalesceImages((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_CropImage
(JNIEnv* env, jclass klass, jlong image, jlong geometry, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_CropImage(image, geometry, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_CropImage
(jlong image, jlong geometry, jlong exception){
    return (jlong)CropImage((const Image*)image, (const RectangleInfo*)geometry, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_DeconstructImages
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_DeconstructImages(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_DeconstructImages
(jlong image, jlong exception){
    return (jlong)DeconstructImages((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_ExtentImage
(JNIEnv* env, jclass klass, jlong image, jlong geometry, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_ExtentImage(image, geometry, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ExtentImage
(jlong image, jlong geometry, jlong exception){
    return (jlong)ExtentImage((const Image*)image, (const RectangleInfo*)geometry, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_FlattenImages
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_FlattenImages(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlattenImages
(jlong image, jlong exception){
    return (jlong)FlattenImages((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_FlipImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_FlipImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlipImage
(jlong image, jlong exception){
    return (jlong)FlipImage((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_FlopImage
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_FlopImage(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_FlopImage
(jlong image, jlong exception){
    return (jlong)FlopImage((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_MosaicImages
(JNIEnv* env, jclass klass, jlong image, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_MosaicImages(image, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_MosaicImages
(jlong image, jlong exception){
    return (jlong)MosaicImages((const Image*)image, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_RollImage
(JNIEnv* env, jclass klass, jlong image, jlong x_offset, jlong y_offset, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_RollImage(image, x_offset, y_offset, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_RollImage
(jlong image, jlong x_offset, jlong y_offset, jlong exception){
    return (jlong)RollImage((const Image*)image, (const long)x_offset, (const long)y_offset, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_ShaveImage
(JNIEnv* env, jclass klass, jlong image, jlong shave_info, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_ShaveImage(image, shave_info, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_ShaveImage
(jlong image, jlong shave_info, jlong exception){
    return (jlong)ShaveImage((const Image*)image, (const RectangleInfo*)shave_info, (ExceptionInfo*)exception);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Transform_TransformImage
(JNIEnv* env, jclass klass, jlong image, jlong crop_geometry, jlong image_geometry){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Transform_TransformImage(image, crop_geometry, image_geometry);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Transform_TransformImage
(jlong image, jlong crop_geometry, jlong image_geometry){
    return (jlong)TransformImage((Image**)image, (const char*)crop_geometry, (const char*)image_geometry);
}
