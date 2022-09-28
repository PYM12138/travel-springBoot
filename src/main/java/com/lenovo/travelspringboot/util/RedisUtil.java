package com.lenovo.travelspringboot.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    public Boolean preserveCode(String email,String code){//生成并保存验证码
        String emailKey=email+":email";
        String codeKey=email+":code";
        String createTimeKey=email+":createTime";
        String expireTimeKey=email+":expireTime";
        String statusKey=email+":statusKey";
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(statusKey)) && Objects.equals(stringRedisTemplate.opsForValue().get(statusKey), "1")){
            System.out.println("已注册");
            return false;
        }


//        stringRedisTemplate.opsForValue().set(emailKey, email,3,TimeUnit.MINUTES);
//        stringRedisTemplate.opsForValue().set(codeKey, code,3,TimeUnit.MINUTES);
//        stringRedisTemplate.opsForValue().set(statusKey, "1",3,TimeUnit.MINUTES);

        return true;

    }
}
