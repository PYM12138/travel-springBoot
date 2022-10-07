package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.service.RouteHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteDetailController {
    @Autowired
    RouteHandleService routeHandleService;

    @GetMapping("/detail/{rid}")
    public String detailOne(@PathVariable Integer rid, Model model){

        Route routeByRidCompriseImg = routeHandleService.findRouteByRidCompriseImg(rid);

        model.addAttribute("routeWithImg", routeByRidCompriseImg);


        return "route_detail";
    }


}
