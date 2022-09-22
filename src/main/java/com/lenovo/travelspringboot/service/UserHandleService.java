package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.UserDaoInterface;
import com.lenovo.travelspringboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandleService {
    @Autowired
    UserDaoInterface userDaoInterface;

    public void addUserForRegister(User user){
        userDaoInterface.addUserSingle(user);
    }

}
