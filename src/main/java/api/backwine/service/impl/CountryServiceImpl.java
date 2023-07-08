package api.backwine.service.impl;

import api.backwine.model.Country;
import api.backwine.repository.CountryRepository;
import api.backwine.service.CountryService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getByCode(String code) {
        return countryRepository.findById(code).orElseThrow(() ->
                new NoSuchElementException("Can't get country by code " + code));
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public boolean deleteByCode(String code) {
        Country country = countryRepository.findById(code).orElseThrow(() ->
                new NoSuchElementException("Can't delete country by code" + code));
        country.setDeleted(true);
        countryRepository.save(country);
        return true;
    }

    @Override
    public Country update(String code, Country country) {
        country.setCode(code);
        return countryRepository.save(country);
    }
}
