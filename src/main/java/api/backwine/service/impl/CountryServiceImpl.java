package api.backwine.service.impl;

import api.backwine.model.Country;
import api.backwine.repository.CountryRepository;
import api.backwine.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends SoftDeleteGenericServiceImpl<Country, String>
        implements CountryService {

    public CountryServiceImpl(CountryRepository countryRepository) {
        super(Country.class, countryRepository);
    }
}
