package com.lenovo.travelspringboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.travelspringboot.domain.Msg;
import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.domain.User;
import com.lenovo.travelspringboot.service.FavoriteHandleService;
import com.lenovo.travelspringboot.service.RouteHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class FavoriteController {
    @Autowired
    RouteHandleService routeHandleService;
    @Autowired
    FavoriteHandleService favoriteHandleService;

    @GetMapping("/favoriteList")
    public String favorite(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {

        PageHelper.startPage(pn, 5);
        List<Route> routes = routeHandleService.CountEqualFavorite();
        PageInfo<Route> routePageInfo = new PageInfo<>(routes, 5);
        model.addAttribute("pageInfo", routePageInfo);

        return "favoriterank";
    }


    @GetMapping("/myfavorite")
    public String myFavorite(HttpSession session){
        /*
        * 防止绕过登录直接访问我的收藏
        *   1.检测session域的数据，不存在则返回首页，存在就去我的收藏
        * 收藏：
        *   1.在详情页可以添加收藏，保存对应的uid和rid即可
        *          (点击收藏，在count要加一)
        *   2.在我的收藏用这两个数据去查询你要的收藏，以收藏数量排行一下
        *           (分页数据也需要)
        *
        * */

        User user =(User) session.getAttribute("user");
        System.out.println(user+"11111111111111111");
        return "myfavorite";

    }

    @GetMapping("/favoriteOne")
    @ResponseBody
    public Msg favoriteOne(HttpSession session, Integer rid,Integer uid){
        User user =(User) session.getAttribute("user");
        if (user==null){//如果session域中没有用户登录
            //先不展示是否收藏
            return Msg.fail().add("loginTip", "请先登录！");
        }else{
            Boolean favoriteForUser = favoriteHandleService.findFavoriteForUser(user.getUid(), rid);
            //查询对应的uid下有没有rid存在，有就代表收藏了，没有就是没收藏
            return favoriteForUser? Msg.success():Msg.fail();

        }

    }
    @GetMapping("/favoriteStatue")
    public String favoriteStatue(HttpSession httpSession,Boolean favorite,Model model){
        User user =(User) httpSession.getAttribute("user");
        if (user==null){//如果session域中没有用户登录
            //数据放到隐藏域，然后取出来
            model.addAttribute("loginTip", "请先登录！");

        }else{
            //更新收藏状态，重定向到当前页面
            if (favorite){
                //收藏数量加1


            }else{
                //收藏数量减1


            }

        }

        return "";
    }



}
