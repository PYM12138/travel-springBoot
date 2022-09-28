package com.lenovo.travelspringboot;

import com.lenovo.travelspringboot.dao.UserDaoInterface;
import com.lenovo.travelspringboot.domain.User;
import com.lenovo.travelspringboot.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class TravelSpringBootApplicationTests {
    @Autowired
    UserDaoInterface userDaoInterface;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
     /*   User user = new User(0,"123","123445","wuyifan","1922/10/11","男","14812521616","16@qq.com","Y","11111");
        userDaoInterface.addUserSingle(user);*/
//        String user = userDaoInterface.selectUsername("123");
//        redisUtil.preserveCode();

    }
    @Test
    public void sendMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个标题");
        message.setText("这是邮箱正文的内容");
        message.setFrom("1602315416@qq.com");//发送者的邮箱地址
        message.setTo("1602315416@qq.com"); //接收者的邮箱地址
        javaMailSender.send(message);
    }


}
