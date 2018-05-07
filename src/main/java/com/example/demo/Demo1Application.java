package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.UserController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class Demo1Application implements EmbeddedServletContainerCustomizer{

	@Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        
        container.setPort(8004);
    }

	public static void main(String[] args) {
		SpringApplication.run(UserController.class, args);
	}
}
