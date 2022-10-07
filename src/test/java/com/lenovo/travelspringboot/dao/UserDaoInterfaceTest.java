package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoInterfaceTest {
    @Autowired
    UserDaoInterface userDaoInterface;
    @Test
    void selectUsername() {
        String s = userDaoInterface.selectUsername("160231541");
        System.out.println(s);
    }

    @Test
    void testUserLogin(){
        User user = userDaoInterface.selectUserSingle("1602315416", "fj1602315416");
        System.out.println(user);
    }

}