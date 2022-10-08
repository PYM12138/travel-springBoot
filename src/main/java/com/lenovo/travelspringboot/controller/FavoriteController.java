package com.lenovo.travelspringboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.service.RouteHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class FavoriteController {
    @Autowired
    RouteHandleService routeHandleService;

    @GetMapping("/favoriteList")
    public String favorite(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {

        PageHelper.startPage(pn, 1);
        List<Route> routes = routeHandleService.CountEqualFavorite();
        PageInfo<Route> routePageInfo = new PageInfo<>(routes, 5);
        model.addAttribute("pageInfo", routePageInfo);

        return "favoriterank";
    }


}
