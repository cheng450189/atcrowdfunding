package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

     @Select("select * from user")
     List<User> queryAll();

     @Select("select * from user where loginacct = #{loginacct} and userpswd = #{userpswd}")
//     @Select("select * from user")
     User queryLogin(User user);
}
