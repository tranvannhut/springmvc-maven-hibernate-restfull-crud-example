package com.nay.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * config when load website 
 * @author nhutt
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.nay.spring.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

}
