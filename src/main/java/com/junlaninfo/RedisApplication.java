package com.junlaninfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启缓存
@MapperScan("com.junlaninfo.dao")  //扫描SQL语句
//要使用数据库，应该注释掉
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RedisApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RedisApplication.class, args);

	}

}
