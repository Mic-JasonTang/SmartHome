package com.smarthome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.smarthome.component.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(ApiInfo());
    }

    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
            .title("智慧星平台 API")//大标题
            .description("提供Restful接口")//详细描述
            .version("1.0")//版本
            .contact(new Contact("唐洋", "", "ty_2016@foxmail.com"))//作者
            .license("The Apache License, Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .build();
    }
}