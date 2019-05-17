package com.kk.learn.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射生成带有参数的构建方法
 * @author kaikanwu
 * @date 5/14/2019
 */
public class ReflectServiceImpl2 {
    private String name;

    /**
     * Constructor
     */
    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(String name) {
        System.err.println("hi" + name);
    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.kk.learn.ssm.chapter2.reflect.ReflectServiceImpl2")
                    .getConstructor(String.class).newInstance("Tom");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException |NoSuchMethodException
                | SecurityException |IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return object;
    }
}
