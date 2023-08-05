package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.CountryRequestDto;
import api.backwine.dto.response.product.CountryResponseDto;
import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.model.product.Grape;
import java.util.stream.Collectors;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper
        implements GlobalMapper<Country, CountryRequestDto, CountryResponseDto> {
    private final GrapeMapper grapeMapper;

    public CountryMapper(GrapeMapper grapeMapper) {
        this.grapeMapper = grapeMapper;
    }

    @Override
    public Country toModel(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        try {
            country.setId(CountryCode.valueOf(countryRequestDto.getId()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't find country code for: "
                    + countryRequestDto.getId(), e);
        }
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

    @Override
    public CountryResponseDto toDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setId(country.getId().name());
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
