package com.kk.learn.ssm.chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在 JDK 动态代理中使用拦截器
 * @author kaikanwu
 * @date 5/17/2019
 */
public class InterceptorJdkProxy implements InvocationHandler {
    /**
     * 真实对象
     */
    private Object target;
    /**
     * 拦截器全限定名
     */
    private String interceptorClass = null;

    /**
     *  InterceptorJdkProxy 的构造器
     * @param target 真实对象
     * @param interceptorClass 拦截器类
     */
    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个「代理占位」
     * @param target 真实对象
     * @param interceptorClass 拦截器全限定名
     * @return 代理对象 「占位」
     */
    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }


    /**
     *  通过代理对象调用方法，首先进入这个方法
     * @param proxy 代理对象
     * @param method 当前调度的方法
     * @param args 调用方法的参数
     * @return 代理结果返回
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            // 如果没有拦截器，则直接返回反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        // 调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            // 反射原有对象方法
            result = method.invoke(target, args);
        }else {
            // 返回 false 执行 around 方法
            interceptor.around(proxy, target, method, args);
        }
        // 调用后置方法
        interceptor.after(proxy, target, method, args);

        return result;
    }}
