package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 整合mybatis-plus
 * 1.导入依赖
 * 2.配置
 *  2.1.配置数据源
 *   2.1.1导入数据库驱动
 *   2.1.2application.yml配置相关信息
 *  2.2.配置mybatis-plus
 *   2.2.1.使用MapperScan注解配置扫描路径
 *   2.2.1.配置mapper映射文件路径 mybatis-plus.mapper-locations: classpath*:/mapper/** /*.xml,
		classpath*表示扫描所有类路径(包括其他jar包的类路径)
 */
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
