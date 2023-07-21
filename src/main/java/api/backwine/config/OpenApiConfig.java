//package api.backwine.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;
//import java.util.List;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OpenApiConfig {
//    @Bean
//    public GroupedOpenApi publicUserApi() {
//        return GroupedOpenApi.builder()
//                .group("api")
//                .packagesToScan("/controller")
//                .build();
//    }
//
//    @Bean
//    public OpenAPI customOpenApi(@Value("${application-description}") String appDescription,
//                                 @Value("${application-version}") String appVersion) {
//        return new OpenAPI().info(new Info().title("The Best Wine Shop API")
//                        .version(appVersion)
//                        .description(appDescription)
//                        .license(new License().name("Apache 2.0")
//                                .url("http://springdoc.org"))
//                        .contact(new Contact().name("Dmytro Busyhin")
//                                .email("busyhin.d@gmail.com")
//                                .url("https://github.com/best-world-wines"))
//                        .contact(new Contact().name("Alexander Novikov")
//                                .email("iskamele@gmail.com")
//                                .url("https://github.com/best-world-wines")))
//                .servers(List.of(new Server().url("http://localhost:8080")
//                                .description("Dev service"),
//                        new Server().url("https://api.wine.exisvitae.com")
//                                .description("Beta service")));
//    }
//}
