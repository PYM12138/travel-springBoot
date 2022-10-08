package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.Route;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RouteDaoInterface {
    @Select("select * from tab_route where rname like #{findKey}")
    /*    @Results(id = "routeMap",value = {
                @Result(id = true,column = "rid",property = "rid"),
                @Result(column = "sid",property = "sid"),
                //查询多条，保证返回接收是LIST集合
                @Result(property = "routeImgList",column = "rid",
                        many = @Many(select = "com.lenovo.travelspringboot.dao.RouteImgDaoInterface.selectImg",fetchType = FetchType.DEFAULT)),
                @Result(property ="seller",column = "sid",
                        one =@One(select ="com.lenovo.travelspringboot.dao.SellerDaoInterface.selectSellerBySid",fetchType = FetchType.DEFAULT) )
        })*/
        List<Route> selectRouteByLike(String findKey);

        @Select("select * from tab_route where rid=#{rid}")
        @Results(id = "RouteSingleForImg" ,value = {
                @Result(id = true,column = "rid",property = "rid"),
                @Result(column = "sid",property = "sid"),
                @Result(property = "routeImgList",column = "rid",
                        many = @Many(select = "com.lenovo.travelspringboot.dao.RouteImgDaoInterface.selectImg",fetchType = FetchType.DEFAULT))
        })
        Route selectRouteByRid(Integer rid);

        @Select("select * from tab_route where count!=0 order by count desc")
        List<Route> selectRouteByCount();



}
