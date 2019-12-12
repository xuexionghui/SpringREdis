package com.junlaninfo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserEntity implements Serializable {
    private Long userId;
    private String userName;
}