package com.junlaninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junlaninfo.dao.UserMapper;
import com.junlaninfo.entity.MemberEntity;

@RestController
public class MemberController {
    @Autowired
    private UserMapper userMapper;
    /*
     * 这里使用了redis作为缓存，就可能会出现，
     * 数据库已经更新了数据但是redis中的
     * 数据没有更新，这样就会读取到脏数据，解决方案：
     * 1、清除redis中的缓存数据，不常用
     * 2、使用mq订阅mysql的binlog，发给redis
     * 3、使用Alibaba的cacel框架
     */
    @RequestMapping("/findMemberAll")
    @Cacheable(cacheNames = "member", key = "'findMemberAll'")
    public List<MemberEntity> findMemberAll() {
        return userMapper.findMemberAll();
    }
}
