package com.xm.controller;

import com.xm.entity.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/logup")
    public String logup(@PathParam("username") String username,@PathParam("password") String password,
                        @PathParam("gender") Integer gender,@PathParam("telephone") String telephone,
                        Model model,HttpSession session){
        int result=userService.logup(username,password,gender,telephone);
        String page=null;
        User user=new User(username,password,gender,telephone);
        switch (result){
            case 1:
                page="redirect:index";
                model.addAttribute("user",user);
                session.setAttribute("loginUser","欢迎您！"+username);
                break;
            case 2:
                model.addAttribute("msg","手机号已经被注册");
                page= "logup";
                break;
            case 3:
                model.addAttribute("msg","用户名已存在");
                page="logup";
                break;
            case 4:
                model.addAttribute("msg","用户名和手机号都已存在");
                page= "logup";
                break;
        }
        return page;
    }

    @GetMapping("/login")
    public String login(@PathParam("username") String username,@PathParam("password") String password,Model model,HttpSession session ){
        int result=userService.login(username,password);
        User user=new User();
        if(result==1){
            user.setUsername(username);
            user.setPassword(password);
            model.addAttribute("user",user);
            session.setAttribute("loginUser","欢迎您！"+username);
            return "redirect:index";
        }else{
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }
    }
}
