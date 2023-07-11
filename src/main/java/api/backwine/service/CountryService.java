package api.backwine.service;

import api.backwine.model.Country;
import java.util.List;

public interface CountryService {
    Country create(Country country);

    Country getByCode(String code);

    List<Country> getAll();

    boolean deleteByCode(String code);

    Country update(String code, Country country);
}
