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
 * 3. 逻辑删除
 *   3.1 配置逻辑删除规则
 *   3.2 配置逻辑删除的组件bean
 *   3.3 给bean加上逻辑删除注解@TableLogic
 * 4. JSR303
 *   4.1 给bean添加校验注解
 *   4.2 开启@Valid 校验错误后会有默认的响应
 *   4.3 给校验的bean后紧跟一个BindingResult可以获得校验结果
 *   4.4 分组校验
 *     4.4.1 定义用于区分分组的接口类
 *     4.4.2 给校验注解指定group（如果校验注解没有指定分组，则分组校验时不生效）
 *     4.4.3 使用spring提供的Validated注解，传入要校验的分组参数（如果没有传入分组参数，则没有指定分组的校验注解生效，指定了分组的不生效）
 *   4.5 自定义校验器
 *     4.5.1 编写自定义校验注解
 *     4.5.2 编写自定义校验器（实现ConstraintValidator）
 *     4.5.3 关联自定义校验器和自定义校验注解
 * 5. 统一异常处理
 *   5.1 编写异常处理类，标注@ControllerAdvice注解
 *   5.2 编写异常处理方法，标注@ExceptionHandler 注解，传入要处理的异常类型
 */
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
