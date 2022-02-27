package com.recruitment_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
/*Swagger Implementation for Recruitment Service
* url: http://localhost:8001/swagger-ui/
* */
public class SwaggerConfigRecruitmentService {

    @Bean
    public Docket app(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.recruitment_service"))
                .paths(regex("/recruit.*")).build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Recruitment System using Microservices")
                .description("Second Exposed Service - Recruitment Service Documentation ")
                .version("Spring Boot Version : - 2.3.11.RELEASE , Java Version:- 8")
                .license("Apache Version 2.0")
                .contact(new Contact("Group No 1","#","creativeheaders2511@gmail.com"))
                .build();

    }
}
