package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    @GetMapping("/emailCodeCheck")
    @ResponseBody
    public Msg activeCode(@RequestParam("emailCode") String emailCode){

        return Msg.success();
    }

}
