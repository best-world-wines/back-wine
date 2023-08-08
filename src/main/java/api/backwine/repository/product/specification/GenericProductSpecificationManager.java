package api.backwine.repository.product.specification;

import api.backwine.model.product.Product;
import java.util.Map;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericProductSpecificationManager<T extends Product>
        implements SpecificationManager<T> {
    private final Map<String, SpecificationProvider<T>> providerMap;

    public GenericProductSpecificationManager(Map<String, SpecificationProvider<T>> providerMap) {
        this.providerMap = providerMap;
    }

    @Override
    public Specification<T> get(String filterKey, String[] params) {
        if (!providerMap.containsKey(filterKey)) {
            throw new RuntimeException("Key " + filterKey
                    + " is not supported for data filtering");
        }
        return providerMap.get(filterKey).getSpecification(params);
    }
}
