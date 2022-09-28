package com.lenovo.travelspringboot.util;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class RedisUtilTest {
    /*@Autowired
    RedisUtil redisUtil;*/
    @Test
    void test1(){
        boolean b = preserveCode("q14682810702020@163.com");
        System.out.println(b);
    }


    boolean preserveCode(String email) {
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return false;
        }
        String host = "";
        String hostName = email.split("@")[1];
        Record[] result = null;
        SMTPClient client = new SMTPClient();
        try {
            // 查找MX记录
            Lookup lookup = new Lookup(hostName, Type.MX);
            lookup.run();
            if (lookup.getResult() != Lookup.SUCCESSFUL) {
                return false;
            } else {
                result = lookup.getAnswers();
            }
            // 连接到邮箱服务器
            for (int i = 0; i < result.length; i++) {
                host = result[i].getAdditionalName().toString();
                System.out.println(host);
                client.connect(host);
                if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
                    client.disconnect();
                    continue;
                } else {
                    System.out.println("找到MX记录:" + hostName);
                    System.out.println("建立链接成功：" + hostName);
                    break;
                }
            }
            //以下2项自己填写快速的，有效的邮箱
            client.login("qq.com");
            client.setSender("1602315416@qq.com");
            client.addRecipient(email);
            System.out.println("验证:"+client.getReplyCode());

            if (250 == client.getReplyCode()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;

        }
    }
