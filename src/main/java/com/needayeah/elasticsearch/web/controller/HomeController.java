package com.needayeah.elasticsearch.web.controller;

import com.needayeah.elasticsearch.base.ApiResponse;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(value = "/", description = "主页")
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name","李晓乐");
        return "index";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse get(){
        return ApiResponse.ofMeaasge(200,"成功了");
    }
}
