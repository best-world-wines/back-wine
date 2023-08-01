package api.backwine.service.product.impl;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.repository.product.CountryRepository;
import api.backwine.service.product.CountryService;
import api.backwine.service.product.GlobalProductService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GlobalProductService<Country, CountryCode>
        implements CountryService {

    public CountryServiceImpl(CountryRepository repository) {
        super(repository);
    }
}
