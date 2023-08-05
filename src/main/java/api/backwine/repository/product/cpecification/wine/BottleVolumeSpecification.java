package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.product.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BottleVolumeSpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "volumeIn";
    private static final String FIELD_NAME = "bottleVolume";

    @Override
    public Specification<Wine> getSpecification(String[] volumes) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Double> predicate = cb.in(root.get(FIELD_NAME));
            for (String volume : volumes) {
                predicate.value(Double.valueOf(volume));
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
