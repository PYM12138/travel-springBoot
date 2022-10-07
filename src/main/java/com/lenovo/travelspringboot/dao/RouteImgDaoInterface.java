package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.RouteImg;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RouteImgDaoInterface {
    @Select("select * from tab_route_img where rid=#{rid}")
/*    @Results(id = "routeImg",value = {
            @Result(id = true,column ="rgid",property = "rgid"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "bigPic",property = "bigPic"),
            @Result(column = "smallPic",property = "smallPic"),
            @Result(property = "route",column = "rid",one =
            @One(select = "com.lenovo.travelspringboot.dao.RouteDaoInterface.selectRouteByLike",fetchType = FetchType.DEFAULT)
            )
    }
    )*/
    List<RouteImg> selectImg(Integer rid);
}
