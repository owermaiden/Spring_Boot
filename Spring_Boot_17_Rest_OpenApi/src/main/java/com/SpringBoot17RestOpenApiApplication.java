package com;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot17RestOpenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot17RestOpenApiApplication.class, args);
    }

    // info swagger....
    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .info(new Info().title("Cinema Application")
                .version("v1")
                .description("Selling online cinema tickets"));
    }

}
