package com.lenovo.travelspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FavoriteController {

    @GetMapping("/favoriteList")
    public String favorite() {
//      log.info("``1111111111111111111111111");
        return "favoriterank";
    }


}
