package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RouteDaoInterfaceTest {
    @Autowired
    RouteDaoInterface routeDaoInterface;
    @Test
    void selectRouteByLike() {
        List<Route> guizhou = routeDaoInterface.selectRouteByLike("%贵州%");
        for (Route route : guizhou) {
            System.out.println(route);
        }
    }

    @Test
    void testSelectRouteByLike() {
    }

    @Test
    void selectRouteByRid() {
        Route route = routeDaoInterface.selectRouteByRid(1);
        System.out.println(route);
    }

    @Test
    void selectRouteByCount() {
        List<Route> routes = routeDaoInterface.selectRouteByCount();
        for (Route route : routes) {
            System.out.println(route);
        }
    }
}