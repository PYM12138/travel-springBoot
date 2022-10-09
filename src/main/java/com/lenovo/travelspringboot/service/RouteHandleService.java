package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.RouteDaoInterface;
import com.lenovo.travelspringboot.dao.RouteImgDaoInterface;
import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.domain.RouteImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class RouteHandleService {
    @Autowired
    RouteDaoInterface routeDaoInterface;
    @Autowired
    RouteImgDaoInterface routeImgDaoInterface;
    /**
     * describe : 搜索模糊查询
     * */

    public List<Route> queryRoute(String key){
        List<Route> routes = routeDaoInterface.selectRouteByLike("%" + key + "%");
        return routes;
    }
    /**
     * describe:用rid查找数据，包含大小图片信息
     * */
    public Route findRouteByRidCompriseImg(Integer rid){
        return routeDaoInterface.selectRouteByRid(rid);
    }
    /**
     * 查找收藏数据
     * */
    public List<Route> CountEqualFavorite(){

        return routeDaoInterface.selectRouteByCount();
    }

    /**
     *
     * 更改count的数量
     *
     * */
    public void updateFavoriteCount(Integer rid,Boolean flag){
        Route route = routeDaoInterface.selectRouteByRid(rid);
        if (flag){
            routeDaoInterface.updateCount(route.getCount()+1, route.getRid());
        }else{
            routeDaoInterface.updateCount(route.getCount()-1, route.getRid());
        }


    }

}
