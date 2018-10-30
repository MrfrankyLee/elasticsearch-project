package com.needayeah.elasticsearch.base;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * create by lixiaole
 */
@Api(value = "",description = "web页面错误处理")
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final String ERROR_PATH="/error";

    private ErrorAttributes errorAttributes;


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    /***
     *  web页面错误处理
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    @ApiOperation(notes = "errorPageHandler", value = "错误信息处理,返回错误页面")
    public String errorPageHandler(HttpServletRequest request , HttpServletResponse response){
        int status = response.getStatus();
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }



    @RequestMapping(value = ERROR_PATH)
    @ApiOperation(notes = "errorApiHandler", value = "错误信息处理,返回错误json数据")
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request ,HttpServletResponse response){
        WebRequest requestAttributes = new ServletWebRequest(request) ;
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        int status = getStatus(request);
        return ApiResponse.ofMeaasge(status,String.valueOf(attr.getOrDefault("message ","error")));
    }

    private int getStatus(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(status!= null){
            return status;
        }
        return 500;
    }
}
