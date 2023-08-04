package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.wine.Wine;
import api.backwine.repository.product.cpecification.GenericProductSpecificationManager;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WineSpecificationManager extends GenericProductSpecificationManager<Wine> {
    public WineSpecificationManager(List<SpecificationProvider<Wine>> wineSpecifications) {
        super(wineSpecifications.stream().collect(
                Collectors.toMap(SpecificationProvider::getFilterKey, Function.identity())));
    }
}
