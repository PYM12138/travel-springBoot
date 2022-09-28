package com.lenovo.travelspringboot.controller;

import com.lenovo.travelspringboot.domain.Msg;
import com.lenovo.travelspringboot.service.EmailService;
import com.lenovo.travelspringboot.util.RedisUtil;
import com.lenovo.travelspringboot.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    EmailService emailService;

    @GetMapping("/emailCodeCheck")
    @ResponseBody
    public Msg activeCode(@RequestParam("emailCode") String emailCode,@RequestParam("email") String email){
        /*
        * 邮箱激活流程:
        *   1.当注册完成之后，发送激活码
        *   2.前端填写激活码对比本地激活码（激活码存在时间为3分钟！）
        *   3.若激活成功=status=Y,第一次保存数据时候是默认为N
        *   4.前端提示信息
        * */

        String code = UuidUtil.getUuid().substring(0, 5);
        Boolean codeResist = redisUtil.preserveCode(email, code);
        if (codeResist){
            //第一次发验证码
            emailService.sendMessage("1602315416@qq.com", email, code);
            boolean equals = emailCode.equals(code);
            if (equals){
                return Msg.success();
            }else{
                return Msg.fail().add("activeStatus", "激活失败！");
            }

        }else{
            //如果存在就发存在的验证码
            String key = redisUtil.getKey(email);
            emailService.sendMessage("1602315416@qq.com", email, key);
            boolean equals = emailCode.equals(key);
            if (equals){
                return Msg.success();
            }else{
                return Msg.fail().add("activeStatus", "激活失败！");
            }


        }

//        System.out.println("emailCode:"+emailCode);
//        System.out.println("email:"+email);


//        return Msg.success();
    }

}
