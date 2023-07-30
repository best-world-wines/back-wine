package api.backwine.repository.product;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends GlobalTimestampedRepository<Country, CountryCode> {
}
