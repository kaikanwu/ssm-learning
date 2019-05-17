package com.kk.learn.ssm;

import com.kk.learn.ssm.chapter2.proxy.HelloWorld;
import com.kk.learn.ssm.chapter2.proxy.HelloWorldImpl;
import com.kk.learn.ssm.chapter2.proxy.JdkProxyExample;
import org.junit.jupiter.api.Test;

/**
 * @author kaikanwu
 * @date 5/17/2019
 */
public class JdkTest {


    @Test
    public void testJdkProxy() {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

}
