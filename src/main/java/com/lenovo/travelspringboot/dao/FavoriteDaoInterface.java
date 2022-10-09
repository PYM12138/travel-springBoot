package com.lenovo.travelspringboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.Date;
import java.util.List;

@Mapper
public interface FavoriteDaoInterface {

    @Select("select rid from tab_favorite where uid=#{uid}")
    List<Integer> selectRIDByUid(Integer uid);


    @Insert("insert into tab_favorite(rid,date,uid) values(#{rid},#{date},#{uid})")
//    @SelectKey(statement = "SELECT  LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    void insertFavoriteOne(Integer rid, Date date, Integer uid);



}
