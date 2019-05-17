package com.kk.learn.ssm;

import com.kk.learn.ssm.chapter2.proxy.CglibProxyExample;
import com.kk.learn.ssm.chapter2.proxy.HelloWorld;
import com.kk.learn.ssm.chapter2.proxy.HelloWorldImpl;
import com.kk.learn.ssm.chapter2.proxy.JdkProxyExample;
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

}
