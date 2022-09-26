package com.lenovo.travelspringboot;

import com.lenovo.travelspringboot.dao.UserDaoInterface;
import com.lenovo.travelspringboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelSpringBootApplicationTests {
    @Autowired
    UserDaoInterface userDaoInterface;

    @Test
    void contextLoads() {
     /*   User user = new User(0,"123","123445","wuyifan","1922/10/11","男","14812521616","16@qq.com","Y","11111");
        userDaoInterface.addUserSingle(user);*/
//        String user = userDaoInterface.selectUsername("123");

    }

}
