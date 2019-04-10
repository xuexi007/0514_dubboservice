package com.offcn.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.offcn.mapper.UserMapper;
import com.offcn.po.User;
import com.offcn.service.UserService;
import com.offcn.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    IdWorker idWorker;


    @Override
    public User findUserById(Integer id) throws IOException {
        logger.debug("查询指定id:"+id);
        return userMapper.findUserById(id);
    }

    @Override
    public Integer registerUser(User user) {
        logger.debug("用户注册:"+user);
        //生产用户id，不采用数据库自增，
        long id = idWorker.nextId();
        //指定注册用户的id
        user.setId(id);
        Integer num = userMapper.registerUser(user);
        logger.debug("注册结果:"+num);
        return num;
    }

    @Override
    public User login(String username, String encrptPassword) {
        return userMapper.login(username,encrptPassword);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


}
