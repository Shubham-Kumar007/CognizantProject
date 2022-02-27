package com.panel.service.config;

import com.panel.service.model.Interviewer;
import com.panel.service.model.Panel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
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
/*Implementation of Swagger UI for Interview Service*/
@ComponentScan(basePackageClasses = {
        Interviewer.class, Panel.class})
public class SwaggerConfigInterviewService {

    @Bean
    public Docket interview_app(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
               // .apis(RequestHandlerSelectors.basePackage("com.panel_service"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build().apiInfo(metaData());
    }



    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Recruitment System using Microservices")
                .description("Third Exposed Service - Interview Service Documentation ")
                .version("Spring Boot Version : - 2.3.11.RELEASE , Java Version:- 8")
                .license("Apache Version 2.0")
                .contact(new Contact("Kashmira Surana","#","creativeheaders2511@gmail.com"))
                .build();

    }
}
