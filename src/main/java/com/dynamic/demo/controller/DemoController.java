package com.dynamic.demo.controller;

import com.dynamic.demo.service.UserService1;
import com.dynamic.demo.vo.User;
import com.dynamic.util.WebResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 16:28
 */
@RestController
public class DemoController {

    @Autowired
    private UserService1 userService1;

    @GetMapping("/test01")
    public String test1(){
        User user = new User();
        user.setId(2132l);

        String rev = userService1.save1(user);
        return rev;
    }

    @GetMapping("/getUser1")
    @ResponseBody
    public WebResponseBody getUser1(){
        User user = new User();
        user.setId(2132l);

        User rev = userService1.getUser1(user);
        return new WebResponseBody(1,"成功",rev);
    }

    @GetMapping("/test02")
    public String test2(){
        User user = new User();
        user.setId(123l);

        userService1.save2(user);
        return "demo";
    }

    @GetMapping("/getUser2")
    @ResponseBody
    public WebResponseBody getUser2(){
        User user = new User();
        user.setId(123l);

        User uu = userService1.getUser(user);
        return new WebResponseBody(1,"成功",uu);
    }

}
