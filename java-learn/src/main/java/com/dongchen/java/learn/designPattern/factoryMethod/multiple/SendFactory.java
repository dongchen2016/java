package com.dongchen.java.learn.designPattern.factoryMethod.multiple;


import com.dongchen.java.learn.designPattern.MailSender;
import com.dongchen.java.learn.designPattern.Sender;
import com.dongchen.java.learn.designPattern.SmsSender;

/**
 * @author: mdd
 * @date:2017/12/10
 */
public class SendFactory {

    public Sender produceSms(){
        return new SmsSender();
    }

    public Sender producrMail(){
        return new MailSender();
    }

}
