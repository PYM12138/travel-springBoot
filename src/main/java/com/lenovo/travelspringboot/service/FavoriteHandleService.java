package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.dao.FavoriteDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteHandleService {
    @Autowired
    FavoriteDaoInterface favoriteDaoInterface;

    public Boolean findFavoriteForUser(Integer uid,Integer forRid){
        List<Integer> rid = favoriteDaoInterface.selectRIDByUid(uid);
        boolean contains = rid.contains(forRid);
        if (contains){
            return true;
        }else{
            return false;

        }

    }


}
