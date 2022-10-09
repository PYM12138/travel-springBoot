package com.lenovo.travelspringboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.travelspringboot.domain.Route;
import com.lenovo.travelspringboot.service.RouteHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    RouteHandleService routeHandleService;

    String flag="";

    @GetMapping("/search")
    public String searchResultManifest(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                       @RequestParam(value = "searchContent",defaultValue = "路线") String searchContent, Model model){
        /* * 1.搜索实现流程
        *  输入框查询数据条件
        *   点击搜索，把条件传入后端
        *   后端发起查询数据库
        *       这里开始分页数据展示
        *   查询到的内容放入前端
        *   前端循环展示数据
        * */

        if (searchContent.equals("路线")&&flag.equals("")){//前端不能传一个空值过来
            return "redirect:/";
        }else{


            //判断searchContent是为空，还是重复，还是初始状态,记录下来就不用每次都从前端取值查询
            if (flag.equals("")){
                flag=searchContent;
            }
            if (!"".equals(searchContent)&&!flag.equals(searchContent)&&!searchContent.equals("路线")){
                flag=searchContent;
            }



            PageHelper.startPage(pn, 5);
            System.out.println("flag2"+flag);
            List<Route> routeByLike = null;
            if (flag.equals("country")){//国内游路线专属查询
                routeByLike = routeHandleService.queryRoute("%%");
            }else{
                routeByLike = routeHandleService.queryRoute(flag);
            }

            PageInfo<Route> routePageInfo = new PageInfo<>(routeByLike, 5);
//        model.addAttribute("routeList", routeByLike);
            model.addAttribute("pageInfo", routePageInfo);
            return "route_list";
        }



    }




}

