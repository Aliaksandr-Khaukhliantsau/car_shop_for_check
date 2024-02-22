package car.shop.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI cutomOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Car Shop API")
                        .version("1.0.0")
                        .description("This is the Car Shop API"));
    }

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("custom-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    @Primary
    public SwaggerUiConfigProperties swaggerUiConfigProperties() {
        SwaggerUiConfigProperties properties = new SwaggerUiConfigProperties();
        properties.setUrl("/v3/api-docs/custom-api");
        return properties;
    }
}
