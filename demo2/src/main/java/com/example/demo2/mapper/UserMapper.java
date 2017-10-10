package com.example.demo2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.example.demo2.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM user")
	List<User> findAll();
	
	// @Select("SELECT * FROM user WHERE id = #{id}")
	// 采用结构化sql语句
	@SelectProvider(method = "findById", type = UserDaoProvider.class)
	List<User> findById(@Param("id") Integer id);
	
	@Update("UPDATE user SET age=#{age} WHERE id=#{id}")
	int updateAgeById(@Param("age") Integer age, @Param("id") Integer id);
	
	class UserDaoProvider {
		public String findById(Integer id) {
			return new SQL(){{
				SELECT("*");
				FROM("user");
				if (id != null) {
					WHERE(" id=#{id} ");
				}
			}}.toString();
		}
	}
	
}
