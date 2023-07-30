package api.backwine.dto.mapper;

import api.backwine.dto.request.CountryRequestDto;
import api.backwine.dto.response.CountryResponseDto;
import api.backwine.model.Country;
import api.backwine.model.Grape;
import java.util.stream.Collectors;
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
        countryResponseDto.setMostUsedGrapes(country.getMostUsedGrapes()
                .stream()
                .map(grapeMapper::toDto)
                .toList());
        return countryResponseDto;
    }
}