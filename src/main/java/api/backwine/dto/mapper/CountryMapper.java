package api.backwine.dto.mapper;

import api.backwine.dto.request.CountryRequestDto;
import api.backwine.dto.response.CountryResponseDto;
import api.backwine.model.Country;
import api.backwine.model.Grape;
import api.backwine.model.Region;
import api.backwine.repository.CountryRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    private final CountryRepository countryRepository;

    public CountryMapper(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country toModel(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        country.setName(countryRequestDto.getName());
        country.setRegions(countryRequestDto.getRegionsIds().stream()
                .map(i -> {
                    Region region = new Region();
                    region.setId(i);
                    return region;
                })
                .collect(Collectors.toSet()));
        country.setGrapes(countryRequestDto.getGrapesIds()
                .stream()
                .map(i -> {
                    Grape grape = new Grape();
                    grape.setId(i);
                    return grape;
                })
                .collect(Collectors.toSet()));
        return country;
    }

    public CountryResponseDto toDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setCode(country.getCode());
        countryResponseDto.setName(country.getName());
        countryResponseDto.setRegions(country.getRegions());
        countryResponseDto.setGrapes(country.getGrapes());
        return countryResponseDto;
    }
}
