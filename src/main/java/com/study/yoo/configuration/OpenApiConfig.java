package com.study.yoo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Yoo")
                        .version("0.1.1")
                        .description("API para atender o cliente Yoo")
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Yoo Project Study")
                        )
                );
    }
}
