package com.kk.learn.ssm.chapter2.proxy;

import java.lang.reflect.Method;

/**
 * @author kaikanwu
 * @date 5/20/2019
 */
public class Interceptor3 implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】的 before 方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】的 after 方法");

    }
}
