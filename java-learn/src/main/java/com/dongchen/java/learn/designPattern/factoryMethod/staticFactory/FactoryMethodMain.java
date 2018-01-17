package com.dongchen.java.learn.designPattern.factoryMethod.staticFactory;


/**
 * @author: mdd
 * @date:2017/12/10
 */
public class FactoryMethodMain {

    public static void main(String[] args){
        SendFactory.produceSms().sendMsg();
        SendFactory.producrMail().sendMsg();
    }
}
