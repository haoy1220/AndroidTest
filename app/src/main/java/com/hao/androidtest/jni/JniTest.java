package com.hao.androidtest.jni;

public class JniTest {
    static {
        System.loadLibrary("jni_test");
    }

    public native void set(String str);

    public native String get();

    public static void main(String[] args) {
        JniTest jniTest = new JniTest();
        jniTest.set("hello jni");
        System.out.println(jniTest.get());
    }
}
