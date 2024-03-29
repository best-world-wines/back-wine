package api.backwine.repository.product.specification.wine;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.model.product.Region;
import api.backwine.model.product.Wine;
import api.backwine.repository.product.specification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CountrySpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "countryIn";
    private static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] countryIds) {
        return (root, query, cb) -> {
            Join<Wine, Region> regionSetJoin = root.join("regions", JoinType.LEFT);
            Join<Region, Country> countryJoin = regionSetJoin.join("country", JoinType.INNER);
            CriteriaBuilder.In<CountryCode> predicate = cb.in(countryJoin.get(FIELD_NAME));
            for (String id : countryIds) {
                predicate.value(CountryCode.valueOf(id.toUpperCase()));
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
