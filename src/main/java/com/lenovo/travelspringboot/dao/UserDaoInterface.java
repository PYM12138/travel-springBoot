package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface UserDaoInterface {
    //添加用户
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    @Insert("insert into tab_user( username, password, name, birthday, sex, telephone, email, status, code) " +
            "values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email},#{status},#{code})")
    void addUserSingle(User user);

    //查询用户名
    @Select("select username from tab_user where username=#{username}")
    String selectUsername(String username);
}
