package com.lenovo.travelspringboot.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavoriteDaoInterfaceTest {
@Autowired
FavoriteDaoInterface favoriteDaoInterface;
    @Test
    void insertFavoriteOne() {
        Date date = new Date();
//        favoriteDaoInterface.insertFavoriteOne(3, date, 1);
        List<Integer> rid = favoriteDaoInterface.selectRIDByUid(1);
        boolean contains = rid.contains(4);
        System.out.println(contains);


    }
}