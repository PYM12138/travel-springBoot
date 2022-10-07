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
    //添加用户
    public void addUserForRegister(User user){
        String gender = user.getSex().equals("M") ? "男" : "女";
        user.setSex(gender);
        user.setStatus("N");
        userDaoInterface.addUserSingle(user);
    }
    /**
     * @return false 用户名存在，true 用户名不存在
     * */
    public Boolean selectUsername(String username){
        String s = userDaoInterface.selectUsername(username);
        return s==null;
    }
    //更新用户状态
    public void updateStatue(String status,String username,String email){
        userDaoInterface.updateStatus(status, username, email);
    }

    /**
     * @return true =user有值 表示登录成功  false=user=null 表示登录失败
     * */
    public User loginUser(String username,String password){

        return userDaoInterface.selectUserSingle(username, password);

    }




}
