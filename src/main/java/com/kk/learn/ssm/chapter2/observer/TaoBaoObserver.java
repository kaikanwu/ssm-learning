package com.kk.learn.ssm.chapter2.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author kaikanwu
 * @date 5/20/2019
 */
public class TaoBaoObserver implements Observer {
    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.err.println("发送新产品" + newProduct + "同步到 TB");
    }
}
