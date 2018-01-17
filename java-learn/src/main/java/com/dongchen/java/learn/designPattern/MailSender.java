package com.dongchen.java.learn.designPattern;

/**
 * @author: mdd
 * @date:2017/12/10
 */
public class MailSender implements Sender{

    @Override
    public void sendMsg(){
        System.out.println("send email message");
    }
}
