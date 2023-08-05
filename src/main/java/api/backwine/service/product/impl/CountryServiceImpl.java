package api.backwine.service.product.impl;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.repository.product.CountryRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.product.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GenericTimestampedServiceImpl<Country, CountryCode>
        implements CountryService {

    public CountryServiceImpl(CountryRepository countryRepository) {
        super(Country.class, countryRepository);
    }
}
