package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellerDaoInterface {

    @Select("select * from tab_seller where sid=#{sid}")
    Seller selectSellerBySid(Integer sid);


}
