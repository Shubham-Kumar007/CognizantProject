package com.consultancy_service.config;

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

/*Swagger Implementation for Consultancy Service
 * url: http://localhost:8000/swagger-ui/
 * */
public class SwaggerConfigConsultancyService {

    @Bean
    public Docket app(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.consultancy_service"))
                .paths(regex("/candidate.*")).build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Recruitment System using Microservices")
                .description("First Exposed Service - Consultancy Service Documentation ")
                .version("Spring Boot Version : - 2.3.11.RELEASE , Java Version:- 8")
                .license("Apache Version 2.0")
                .contact(new Contact("Kashmira Surana","#","creativeheaders2511@gmail.com"))
                .build();

    }
}
