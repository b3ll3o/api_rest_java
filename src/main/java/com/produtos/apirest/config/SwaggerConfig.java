package com.produtos.apirest.config;

import java.util.ArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

  @Bean
  public Docket productApi(){
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
      .paths(regex("/api.*"))
      .build()
      .apiInfo(metaInfo());
  }

  private ApiInfo metaInfo() {
    return new ApiInfo(
      "Produtos api rest", 
      "api rest de cadastro de produtos", 
      "1.0",
      "Terms od Service",
      new Contact("Leonardo Rocha Andreazzi", "https://github.com/b3ll3o", "leonardoandreazzi@gmail.com"),
      "Apache License Version 2", "https://www.apache.org/license.html", new ArrayList<VendorExtension>());
  }
}