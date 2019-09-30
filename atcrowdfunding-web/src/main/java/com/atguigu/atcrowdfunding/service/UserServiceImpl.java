package com.atguigu.atcrowdfunding.service;


import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao dao;

    public List<User> queryAll() {

        return dao.queryAll();
    }
}
