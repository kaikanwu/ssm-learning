package com.kk.learn.ssm;

import com.kk.learn.ssm.chapter2.proxy.*;
import com.kk.learn.ssm.chapter2.reflect.ReflectServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author kaikanwu
 * @date 5/17/2019
 */
public class ProxyPattenTest {


    @Test
    public void testJdkProxy() {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

    @Test
    public void testCGLIBProxy() {
        CglibProxyExample example = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) example.getProxy(ReflectServiceImpl.class);
        obj.sayHello("Luka");

    }

    @Test
    public void testInterceptor() {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.kk.learn.ssm.chapter2.proxy.MyInterceptor");
        proxy.sayHelloWorld();
    }

}
