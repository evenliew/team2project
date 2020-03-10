package com.woniu.team2project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.woniu.team2project.interceptor.LoginHandlerInterceptor;

@Configuration
public class MyWebMvcConfig{
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// 自定义映射路径
				/*
				 * registry.addViewController("/").setViewName("login");
				 * registry.addViewController("/login.html").setViewName("login");
				 * registry.addViewController("/user").setViewName("index");
				 */

			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) { //不拦截
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/*",
						"/system/index/index.html", "/user/login", "/css/**");

			} 
		};
	}
}
