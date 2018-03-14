package com.cxn.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix=DemoProperties.DEMO_PREFIX)
public class DemoProperties {

	// 意思是读取配置文件中前缀为DEMO_PREFIX的配置
	public static final String DEMO_PREFIX = "com.cxn.demo.starter";
	
	// 自定义属性
	private String param1;
	private String param2;
	
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
}
