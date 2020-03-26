extern "C"{
    #include <magick/api.h>
}

#include <cstdlib>

#include "net_gudenau_discord_images_magick_ExceptionInfo.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_free
    (jlong pointer);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_init
    (void);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_reason
    (jlong pointer);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_description
    (jlong pointer);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_severity
    (jlong pointer);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_signature
    (jlong pointer);
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_error_1number
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_module
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_function
    (jlong);
    JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_line
    (jlong);
}

JNIEXPORT void JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_free
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_free(pointer);
}
JNIEXPORT void JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_free
(jlong pointer){
    free((ExceptionInfo*)pointer);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_init
(JNIEnv* env, jclass klass){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_init();
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_init
(void){
    auto exception = (ExceptionInfo*)malloc(sizeof(ExceptionInfo));
    GetExceptionInfo(exception);
    return (jlong)exception;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_reason
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_reason(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_reason
(jlong pointer){
    return (jlong)(((ExceptionInfo*)pointer)->reason);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_description
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_description(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_description
(jlong pointer){
    return (jlong)(((ExceptionInfo*)pointer)->description);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_severity
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_severity(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_severity
(jlong pointer){
    return (jint)(((ExceptionInfo*)pointer)->severity);
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_signature
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_signature(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_signature
(jlong pointer){
    return (jlong)(((ExceptionInfo*)pointer)->signature);
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_error_1number
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_error_1number(pointer);
}
JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_error_1number
(jlong pointer){
    return ((ExceptionInfo*)pointer)->error_number;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_module
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_module(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_module
(jlong pointer){
    return (jlong)((ExceptionInfo*)pointer)->module;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_function
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_function(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_function
(jlong pointer){
    return (jlong)((ExceptionInfo*)pointer)->function;
}

JNIEXPORT jlong JNICALL Java_net_gudenau_discord_images_magick_ExceptionInfo_line
(JNIEnv* env, jclass klass, jlong pointer){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_line(pointer);
}
JNIEXPORT jlong JNICALL JavaCritical_net_gudenau_discord_images_magick_ExceptionInfo_line
(jlong pointer){
    return ((ExceptionInfo*)pointer)->line;
}
