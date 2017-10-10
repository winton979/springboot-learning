package com.example.demo2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo2.entity.User;
import com.example.demo2.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Demo2ApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().set("hi", "hello");
		Assert.assertEquals("hello",redisTemplate.opsForValue().get("hi"));
	}
	
	@Test
	public void testRedisTemplateForObject() {
		redisTemplate.opsForValue().set("hi", R.ok());
	}
	
	/**
	 * 测试继承mybatis
	 */
	@Test
	public void testMybatis() {
		List<User> all = userMapper.findAll();
		for (User u : all) {
			System.out.println(u.toString());
		}
		System.out.println(userMapper.findById(1).toString());
		userMapper.updateAgeById(111, 1);
		System.out.println(userMapper.findById(1).toString());
	}
	
	/**
	 * 测试mybatis动态语句
	 */
	@Test
	public void testMybatisProvide() {
		List<User> all = userMapper.findById(1);
		for (User u : all) {
			System.out.println(u.toString());
		}
	}

}
