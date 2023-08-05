package api.backwine.dto.mapper.product;

import api.backwine.dto.request.product.CountryRequestDto;
import api.backwine.dto.response.product.CountryResponseDto;
import api.backwine.model.product.Country;
import api.backwine.model.product.Grape;
import java.util.stream.Collectors;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    private final GrapeMapper grapeMapper;

    public CountryMapper(GrapeMapper grapeMapper) {
        this.grapeMapper = grapeMapper;
    }

    public Country toModel(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        country.setName(countryRequestDto.getName());
        country.setMostUsedGrapes(countryRequestDto.getMostUsedGrapesIds()
                .stream()
                .map(i -> {
                    Grape grape = new Grape();
                    grape.setId(i);
                    return grape;
                })
                .collect(Collectors.toList()));
        return country;
    }

    public CountryResponseDto toDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setCode(country.getId());
        countryResponseDto.setName(country.getName());
        if (Hibernate.isInitialized(country.getMostUsedGrapes())) {
            countryResponseDto.setMostUsedGrapes(country.getMostUsedGrapes()
                    .stream()
                    .map(grapeMapper::toDto)
                    .toList());
        }
        return countryResponseDto;
    }
}
