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
     * @return false 用户名存在，true 用户名不存在
     * */
    public Boolean selectUsername(String username){
        String s = userDaoInterface.selectUsername(username);
        return s==null;
    }


}
