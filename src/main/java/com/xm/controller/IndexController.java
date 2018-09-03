package com.xm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class IndexController {

    @GetMapping("/changeSchool")
    public String changeSchool(@PathParam("school_name") String school_name,HttpSession session){
        session.setAttribute("school",school_name);
        return "redirect:index";
    }
}
