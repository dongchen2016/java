package com.dongchen.java.learn.designPattern.factoryMethod.staticFactory;

import com.mdd.java.learn.MailSender;
import com.mdd.java.learn.Sender;
import com.mdd.java.learn.SmsSender;

/**
 * @author: mdd
 * @date:2017/12/10
 */
public class SendFactory {

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static Sender producrMail(){
        return new MailSender();
    }

}
