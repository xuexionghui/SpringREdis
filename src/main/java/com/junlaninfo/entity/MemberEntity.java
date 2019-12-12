package com.junlaninfo.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.io.Serializable;


@Data
public class MemberEntity implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
