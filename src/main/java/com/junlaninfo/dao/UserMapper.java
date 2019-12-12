package com.junlaninfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.junlaninfo.entity.MemberEntity;

public interface UserMapper {
    @Select("select * from users")
    List<MemberEntity> findMemberAll();
}
