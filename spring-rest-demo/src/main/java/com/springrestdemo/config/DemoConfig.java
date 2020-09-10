package com.springrestdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class represents the spring.xml class ie 
 * here we are implementing the No XML based Configuration
 * @author SREE
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.springrestdemo")
public class DemoConfig {
	

}
