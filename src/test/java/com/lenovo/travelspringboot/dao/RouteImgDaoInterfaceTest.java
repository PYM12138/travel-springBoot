package com.lenovo.travelspringboot.dao;

import com.lenovo.travelspringboot.domain.RouteImg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RouteImgDaoInterfaceTest {
@Autowired
RouteImgDaoInterface routeImgDaoInterface;
    @Test
    void selectImgByRid() {
   /*     List<RouteImg> routeImgs = routeImgDaoInterface.selectImgByRid(1);

        Collection<RouteImg> values = routeImgs.stream()
                .collect(Collectors.toMap(RouteImg::getRid, Function.identity(), (oldValue, newValue) -> oldValue))
                .values();
        for (RouteImg value : values) {
            System.out.println(value);
        }
*/


    }
}