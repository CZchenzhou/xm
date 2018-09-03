package com.xm.mapper;

import com.xm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into user (username,password,gender,telephone) values (#{username},#{password},#{gender},#{telephone})")
    int logup(User user);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Select("select * from user where telephone=#{telephone}")
    User getUserByTelephone(String telephone);

}
