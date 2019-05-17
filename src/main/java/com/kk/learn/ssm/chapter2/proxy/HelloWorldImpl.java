package com.kk.learn.ssm.chapter2.proxy;

/**
 * @author kaikanwu
 * @date 5/17/2019
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
