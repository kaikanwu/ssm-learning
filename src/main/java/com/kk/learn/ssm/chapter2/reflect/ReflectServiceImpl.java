package com.kk.learn.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  「构造函数没有任何参数」的类的反射生成
 * @author kaikanwu
 * @date 5/14/2019
 */
public class ReflectServiceImpl {
    public void sayHello(String name) {
        System.err.println("Hi" + name);
    }

    /**
     * 通过反射的方法生成一个对象
     * @return ReflectServiceImpl 对象
     */
    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.forName("com.kk.learn.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return object;
    }

    /**
     * 获取反射方法
     */
    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target, "Tom");
        } catch (NoSuchMethodException | SecurityException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return returnObj;
    }

    /**
     * 通过反射生成对象和反射调度方法
     */
    public static Object reflect() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.kk.learn.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object, "Tom");
        } catch (NoSuchMethodException | SecurityException
                | ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | InstantiationException ex) {
            ex.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        reflect();
    }

}
