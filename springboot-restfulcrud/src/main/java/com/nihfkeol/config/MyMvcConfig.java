package com.nihfkeol.config;

import com.nihfkeol.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        //定制嵌入式的Servlet容器相关的规则
        return (WebServerFactoryCustomizer<ConfigurableWebServerFactory>) factory -> factory.setPort(8083);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /ok 请求 来到success
        registry.addViewController("/ok").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源； *.css，*.js
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/index.html","/user/login","/webjars/**","/static/**");
            }

        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
