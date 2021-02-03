package com.mindskip.xzs.configuration.spring.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableKnife4j
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket adminServerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("doc")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mindskip.xzs.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .globalOperationParameters(this.getGlobalOperationParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:8000/")
                .version("1.0")
                .build();
    }

    private List<Parameter> getGlobalOperationParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("Cookie")
                .description("Cookie, 值为 SESSION=xxx")
                .modelRef(new ModelRef("string"))
                .required(false)
                .parameterType("header")
                .build());
        return parameters;
    }
}
