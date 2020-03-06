package com.woniu.team2project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
//@EnableTransactionManagement
//自动扫面mapper包下的接口生成实现类
@MapperScan("com.woniu.team2project.mapper")
@SpringBootApplication
public class Team2projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team2projectApplication.class, args);
	}

}