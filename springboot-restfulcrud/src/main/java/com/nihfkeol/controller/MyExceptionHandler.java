package com.nihfkeol.controller;

import com.nihfkeol.exception.UserNotExisException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1、浏览器和客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExisException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExisException.class)
    public String  handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入自己的错误状态码 4xx 5xx
        //Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code", 505);
        map.put("code","user.notexist");
        map.put("message","用户名错误");

        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
