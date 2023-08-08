package api.backwine.repository.product.specification;

import api.backwine.model.product.Product;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ProductSpecificationManager extends GenericProductSpecificationManager<Product>
        implements SpecificationManager<Product> {
    public ProductSpecificationManager(List<SpecificationProvider<Product>> productSpecifications) {
        super(productSpecifications.stream().collect(
                Collectors.toMap(SpecificationProvider::getFilterKey, Function.identity())));
    }
}
