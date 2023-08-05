package api.backwine.service.product;

import api.backwine.model.product.Country;
import api.backwine.repository.product.CountryRepository;
import api.backwine.service.impl.SoftDeleteGenericServiceImpl;
import api.backwine.service.product.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends SoftDeleteGenericServiceImpl<Country, String>
        implements CountryService {

    public CountryServiceImpl(CountryRepository countryRepository) {
        super(Country.class, countryRepository);
    }
}
