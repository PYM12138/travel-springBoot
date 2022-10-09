package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.FavoriteDaoInterface;
import com.lenovo.travelspringboot.dao.RouteDaoInterface;
import com.lenovo.travelspringboot.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FavoriteHandleService {
    @Autowired
    FavoriteDaoInterface favoriteDaoInterface;
    @Autowired
    RouteDaoInterface routeDaoInterface;
    /**
     * 查询user下面有没有rid，有是代表收藏
     * */
    public Boolean findFavoriteForUser(Integer uid,Integer forRid){
        List<Integer> rid = favoriteDaoInterface.selectRIDByUid(uid);
//        System.out.println(rid);
        boolean contains = rid.contains(forRid);
        if (contains){
            //包含
            return true;
        }else{
            //不包含
            return false;

        }

    }
    public void insertFavoriteForUser(Integer uid,Integer rid){
        Boolean favoriteForUser = findFavoriteForUser(uid, rid);

        if (!favoriteForUser){
            favoriteDaoInterface.insertFavoriteOne(rid, new Date(), uid);
        }else{
            System.out.println("收藏数据已在用户收藏夹中，不能重复收藏！");
        }

    }
    public void deleteFavoriteForUser(Integer uid,Integer rid){
        Boolean favoriteForUser = findFavoriteForUser(uid, rid);
        if (favoriteForUser){
            favoriteDaoInterface.deleteFavoriteWithRidAndUid(uid,rid);
        }else{
            System.out.println("要删除的收藏不存在！");
        }
    }
    /*
    * 根据uid找到rid,在用rid来找对应的数据
    * */
    public List<Route> findRouteByUid(Integer uid){
        List<Integer> rid = favoriteDaoInterface.selectRIDByUid(uid);
        List<Route> routeList=new ArrayList<>();
        for (Integer integer : rid) {
            Route route = routeDaoInterface.selectRouteByRid(integer);
            routeList.add(route);
        }
        return routeList;

    }


}
