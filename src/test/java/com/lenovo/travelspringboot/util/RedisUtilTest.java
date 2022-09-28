package com.lenovo.travelspringboot.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RedisUtilTest {
    @Autowired
    RedisUtil redisUtil;
    @Test
    void preserveCode() {
        redisUtil.preserveCode("16023@qq.com","7777");
    }


}