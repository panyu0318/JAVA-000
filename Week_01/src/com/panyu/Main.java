package com.panyu;

import java.lang.reflect.Method;

public class Main{

    public static void main(String[] args) throws Exception {
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        Class<?> Hello = helloClassLoader.findClass("Hello");
        Object hello = Hello.newInstance();
        Method method = Hello.getMethod("hello");
        method.invoke(hello);
    }
}
