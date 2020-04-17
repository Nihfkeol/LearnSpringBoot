package com.nihfkeol;

import com.nihfkeol.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void testHello(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void testLog(){

         //日志级别：
         //由低到高 trace<debug<info<warn<error
         //可以调整输出的日志级别，日志就只会在这个级别以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //Spring Boot默认给我们使用时info级别的
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }
}
