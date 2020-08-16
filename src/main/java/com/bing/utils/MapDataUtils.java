package com.bing.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class MapDataUtils {

    @Autowired
    private CommonBody mapData;

    private long timeStamp;

    @PostConstruct
    public void init(){
        this.timeStamp = 0;
        getData();
    }


    public void getData(){
        if(System.currentTimeMillis() - timeStamp > 600000){
            try {
                // 获取数据
                URL url = new URL("https://zaixianke.com/yq/all");
                URLConnection con = url.openConnection();
                InputStream is = con.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                this.mapData.setCode(0);
                this.mapData.setMsg(bf.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CommonBody getMapData() {
        this.getData();

        return mapData;
    }
}
