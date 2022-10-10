package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.service.RouteHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {
    @Autowired
    RouteHandleService routeHandleService;

    @GetMapping({"/","/index.html"})
    public String indexWithData(Model model){
        /*
        * 1.随机1~500的数字
        * 2.取12个，分两批
        *
        * */
        List<Route> routes = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            int num = (int)(Math.random()*500);
            Route routeByRidCompriseImg = routeHandleService.findRouteByRidCompriseImg(num);
            routes.add(routeByRidCompriseImg);
        }

        model.addAttribute("routes", routes);

        return "index";
    }

}
