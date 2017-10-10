package com.example.demo2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo2.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM user")
	List<User> findAll();
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	List<User> findAll(@Param("id") Integer id);
	
	@Update("UPDATE user SET age=#{age} WHERE id=#{id}")
	int updateAgeById(@Param("age") Integer age, @Param("id'") Integer id);
	
}
