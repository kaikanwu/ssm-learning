package com.kk.learn.ssm.chapter2.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  CGLIB 动态代理
 * @author kaikanwu
 * @date 5/17/2019
 */
public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成 CGLIB 代理对象并返回
     * @param cls Class 类
     * @return Class 类的 CGLIB 代理对象
     */
    public Object getProxy(Class cls) {
        // CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强对象
        enhancer.setSuperclass(cls);
        // 定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 方法，(implements MethodInterceptor )
        enhancer.setCallback(this);
        // 生成并返回代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.err.println("调用真实对象前");
        // CGLIB 反射调用真实对象方法
        Object result = methodProxy.invokeSuper(proxy, args);
        System.err.println("调用真实对象之后");
        return result;
    }
}
