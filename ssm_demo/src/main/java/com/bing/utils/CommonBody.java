package com.bing.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommonBody {
    // code 取值为0 ： 正确返回；  1： 出错
    private int code;
    private String msg;
    private Map<String, Object> datas = new HashMap<String, Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public CommonBody putData(String msg, Object obj){
        this.datas.put(msg,obj);
        return this;
    }

    public void clear(){
        this.datas.clear();
        this.msg = "";
    }

    public CommonBody defaultFailed(){
        this.setCode(1);
        this.setMsg("错误");
        return this;
    }

    public CommonBody defaultSucces(){
        this.setCode(0);
        this.setMsg("返回成功");
        return this;
    }

}
