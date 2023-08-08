package api.backwine;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("api.backwine.model")
@OpenAPIDefinition(
        info = @Info(
                title = "The Best Wine Shop",
                version = "1.0.0",
                description = "Documentation for API Best World Wines shop.",
                contact = @Contact(
                        name = "Dmytro Busyhin and Alexander Novikov",
                        email = "busyhin.d@gmail.com, iskamele@gmail.com",
                        url = "https://github.com/best-world-wines"),
                license = @License(name = "License @2023", url = "")
        )
)

public class BackWineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackWineApplication.class, args);
    }
}
