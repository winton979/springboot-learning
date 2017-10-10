package com.example.demo2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo2.entity.User;
import com.example.demo2.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
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
	
	@Test
	public void testMybatis() {
		List<User> all = userMapper.findAll();
		for (User u : all) {
			System.out.println(u.toString());
		}
	}

}
