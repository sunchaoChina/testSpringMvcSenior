package com.homedate.dao;

import org.apache.ibatis.annotations.Param;

import com.homedate.pojo.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id")Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}