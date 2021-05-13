package edu.cs335pl.questionnaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("UserController")
                .enable(true)//enable是否启动Swagger，如果是false，则Swagger不能再浏览器中访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.cs335pl.questionnaire.controller"))
                 .build();
    }

    //配置Swagger的信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("M3","https://www.baidu.com/","506264025@qq.com");
        return new ApiInfo(
                "Albatel-Questionnaire",
                "CS335_Project from FZU GROUP M3",
                "v1.0",
                "https://www.baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
