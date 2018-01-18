package com.dongchen.java.learn.designPattern.factoryMethod.normal;


import com.dongchen.java.learn.designPattern.MailSender;
import com.dongchen.java.learn.designPattern.Sender;
import com.dongchen.java.learn.designPattern.SmsSender;

/**
 * @author: mdd
 * @date:2017/12/10
 */
public class SendFactory {

    public Sender senderFactory(String senderType){
        if ("mail".equals(senderType)){
            return new MailSender();
        }else if("sms".equals(senderType)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确类型");
            return null;
        }
    }
}
