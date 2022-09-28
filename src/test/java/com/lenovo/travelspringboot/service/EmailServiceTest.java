package com.lenovo.travelspringboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailServiceTest {
@Autowired
EmailService emailService;

    @Test
    void sendMessage() {
        emailService.sendMessage("1602315416@qq.com", "306744978@qq.com", "7758258");

    }
}