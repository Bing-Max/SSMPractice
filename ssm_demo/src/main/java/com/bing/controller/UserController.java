package com.bing.controller;

import com.bing.dao.UserMapper;
import com.bing.entity.User;
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
    private UserMapper userMapper;
    @Autowired
    private CommonBody commonBody;

    @RequestMapping("/users")
    @ResponseBody
    public CommonBody userList(){
        commonBody.setCode(0);
        commonBody.setMsg("获取user列表");
        return commonBody.putData("list",userMapper.getAll());
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonBody getUser(@RequestParam("name") String name, @RequestParam("passwd") String pwd){
        User user = userMapper.getByName(name);
        if(user.getPasswd()!= null && user.getPasswd().equals(pwd)){

            commonBody.setCode(0);
            commonBody.setMsg("验证成功");
            return commonBody.putData("user", user);
        }else{
             return commonBody.defaultFailed();
        }

    }
}
