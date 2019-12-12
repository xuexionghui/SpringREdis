package com.junlaninfo.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * 存储在redis是以二进制的形式存的，Java二进制，不跨语言
 */
@RestController
public class SerializableController {
	@Resource
    private RedisTemplate<String, Object> redisTemplate;
	@GetMapping(value = "/setObject")
    public void setObject(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }
	@GetMapping(value = "/getObjet")
    public Object getObjet(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
