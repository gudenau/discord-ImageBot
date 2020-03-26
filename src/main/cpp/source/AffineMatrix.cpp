extern "C"{
    #include <magick/api.h>
}

#include <cstdlib>

#include "net_gudenau_discord_images_magick_AffineMatrix.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_free
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_init
    (void);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__J
    (jlong);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__J
    (jlong);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__J
    (jlong);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__J
    (jlong);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__J
    (jlong);
    JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__J
    (jlong);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__JD
    (jlong, jdouble);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__JD
    (jlong, jdouble);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__JD
    (jlong, jdouble);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__JD
    (jlong, jdouble);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__JD
    (jlong, jdouble);
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__JD
    (jlong, jdouble);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_free
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_free(pointer);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_free
(jlong pointer){
    free((void*)pointer);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_init
(JNIEnv* env, jclass klass){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_init();
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_init
(void){
    return (jlong)malloc(sizeof(AffineMatrix));
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_sx__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->sx;
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_rx__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->rx;
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_ry__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->ry;
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_sy__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->sy;
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_tx__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->tx;
}

JNIEXPORT jdouble JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_ty__J
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__J(pointer);
}
JNIEXPORT jdouble JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__J
(jlong pointer){
    return ((AffineMatrix*)pointer)->ty;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_sx__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sx__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->sx = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_rx__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_rx__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->rx = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_ry__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ry__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->ry = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_sy__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_sy__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->sy = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_tx__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_tx__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->tx = value;
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_AffineMatrix_ty__JD
(JNIEnv* env, jclass klass, jlong pointer, jdouble value){
    UNUSED(env);
    UNUSED(klass);
    JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__JD(pointer, value);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_AffineMatrix_ty__JD
(jlong pointer, jdouble value){
    ((AffineMatrix*)pointer)->ty = value;
}
