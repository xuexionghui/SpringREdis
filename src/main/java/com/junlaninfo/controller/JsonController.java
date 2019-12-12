package com.junlaninfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junlaninfo.entity.UserEntity;
import com.junlaninfo.utils.RedisUtils;
/*
 * json方式存储在redis中，可以在各种语言比较适用，较采用这种方式
 *   可读性比较强
 */
@RestController
public class JsonController {
	@Autowired
	RedisUtils  redisUtils;
	private String string;
	
	@RequestMapping(value = "/setRedis",method = RequestMethod.GET)
	public void setRedis(UserEntity  userEntity) {
		redisUtils.setString("userEntity", JSONObject.toJSONString(userEntity));
	}

	@GetMapping(value = "/getRedis")
	public UserEntity getRedis() {
		String string2 = redisUtils.getString("userEntity");
		UserEntity userEntity = JSONObject.parseObject(string2, UserEntity.class);
	    System.out.println("userId是："+	userEntity.getUserId());
	    System.out.println("userName是："+	userEntity.getUserName());
		return userEntity;
	}

}
