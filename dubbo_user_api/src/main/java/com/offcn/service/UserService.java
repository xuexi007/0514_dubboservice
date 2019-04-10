package com.offcn.service;

import com.offcn.po.User;

import java.io.IOException;

/**
 * 用户逻辑处理接口
 */
public interface UserService {

    User findUserById(Integer id) throws IOException;

    Integer registerUser(User user);

    User login(String username, String encrptPassword);

    User getUserByUsername(String username);

}
