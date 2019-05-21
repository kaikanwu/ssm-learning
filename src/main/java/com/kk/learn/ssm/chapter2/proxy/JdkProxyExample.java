package com.kk.learn.ssm.chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理绑定和代理逻辑实现
 * @author kaikanwu
 * @date 5/17/2019
 */
public class JdkProxyExample implements InvocationHandler {

    // 真实对象
    private Object target = null;

    /**
     *  1. 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    /**
     * 代理方法逻辑
     * @param proxy 代理对象，就是 bind 方法生成的对象
     * @param method 当前调度方法
     * @param args 调度方法的参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        // 这里相当于 sayHelloWorld 方法
        Object object = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");
        return object;
    }
}
