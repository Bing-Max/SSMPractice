package com.bing.controller;

import com.bing.dao.UserMapper;
import com.bing.entity.User;
import com.bing.service.UserService;
import com.bing.utils.CommonBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//注解 解决跨域问题
//@CrossOrigin(origins = "*")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommonBody commonBody;

    @RequestMapping("/users")
    @ResponseBody
    public CommonBody userList(){
        commonBody.setCode(0);
        commonBody.setMsg("获取user列表");
        return commonBody.putData("list",userService.getAll());
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonBody getUser(@RequestParam("name") String name, @RequestParam("passwd") String pwd){
//        System.out.println(userService);
            if(userService.login(name, pwd)){
                return new CommonBody().defaultSucces();
            }else{
                return new CommonBody().defaultFailed();
            }
    }
}
