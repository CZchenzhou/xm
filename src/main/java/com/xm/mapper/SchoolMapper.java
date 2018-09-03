package com.xm.mapper;

import com.xm.entity.School;
import com.xm.entity.school.Subject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SchoolMapper {

    @Select("select * from school where name like \'%${name}%\'")
    List<School> getSchoolByName(@Param(value="name") String name);

    @Select("select id from school where name = #{name}")
    Integer getSchoolByFullname(@Param(value="name") String name);

    @Select("select * from school where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property = "subject",
                    many =@Many(
                            select = "com.xm.mapper.ZhuanyeMapper.getAllSubjectsBySchoolId",fetchType = FetchType.LAZY
                    ))
    })
    List<Subject> getAllSubjectsById(Integer id);


}
