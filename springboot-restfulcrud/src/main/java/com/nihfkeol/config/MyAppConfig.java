package com.nihfkeol.config;

import com.nihfkeol.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明当前类是一个配置类
 * 替代之前的Spring配置文件
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
