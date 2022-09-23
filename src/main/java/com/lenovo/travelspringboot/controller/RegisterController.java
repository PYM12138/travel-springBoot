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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserHandleService userHandleService;


    @PostMapping("/addUser")
    @ResponseBody
    public Msg addUser(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){//有错误信息
            //保存信息并传到前台
            Map<String, Object> map = new HashMap<>();
            //首先获取错误信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {//循环获取每一个错误
                System.out.println("错误的字段名:"+fieldError.getField());
                System.out.println("错误的信息提示:"+fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorField",map);

        }else{
            String gender=user.getSex() .equals("M") ? "男" : "女";
            user.setSex(gender);
//            userHandleService.addUserForRegister(user);
            System.out.println(user);
            return Msg.success();
        }

    }

}
