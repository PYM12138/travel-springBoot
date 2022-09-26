package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.UserDaoInterface;
import com.lenovo.travelspringboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserHandleService {
    @Autowired
    UserDaoInterface userDaoInterface;

    public void addUserForRegister(User user){
        userDaoInterface.addUserSingle(user);
    }
    /**
     * @return true 代表用户名不存在 false 代表存在
     * */
    public Boolean selectUsername(String username){
        String s = userDaoInterface.selectUsername(username);
        return "".equals(s);
    }


}
