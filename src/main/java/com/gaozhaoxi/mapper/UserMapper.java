package com.gaozhaoxi.mapper;

import com.gaozhaoxi.entity.User;

import java.util.List;

/**
 * @author Leon
 */
public interface UserMapper {
    public List<User> getUser();

    public int insertUser(User user);
}
