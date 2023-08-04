package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.Country;
import api.backwine.model.wine.Region;
import api.backwine.model.wine.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CountrySpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "countryIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Wine> getSpecification(String[] countries) {
        return (root, query, cb) -> {
            Join<Wine, Region> regionSetJoin = root.join("regions", JoinType.LEFT);
            Join<Region, Country> countryJoin = regionSetJoin.join("country", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(countryJoin.get(FIELD_NAME));
            for (String country : countries) {
                predicate.value(country);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
