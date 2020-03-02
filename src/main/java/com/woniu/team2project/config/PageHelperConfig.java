package com.woniu.team2project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;
/**
 * pageHelper插件配置类
 * @author JMiao
 *
 */

@Configuration
public class PageHelperConfig {
    @Bean
    @ConfigurationProperties(prefix="pagehelper")
    public PageHelper pageHelper(){
        return new PageHelper();
    }
}
