package com.springbootTest;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.springbootTest", "com.ruby"})
public class Chapter01Application {

	public static void main(String[] args) {
//		SpringApplication.run(Chapter01Application.class, args);
		SpringApplication application =
				new SpringApplication(Chapter01Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);		// WebApplicationType을 SERVLET으로 할 경우 톰캣 서버 동작.
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
