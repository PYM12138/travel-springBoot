package com.lenovo.travelspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * 邮件操作
 */
@Service
public class EmailService {
    @Resource
    private JavaMailSenderImpl javaMailSender;

    public void sendMessage(String sendEmail,String receiveEmail,String code){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("旅游网邮件验证");
        message.setText("您的激活码为(三分钟内有效！):"+code);
        message.setFrom(sendEmail);//发送者的邮箱地址
        message.setTo(receiveEmail); //接收者的邮箱地址
        javaMailSender.send(message);
    }



}
