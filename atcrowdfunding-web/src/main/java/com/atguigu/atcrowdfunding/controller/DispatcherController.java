package com.atguigu.atcrowdfunding.controller;


import com.atguigu.atcrowdfunding.bean.AjAXResult;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DispatcherController {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("logout")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session){
        AjAXResult result = new AjAXResult();
        User dbUser = service.queryLogin(user);
        if(dbUser != null){
            session.setAttribute("loginUser", dbUser);
            result.setSuccess(true);
        }else {
            result.setSuccess(false);
        }
        return result;
    }

//    @RequestMapping("/doAJAXLogin")
//    public String doLogin(User user, Model model){
//
//        User dbUser = service.queryLogin(user);
//        if(dbUser != null){
//            return "main";
//        }else {
//            String errorMsg = "登陆账号或密码不正确，请重新输入";
//            model.addAttribute("error",errorMsg);
//            return "redirect:login";
//        }
//
//    }

}
