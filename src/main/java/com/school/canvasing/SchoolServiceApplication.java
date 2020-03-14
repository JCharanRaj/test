package com.school.canvasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.google.common.base.Predicates;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@RestController
public class SchoolServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SchoolServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceApplication.class, args);
	}

/*	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
		docket.useDefaultResponseMessages(false);
		return docket;
	}*/
//	https://stormpath.com/blog/tutorial-spring-boot-war-files

/*	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.homejiny.wallet.controller"))
				.paths(PathSelectors.any()).build();
	}*/

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.school.canvasing.controller"))
				.paths(PathSelectors.any()).build();
	}
}
