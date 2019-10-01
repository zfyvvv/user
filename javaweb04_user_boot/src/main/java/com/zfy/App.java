package com.zfy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 1.springboot简化spring的配置文件，方便开发；
 * 直接启动jar项目即可；
 * @author DELL
 *
 */
@SpringBootApplication
@MapperScan("com.zfy.mapper") //用于扫描mybatis的mapper接口
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
