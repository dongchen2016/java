package com.dongchen.java.learn.designPattern.factoryMethod.multiple;


import com.mdd.java.learn.Sender;

/**
 * @author: mdd
 * @date:2017/12/10
 */
public class FactoryMethodMain {

    public static void main(String[] args){
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produceSms();
        Sender smsSender = sendFactory.producrMail();
        sender.sendMsg();
        smsSender.sendMsg();
    }
}
