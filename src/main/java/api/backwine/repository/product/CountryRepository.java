package api.backwine.repository.product;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.repository.abstraction.TimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends TimestampedRepository<Country, CountryCode> {
}
