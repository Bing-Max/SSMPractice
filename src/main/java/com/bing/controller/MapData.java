package com.bing.controller;

import com.bing.utils.CommonBody;
import com.bing.utils.MapDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class MapData {
    @Autowired
    MapDataUtils utils;

    @ResponseBody
    @RequestMapping("/all")
    public CommonBody getMapData(){
        return utils.getMapData();
    }
}
