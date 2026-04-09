package br.com.cadastroclientes.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
  name = "bearerAuth",
  type = SecuritySchemeType.HTTP,
  scheme = "bearer"
)
public class SwaggerConfig {

  @Bean
  public OpenAPI getOpenAPI() {

    Contact contact = new Contact();
    contact.name("João Pedro Nascimento");
    contact.email("nascjp.dev@gmail.com");

    Info info =  new Info();
    info.title("Cadastro de Clientes");
    info.version("V1");
    info.description("Aplicação para gerenciamento de cadastro de clientes");
    info.contact(contact);

    return new OpenAPI().info(info);
  }
}
