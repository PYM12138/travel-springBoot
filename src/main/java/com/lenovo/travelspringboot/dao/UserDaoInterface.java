package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDaoInterface {
    //添加用户
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    @Insert("insert into tab_user( username, password, name, birthday, sex, telephone, email, status, code) " +
            "values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email},#{status},#{code})")
    void addUserSingle(User user);

    //查询用户名 return 值 存在 或者 return null 不存在
    @Select("select username from tab_user where username=#{username}")
    String selectUsername(String username);

    //更新用户状态
    @Update("update tab_user set status=#{status} where username=#{username} and email=#{email}")
    void updateStatus(String status,String username,String email);

    //查询用户，用户名+密码的方式
    @Select("select * from tab_user where username=#{username} and password=#{password}")
    User selectUserSingle(String username,String password);

}
