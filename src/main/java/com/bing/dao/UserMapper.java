package com.bing.dao;

import com.bing.entity.User;
import java.util.List;

public interface UserMapper {

    public List<User> getAll();

    public User getByName(String name);

    public void add(User user);
}
