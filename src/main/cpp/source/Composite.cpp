extern "C"{
    #include <magick/api.h>
}

#include "net_gudenau_discord_images_magick_Composite.h"

#define UNUSED(var) ((void)(var))

extern "C"{
    JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Composite_CompositeImage
    (jlong, jint, jlong, jlong, jlong);    
}

JNIEXPORT jint JNICALL Java_net_gudenau_discord_images_magick_Composite_CompositeImage
(JNIEnv* env, jclass klass, jlong canvas_image, jint compose, jlong composite_image, jlong x_offset, jlong y_offset){
    UNUSED(env);
    UNUSED(klass);
    return JavaCritical_net_gudenau_discord_images_magick_Composite_CompositeImage(canvas_image, compose, composite_image, x_offset, y_offset);
}

JNIEXPORT jint JNICALL JavaCritical_net_gudenau_discord_images_magick_Composite_CompositeImage
(jlong canvas_image, jint compose, jlong composite_image, jlong x_offset, jlong y_offset){
    return (jint)CompositeImage((Image*)canvas_image, (const CompositeOperator)compose, (const Image*)composite_image, (const long)x_offset, (const long)y_offset);
}
