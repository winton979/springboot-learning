package com.example.demo2;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().set("hi", "hello");
		Assert.assertEquals("hello",redisTemplate.opsForValue().get("hi"));
	}
	
	@Test
	public void testRedisTemplateForObject() {
		redisTemplate.opsForValue().set("hi", R.ok());
	}

}
