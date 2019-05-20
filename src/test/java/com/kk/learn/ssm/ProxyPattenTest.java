package com.kk.learn.ssm;

import com.kk.learn.ssm.chapter2.builder.TicketBuilder;
import com.kk.learn.ssm.chapter2.builder.TicketHelper;
import com.kk.learn.ssm.chapter2.observer.PDDObserver;
import com.kk.learn.ssm.chapter2.observer.ProductList;
import com.kk.learn.ssm.chapter2.observer.TaoBaoObserver;
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

    @Test
    public void testMultipleInterceptor() {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.kk.learn.ssm.chapter2.proxy.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, "com.kk.learn.ssm.chapter2.proxy.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, "com.kk.learn.ssm.chapter2.proxy.Interceptor3");
        proxy3.sayHelloWorld();
    }

    @Test
    public void testObserver() {
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        PDDObserver pddObserver = new PDDObserver();
        observable.addObserver(pddObserver);
        observable.addObserver(taoBaoObserver);
        observable.addProduct("【新增产品 1】");
    }

    @Test
    public void testBuilder() {
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildSoldier("军人票");
        helper.buildElderly("老人票");
        helper.buildChildrenNoSeat("无座儿童");
        helper.buildChildrenForSeat("有座儿童");
        Object ticket = TicketBuilder.builder(helper);
    }
}
