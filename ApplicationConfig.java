package com.qsp.springbootemployee.util;

import java.util.ArrayList;
import java.util.List;

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
public class ApplicationConfig {
	// url of swagger http://localhost:8080/swagger-ui.html#
    @Bean
	public Docket getDocket() {
		
    	Contact contact =new Contact("Q spiders", "http.qspides.com", "qspideres.com");
    	List<VendorExtension> list = new ArrayList<VendorExtension>();
    	ApiInfo apiInfo =new ApiInfo("employee management", null, null, null, contact, null, null, list);
    	
    	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.qsp.springbootemployee")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
    	
    			
    		
    }			
	
}
