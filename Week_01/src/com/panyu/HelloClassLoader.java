package com.panyu;

import java.io.IOException;
import java.io.InputStream;

public class HelloClassLoader extends ClassLoader {
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
