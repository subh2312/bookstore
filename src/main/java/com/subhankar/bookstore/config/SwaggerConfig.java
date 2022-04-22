package com.subhankar.bookstore.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket bookstoreApiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.subhankar.bookstore.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(apiMetaData());
    }

    private ApiInfo apiMetaData(){
        return new ApiInfo(
                "Book Store Rest API",
                "All Apis for Bookstore Application",
                "1.0",
                "Term and Condition url",
                new Contact("Bookstore Admin",
                        "https://book-store-react-client.herokuapp.com/",
                        "subhankar@zkteoc.in"),
                "Book Store Licence",
                "licence url",
                Collections.emptyList()

        );
    }
}
