package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserDaoInterface {
    //添加用户
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    @Insert("insert into tab_user( username, password, name, birthday, sex, telephone, email, status, code) values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone}," +
            "#{email},#{status},#{code})")
    int addUserSingle(User user);

}
