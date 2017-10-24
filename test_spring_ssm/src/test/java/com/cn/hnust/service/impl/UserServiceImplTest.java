package com.cn.hnust.service.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.homedate.pojo.User;
import com.homedate.service.UserService;

import junit.framework.TestCase;

//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserServiceImplTest extends TestCase {
	private static Logger logger = Logger.getLogger(UserServiceImplTest.class);
	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		System.out.println(user.getUserName());
		logger.info("值：" + user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
}
