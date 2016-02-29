package com.linzhijia.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * 
 * @author 林智佳 20160229
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	
    public static void main(String[] args) {
    	new StartupRunner();
        SpringApplication.run(Application.class, args);
    }
}
