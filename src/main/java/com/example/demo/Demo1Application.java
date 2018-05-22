package com.example.demo;

import config.GlobalCorsConfig;
import controller.AddDeviceController;
import controller.DeviceDetailController;
import controller.MeasureController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.UserController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@Import(GlobalCorsConfig.class)
public class Demo1Application implements EmbeddedServletContainerCustomizer{

	@Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        
        container.setPort(8004);
    }

	public static void main(String[] args) {
		SpringApplication.run(UserController.class, args);
//		SpringApplication.run(AddDeviceController.class, args);
//
//		SpringApplication.run(MeasureController.class, args);
//
//		SpringApplication.run(DeviceDetailController.class, args);

	}
}
