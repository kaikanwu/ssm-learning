package com.kk.learn.ssm.chapter2.proxy;

import java.lang.reflect.Method;

/**
 * @author kaikanwu
 * @date 5/17/2019
 */
public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy, Object target, Method method, Object[] args);
}
