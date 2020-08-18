package com.bjpowernode.springboot;

import com.bjpowernode.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@SpringBootTest
class FirstSpringbootApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testHelloService() {
        Boolean b1 = ioc.containsBean("helloService");
        Boolean b2 = ioc.containsBean("helloSpringBootService");
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void contextLoads2() {
        //System.out.println(person);

        //日志的级别，由低到高：好处是可以调整输出的日志级别，配置了日志级别之后，日志就只会在这个级别及之后的高级别中生效
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //SpringBoot默认给我们使用的是info级别,没有指定级别的就使用SpringBoot默认规定的级别（root级别）
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }


}
