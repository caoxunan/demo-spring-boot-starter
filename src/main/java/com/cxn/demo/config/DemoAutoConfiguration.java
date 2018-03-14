package com.cxn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cxn.demo.service.DemoService;
import com.cxn.demo.service.impl.DemoServiceImpl;

@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

	@Autowired
	private DemoProperties properties;
	
	@Bean
	// 自动构建bean的条件
	// 条件一：在spring中没有DemoService.class文件的时候
	@ConditionalOnMissingBean(DemoService.class)
	// 条件二：配置文件中配置了指定的参数-->DemoProperties.DEMO_PREFIX.enabled=true才会触发自动装配
	@ConditionalOnProperty(prefix = DemoProperties.DEMO_PREFIX, value = "enabled", havingValue = "true")
	public DemoService demoService(){
		// 可以new一个对象然后手动赋值，也可以通过构造方法的方式注入值
		DemoServiceImpl demoService = new DemoServiceImpl();
		demoService.setParam1(properties.getParam1());
		demoService.setParam2(properties.getParam2());
		return demoService;
	}
	
}
