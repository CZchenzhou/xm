package com.xm.service;

import com.xm.entity.School;
import com.xm.entity.school.Subject;
import com.xm.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    public List<School> getSchoolByName(String name){
        return schoolMapper.getSchoolByName(name);
    }

    public Integer getSchoolByFullname(String name){
        return schoolMapper.getSchoolByFullname(name);
    }

    public List<Subject> getAllSubjectsById(Integer id){
        return schoolMapper.getAllSubjectsById(id);
    }
}
