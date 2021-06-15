//
// Created by duoyi on 2021/6/15.
//
#include "com_hao_androidtest_jni_JniTest.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_com_hao_androidtest_jni_JniTest_get(JNIEnv *env, jobject thiz){
    printf("invoke get in c\n");
    return env->NewStringUTF("Hello from JNI!");
}

JNIEXPORT void JNICALL Java_com_hao_androidtest_jni_JniTest_set(JNIEnv *env, jobject thiz, jstring string){
    printf("invoke get in c++\n");
    char* str = (char*)env->GetStringUTFChars(string, NULL);
    printf("%s\n",str);
    env->ReleaseStringUTFChars(string, str);
}
