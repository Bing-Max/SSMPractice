package com.bing.controller;

import com.bing.dao.DeptMapper;
import com.bing.entity.Department;
import com.bing.utils.CommonBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
public class DeptController {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private CommonBody commonBody;

    @RequestMapping("/depts")
    @ResponseBody
    public CommonBody getList(){
        commonBody.setCode(0);
        commonBody.setMsg("获取成功");
        return commonBody.putData("depts",deptMapper.getAll());
    }
}
