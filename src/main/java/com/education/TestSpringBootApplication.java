package com.education;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * 
 * @author lsk
 *
 */
@SpringBootApplication
@MapperScan("com.yajun.longyj.mapper.*")
public class TestSpringBootApplication extends SpringBootServletInitializer{
	//SpringBootServletInitializer
    
	private static Logger logger = LoggerFactory.getLogger(TestSpringBootApplication.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TestSpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class, args);
        logger.info("SpringBoot Start Success");
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    SpringBoot启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
    
}

