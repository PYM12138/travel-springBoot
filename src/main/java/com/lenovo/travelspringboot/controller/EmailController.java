package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Msg;
import com.lenovo.travelspringboot.service.EmailService;
import com.lenovo.travelspringboot.service.UserHandleService;
import com.lenovo.travelspringboot.util.RedisUtil;
import com.lenovo.travelspringboot.util.UuidUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    EmailService emailService;
    @Autowired
    UserHandleService userHandleService;

  /*  @GetMapping("/sendEmailAndUsername")
    @ResponseBody
    public String getEmailAndUsername(String email,String username){
        System.out.println(email);
        System.out.println(username);
        return email;
    }*/


    @GetMapping(value = {"/emailCodeCheck","/sendEmailAndUsername"})
    @ResponseBody
    public Msg activeCode(String email,String username,@RequestParam("emailCode") String emailCode){
        /*
        * 邮箱激活流程:
        *   1.当注册完成之后，发送激活码
        *   2.前端填写激活码对比本地激活码（激活码存在时间为3分钟！）
        *   3.若激活成功=status=Y,第一次保存数据时候是默认为N
        *   4.前端提示信息
        * */
//        System.out.println(email);
//        System.out.println(username);

        String code = UuidUtil.getUuid().substring(0, 5);

        Boolean codeResist = redisUtil.preserveCode(email, code);
        if (codeResist){
            //第一次发验证码
            System.out.println("激活码:"+code);
            return getMsg(emailCode, email, username, code);
        }else{
            //如果存在就发存在的验证码
            String key = redisUtil.getKey(email);
            System.out.println("激活码:"+key);
            return getMsg(emailCode, email, username, key);


        }

    }

    private Msg getMsg(String emailCode, String email, String username, String key) {
//        emailService.sendMessage("1602315416@qq.com", email, key);
        boolean equals = emailCode.equals(key);
        if (equals){
//            userHandleService.updateStatue("Y", username, email);
            return Msg.success();
        }else{
            return Msg.fail().add("activeStatus", "激活失败！");
        }
    }


}
