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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String favorite(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        PageHelper.startPage(pn, 5);
        List<Route> routes = routeHandleService.CountEqualFavorite();
        PageInfo<Route> routePageInfo = new PageInfo<>(routes, 5);
        model.addAttribute("pageInfo", routePageInfo);

        return "favoriterank";
    }


    @GetMapping("/myfavorite")
    public String myFavorite(HttpSession session,Model model) {
        /*
         * 防止绕过登录直接访问我的收藏
         *   1.检测session域的数据，不存在则返回首页，存在就去我的收藏
         * 收藏：
         *   1.在详情页可以添加收藏，保存对应的uid和rid即可
         *          (点击收藏，在count要加一)
         *   2.在我的收藏用这两个数据去查询你要的收藏，以收藏数量排行一下
         *           (分页数据也需要)
         * */

        User user = (User) session.getAttribute("user");
        if (user==null){
            model.addAttribute("loginMyFav", "未登录没有权限访问我的收藏");

        }else{
            //收藏页面还要关系到分页，导航条
            //TODO:收藏页面，分页，导航条
            //当前的uid去找rid，rid从route里面找
            List<Route> routeByUid = favoriteHandleService.findRouteByUid(user.getUid());
            model.addAttribute("routeMyList", routeByUid);

        }
        return "myfavorite";

    }

    @GetMapping("/favoriteOne")
    @ResponseBody
    public Msg favoriteOne(HttpSession session, Integer rid) {
        User user = (User) session.getAttribute("user");
        if (user == null) {//如果session域中没有用户登录
            //先不展示是否收藏
            return Msg.fail().add("loginTip", "请先登录！");
        } else {
            Boolean favoriteForUser = favoriteHandleService.findFavoriteForUser(user.getUid(), rid);
            //查询对应的uid下有没有rid存在，有就代表收藏了，没有就是没收藏
            return favoriteForUser ? Msg.success() : Msg.fail();

        }

    }

    @GetMapping("/favoriteStatue/{favorite}/{uri1}/{uri2}")
    public String favoriteStatue(HttpSession httpSession, @PathVariable("favorite") Integer favorite, @PathVariable("uri1") String uri1, @PathVariable("uri2") String uri2, Model model) {


        User user = (User) httpSession.getAttribute("user");
        if (user == null) {//如果session域中没有用户登录

            //数据放到隐藏域，然后取出来
//            model.addAttribute("loginTip2", "请先登录！");
//            httpSession.setAttribute("loginTip3", "请先登录！");

        } else {
//            httpSession.removeAttribute("loginTip3");
            if (favorite == 1) {
                //还要给当前用户添加进去
                favoriteHandleService.insertFavoriteForUser(user.getUid(), Integer.valueOf(uri2));
                //更新收藏状态
                routeHandleService.updateFavoriteCount(Integer.valueOf(uri2), true);
            } else {
                //取消收藏
                favoriteHandleService.deleteFavoriteForUser(user.getUid(), Integer.valueOf(uri2));
                routeHandleService.updateFavoriteCount(Integer.valueOf(uri2), false);
            }

            return "redirect:/" + uri1 + "/" + uri2;

        }

        return "redirect:/" + uri1 + "/" + uri2;
    }


}
