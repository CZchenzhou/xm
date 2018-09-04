package com.xm.controller;

import com.google.gson.Gson;
import com.xm.entity.School;
import com.xm.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    private Logger logger=LoggerFactory.getLogger(getClass());

    @GetMapping("/getSchoolByName")
//    @ResponseBody
    public List<School> getSchoolByName(@PathParam("school_name") String school_name, HttpSession session){
        List<School> schools=schoolService.getSchoolByName(school_name);
        session.setAttribute("schools",schools);
//        Gson gson=new Gson();
//        String json=gson.toJson(schools);
        return schools;
    }



}
