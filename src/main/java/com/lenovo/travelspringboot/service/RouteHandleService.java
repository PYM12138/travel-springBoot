package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.RouteDaoInterface;
import com.lenovo.travelspringboot.dao.RouteImgDaoInterface;
import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.domain.RouteImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RouteHandleService {
    @Autowired
    RouteDaoInterface routeDaoInterface;
    @Autowired
    RouteImgDaoInterface routeImgDaoInterface;

    public List<Route> queryRoute(String key){

        List<Route> routes = routeDaoInterface.selectRouteByLike("%" + key + "%");
//        for (Route route : routes) {
//            System.out.println(route);
//        }

        return routes;
    }

    public Route findRouteByRidCompriseImg(Integer rid){

        return routeDaoInterface.selectRouteByRid(rid);
    }

}
