package com.xm.service;

import com.xm.entity.User;
import com.xm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //注册功能
    public int logup(String username,String password,Integer gender, String telephone){
        User userUsername=userMapper.getUserByUsername(username);
        User userTelephone=userMapper.getUserByTelephone(telephone);

        //返回值
        // 1：注册成功
        // 2：手机号已经被注册
        // 3：用户名已存在
        // 4：用户名和手机号都已存在
        int result;
        if(userUsername==null&userTelephone==null){ //插入成功
            result=userMapper.logup(new User(username,password,gender,telephone));
        }else if(userUsername==null&userTelephone!=null){//手机号已经被注册
            result=2;
        }else if(userUsername!=null&userTelephone==null){//用户名已存在
            result=3;
        }else{//用户名和手机号都已存在
            result=4;
        }
        return result;
    }

    //登录功能
    public int login(String username,String password){
        User user1=userMapper.getUserByUsername(username);
        User user2=userMapper.getUserByTelephone(username);
        if(user1!=null&&user1.getPassword().equals(password)){
            return 1;
        }else if(user2!=null&&user2.getPassword().equals(password)){
            return 1;
        }else {
            return 0;
        }
    }
}
