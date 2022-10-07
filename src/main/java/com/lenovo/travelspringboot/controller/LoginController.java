package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Msg;
import com.lenovo.travelspringboot.domain.User;
import com.lenovo.travelspringboot.service.UserHandleService;
import com.lenovo.travelspringboot.web.servlet.CheckCodeServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    /*
    * 登录模块:
    *   1.前端输入数据，传到后端
    *   2.后端首先进行校验，这个数据是否存在
    *       存在，检查是否激活。
    *               是-》登录成功！->跳转首页
    *               否-》提示未激活-》跳转到激活页面
    *      不存在，提示注册，跳转去注册
    * */
    @Autowired
    UserHandleService userHandleService;

    @PostMapping("/login")
    @ResponseBody
    public Msg Login(String username, String password, String check, HttpServletRequest request){
        String flagForCheck = CheckCodeServlet.flagForCheck;
        boolean checkResult = flagForCheck.equalsIgnoreCase(check);
        if (!checkResult){
            return Msg.fail().add("checkCodeLogin", "验证码错误！");
        }
        User user = userHandleService.loginUser(username, password);
        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return Msg.success();
        }
        return  Msg.fail();
    }

    @GetMapping("/exit")
    public String exitLogin(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }









}
