package api.backwine.config;

import api.backwine.model.Product;
import api.backwine.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private final List<ProductService<? extends Product, ?>> productServices;

    public ApplicationConfig(List<ProductService<? extends Product, ?>> productServices) {
        this.productServices = productServices;
    }

    @Bean
    public Map<Class<? extends Product>, ProductService<Product, Long>> getProductServicesMap() {
        Map<Class<? extends Product>, ProductService<Product, Long>> productServicesMap =
                new HashMap<>();
        for (ProductService<? extends Product, ?> productService : productServices) {
            productServicesMap.put(
                    productService.getType(), (ProductService<Product, Long>) productService);
        }
        return productServicesMap;
    }
}
