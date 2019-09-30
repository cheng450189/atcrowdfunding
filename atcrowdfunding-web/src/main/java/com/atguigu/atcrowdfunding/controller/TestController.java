package com.atguigu.atcrowdfunding.controller;


import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService service;

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @ResponseBody
    @RequestMapping("/json")
    public Object json(){
        Map<String, String> map = new HashMap<>();
        map.put("12321", "12321321dsfds");
        return map;
    }

    @ResponseBody
    @RequestMapping("/query")
    public List<User> queryAll(){
        List<User> users = service.queryAll();

        return users;
    }
}
