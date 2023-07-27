package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.CountryRequestDto;
import api.backwine.dto.response.product.CountryResponseDto;
import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.model.product.Grape;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper
        implements GlobalMapper<Country, CountryRequestDto, CountryResponseDto> {

    @Override
    public Country toModel(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        try {
            country.setCode(CountryCode.valueOf(countryRequestDto.getCode()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't find country code for: "
                    + countryRequestDto.getCode(), e);
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
        countryResponseDto.setCode(country.getCode().toString());
        countryResponseDto.setName(country.getName());
        countryResponseDto.setMostUsedGrapes(country.getMostUsedGrapes());
        return countryResponseDto;
    }
}
