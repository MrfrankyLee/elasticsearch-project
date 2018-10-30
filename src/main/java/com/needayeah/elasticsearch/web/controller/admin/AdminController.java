package com.needayeah.elasticsearch.web.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
@Api(value = "/admin", description = "用户")
public class AdminController {


    @RequestMapping(value = "/center",method = RequestMethod.GET)
    @ApiOperation(notes = "adminCenterPage",value = "进入后台管理页面",httpMethod = "GET")
    public String adminCenterPage(){
        return "/admin/center";
    }


    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    @ApiOperation(notes = "welcomePage",value = "欢迎页面",httpMethod = "GET")
    public String welcomePage(){
        return "/admin/welcome";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(notes = "AdminLogin",value = "后台登录页面",httpMethod = "GET")
    public String AdminLogin(){
        return "/admin/login";
    }
}
