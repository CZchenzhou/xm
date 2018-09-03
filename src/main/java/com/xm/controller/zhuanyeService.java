package com.xm.controller;

import com.xm.entity.school.Subject;
import com.xm.mapper.ZhuanyeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class zhuanyeService {
    @Autowired
    private ZhuanyeMapper zhuanyeMapper;

    List<Subject> getAllSubjectsBySchoolId(Integer id){
        List<Subject> list=zhuanyeMapper.getAllSubjectsBySchoolId(id);
        System.out.println(list);
        return list;
    }
}
