package financial.dev.simplified_payment_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api de Transferencia Bancaria")
                        .version("1.0.0")
                        .description("Uma Api que realiza cadastro, e transferencia entre contas com valdações"));

    }
}
