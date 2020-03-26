extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Blob.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_AttachBlob
    (jlong, jlong, jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_BlobToImage
    (jlong, jlong, jlong, jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlob
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlobInfo
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_GetBlobInfo
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_ImageToBlob
    (jlong, jlong, jlong, jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Blob_AttachBlob
(JNIEnv* env, jclass klass, jlong blob_info, jlong blob, jlong length){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Blob_AttachBlob(blob_info, blob, length);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_AttachBlob
(jlong blob_info, jlong blob, jlong length){
    AttachBlob((BlobInfo*)blob_info, (const void*)blob, (const size_t)length);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Blob_BlobToImage
(JNIEnv* env, jclass klass, jlong image_info, jlong blob, jlong length, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Blob_BlobToImage(image_info, blob, length, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_BlobToImage
(jlong image_info, jlong blob, jlong length, jlong exception){
    return (jlong)BlobToImage((const ImageInfo*)image_info, (const void*)blob, (const size_t)length, (ExceptionInfo*)exception);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Blob_DestroyBlob
(JNIEnv* env, jclass klass, jlong image){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlob(image);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlob
(jlong image){
    DestroyBlob((Image*)image);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Blob_DestroyBlobInfo
(JNIEnv* env, jclass klass, jlong blob_info){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlobInfo(blob_info);
}
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wdeprecated-declarations"
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_DestroyBlobInfo
(jlong blob_info){
    DestroyBlobInfo((BlobInfo*)blob_info);
}
#pragma GCC diagnostic pop

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_Blob_GetBlobInfo
(JNIEnv* env, jclass klass, jlong blob_info){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_Blob_GetBlobInfo(blob_info);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_GetBlobInfo
(jlong blob_info){
    GetBlobInfo((BlobInfo*)blob_info);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_Blob_ImageToBlob
(JNIEnv* env, jclass klass, jlong image_info, jlong image, jlong length, jlong exception){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Blob_ImageToBlob(image_info, image, length, exception);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_Blob_ImageToBlob
(jlong image_info, jlong image, jlong length, jlong exception){
    return (jlong)ImageToBlob((const ImageInfo*)image_info, (Image*)image, (size_t*)length, (ExceptionInfo*)exception);
}
