package com.junlaninfo.controller;

import org.apache.ibatis.javassist.compiler.ast.Symbol;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.junlaninfo.utils.RedisUtils;
@RestController
public class RedisLock {
	@Autowired
	RedisTemplate<String, String>	redisTemplate;
	@Autowired
	RedisUtils redisUtils;
	@RequestMapping(value = "redisLock",method = RequestMethod.GET)
	public String redisLock() {
		//ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		String lock=System.currentTimeMillis()+"";
		String key="count";
		//redisUtils.setString(key, 100+"");
		//String string = opsForValue.get(key);
		String string = redisUtils.getString(key);
		System.out.println(string);
		Integer  count=Integer.valueOf(string);
		if (count==0) {
			return  "抢完了";
		}
		count --;
		redisUtils.setString(key, count+"");
		System.out.println("抢到了商品："+count++);
		return "抢到了商品："+(count++);
	}

}
