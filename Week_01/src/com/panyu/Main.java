package com.panyu;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main extends ClassLoader {

    public static void main(String[] args) throws Exception {
        // write your code here
        Class<?> Hello = new Main().findClass("Hello");
        Object hello = Hello.newInstance();
        Method method = Hello.getMethod("hello");
        method.invoke(hello);
    }

    @Override
    protected Class<?> findClass(String name) {
        InputStream resourceStream = this.getClass().getResourceAsStream("Hello.xlass");
        try {
            byte[] bytes = new byte[resourceStream.available()];
            resourceStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
