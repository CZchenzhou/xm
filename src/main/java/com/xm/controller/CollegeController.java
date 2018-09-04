package com.xm.controller;

import com.xm.entity.School;
import com.xm.entity.school.Subject;
import com.xm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CollegeController {

    private final SchoolService schoolService;
    private final zhuanyeService zhuanyeService;

    @Autowired
    public CollegeController(SchoolService schoolService, zhuanyeService zhuanyeService) {
        this.schoolService = schoolService;
        this.zhuanyeService = zhuanyeService;
    }
//    @GetMapping("/col_zhuanye")
//    public String col_zhuanye(HttpSession session){
//        String schoolName= (String) session.getAttribute("school");
//        Integer schoolId=schoolService.getSchoolByFullname(schoolName);
//        session.setAttribute("subjects",schoolService.getAllSubjectsById(schoolId));
//
//        return "col_zhuanye";
//    }


//    @GetMapping("/col_zhuanye")
//    public String col_zhuanye(HttpSession session) {
//        String schoolName = (String) session.getAttribute("school");
//        Integer schoolId = schoolService.getSchoolByFullname(schoolName);
//        List<Subject> subjectList = zhuanyeService.getAllSubjectsBySchoolId(schoolId);
//        for(Subject s:subjectList){
//            System.out.println(s.getSubjectName());
//        }
//        session.setAttribute("subjects", subjectList);
//        return "redirect:col_zhuanye";
//    }
}
