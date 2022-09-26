package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Msg;
import com.lenovo.travelspringboot.domain.User;
import com.lenovo.travelspringboot.service.UserHandleService;
import com.lenovo.travelspringboot.web.servlet.CheckCodeServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author P._Ming
 * */

@Controller
public class RegisterController {
    @Autowired
    UserHandleService userHandleService;


    @PostMapping("/addUser")
    @ResponseBody
    public Msg addUser(@Valid User user, BindingResult bindingResult,String check){
        //BindingResult 这个必须要放在参数第二位
        System.out.println("check:"+check);
        String flagForCheck = CheckCodeServlet.flagForCheck;
        boolean checkCodeFlag = check.equalsIgnoreCase(flagForCheck);
        Boolean aBoolean = userHandleService.selectUsername(user.getUsername());
        System.out.println("用户名："+!aBoolean);
       /* if (!aBoolean){
            System.out.println("方法执行");
            return Msg.fail().add("username1", "用户名存在！");
        }*/
        if (bindingResult.hasErrors()){//有错误信息
                //保存信息并传到前台
                Map<String, Object> map = new HashMap<>();
                //首先获取错误信息
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {//循环获取每一个错误
                    /*System.out.println("错误的字段名:"+fieldError.getField());
                    System.out.println("错误的信息提示:"+fieldError.getDefaultMessage());*/
                    map.put(fieldError.getField(),fieldError.getDefaultMessage());
                }
                return Msg.fail().add("errorField",map);
            }else{
                if (!checkCodeFlag){
//                    System.out.println("checkCode执行");
                    return Msg.fail().add("checkCode","验证码有误！");
                }

                String gender=user.getSex() .equals("M") ? "男" : "女";
                user.setSex(gender);
//            userHandleService.addUserForRegister(user);
                System.out.println(user);
                return Msg.success();
            }





    }

    @GetMapping("/test/{code}")
//    @ResponseBody
    public String test1(@PathVariable("code") String code){
        System.out.println(code);
        return null;
    }
}
