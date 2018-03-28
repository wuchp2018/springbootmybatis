package com.open.controller;

import com.open.mapper.UserMapper;
import com.open.model.User;
import com.open.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    public UserService userService;

    @RequestMapping(value="/selectByPrimaryKey")
    @ResponseBody
    public String selectByPrimaryKey(@RequestParam(name = "id") Long id) {
        User user = userService.selectByPrimaryKey(id);
        if ( user!=null ) {
            return user.getName();
        } else {
            return "null";
        }
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertUser(@RequestParam(name="name") String name, @RequestParam(name = "pwd") String pwd) {
        User user = new User();
        user.setName(name);
        user.setPassword(pwd);
        int i = userService.insert(user);
        if ( i>0 ) {
            return user.getName();
        } else {
            return "插入失败";
        }
    }

}

