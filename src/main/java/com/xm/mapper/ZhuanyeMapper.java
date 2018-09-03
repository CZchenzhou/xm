package com.xm.mapper;

import com.xm.entity.school.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZhuanyeMapper {

    @Select("select * from subject where subject_id in(select subject_id from school_subject where school_id=#{id})")
    List<Subject> getAllSubjectsBySchoolId(Integer id);
}
