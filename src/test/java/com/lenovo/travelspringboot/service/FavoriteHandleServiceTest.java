package com.lenovo.travelspringboot.service;

import com.lenovo.travelspringboot.domain.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavoriteHandleServiceTest {
    @Autowired
    FavoriteHandleService favoriteHandleService;

    @Test
    void test1() {
        favoriteHandleService.insertFavoriteForUser(1, 55);
    }

    @Test
    void  test2(){
        List<Route> routeByUid = favoriteHandleService.findRouteByUid(1);
        for (Route route : routeByUid) {
            System.out.println(route);
        }

    }
}