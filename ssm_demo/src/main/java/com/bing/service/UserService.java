package com.bing.service;

import com.bing.dao.UserMapper;
import com.bing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    // 依赖关系（userMapper, redisTemplate）注入完成之后调用该方法，进行缓存(redis 的 userMap)初始化
    @PostConstruct
    public void initUserMap(){
        System.out.println("initializing userMap...");
        List<User> users = userMapper.getAll();
        Map<String, User> map = new HashMap<>();
        for(User user: users){
            map.put(user.getName(), user);
            redisTemplate.opsForHash().putAll("userMap",map);
        }
    }

    public boolean login(String name, String passwd){
        if(redisTemplate.opsForHash().hasKey("userMap", name)){
            return passwd.equals(((User)redisTemplate.opsForHash().get("userMap", name)).getPasswd());
        }else {
            User user = userMapper.getByName(name);
            if(null != user){
                redisTemplate.opsForHash().put("userMap", user.getName(), user);
            }else {
                return false;
            }
            return passwd.equals(user.getPasswd());
        }
    }

    public List<User> getAll(){
        if(redisTemplate.opsForHash().size("userMap") > 0){
            return redisTemplate.opsForHash().values("userMap");
        }else{
            List<User> users = userMapper.getAll();
            Map<String, User> map = new HashMap<>();
            for(User user: users){
                map.put(user.getName(), user);
                redisTemplate.opsForHash().putAll("userMap",map);
            }
            return users;
        }

    }

}
