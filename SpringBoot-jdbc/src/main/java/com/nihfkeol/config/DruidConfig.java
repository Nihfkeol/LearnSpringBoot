package com.nihfkeol.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    /**
     * SpringBoot 2.0之后导入如下依赖，全部配置转移到配置文件中配置了
     * <dependency>
     *     <groupId>com.alibaba</groupId>
     *     <artifactId>druid-spring-boot-starter</artifactId>
     *     <version>1.1.21</version>
     * </dependency>
     * 如果导入的是
     * <dependency>
     *    <groupId>com.alibaba</groupId>
     *    <artifactId>druid</artifactId>
     *    <version>1.1.21</version>
     * </dependency>
     * 可使用这里的方法结合yml文件中的配置
     */


//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druid(){
//        return new DruidDataSource();
//    }
//
//    //配置Druid的监控
//    //1、配置一个管理后台的Servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        Map<String, String> initParams = new HashMap<>();
//        initParams.put("loginUsername", "root");
//        initParams.put("loginPassword", "root");
//        //默认允许所有
//        initParams.put("allow", "");
//        //拒绝谁访问
////        initParams.put("deny","");
//        bean.setInitParameters(initParams);
//        return bean;
//    }
//
//    //2、配置一个web监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(new WebStatFilter());
//        Map<String, String> initParams = new HashMap<>();
//        initParams.put("exclusions", "*.js, *.css, /druid/*");
//        bean.setInitParameters(initParams);
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        return bean;
//    }
}
