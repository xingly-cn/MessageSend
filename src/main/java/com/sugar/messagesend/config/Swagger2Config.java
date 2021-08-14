package com.sugar.messagesend.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicates;
import io.swagger.models.auth.In;
import jdk.internal.util.xml.impl.Pair;
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

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Description：启用knife4j
 * @Auther： 一枚方糖
 * @Date： /08/14/19:30/
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MessageSend接口文档")
                .contact(new Contact("一枚方糖", "www.asugar.cn", "xiaoheikeji@vip.qq.com"))
                .description("集成多种消息推送平台，为消息而生。")
                .termsOfServiceUrl("www.asugar.cn")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("v1.0")
                .build();
    }
}
