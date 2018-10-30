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
        return "index";
    }

    @GetMapping("/404")
    public String notFoundPage(Model model){
        return "404";
    }

    @GetMapping("/403")
    public String accessError(Model model){
        return "403";
    }

    @GetMapping("/500")
    public String internalError(Model model){
        return "500";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        return "logout";
    }
}
