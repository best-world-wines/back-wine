package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.RegionRequestDto;
import api.backwine.dto.response.product.RegionResponseDto;
import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.model.product.Region;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper implements GlobalMapper<Region, RegionRequestDto, RegionResponseDto> {

    @Override
    public Region toModel(RegionRequestDto regionRequestDto) {
        Region region = new Region();
        region.setName(regionRequestDto.getName());
        Country country = new Country();
        country.setCode(CountryCode.valueOf(regionRequestDto.getCountryCode()));
        region.setCountry(country);
        region.setBackgroundImage(regionRequestDto.getBackgroundImage());
        return region;
    }

    @Override
    public RegionResponseDto toDto(Region region) {
        RegionResponseDto regionResponseDto = new RegionResponseDto();
        regionResponseDto.setId(region.getId());
        regionResponseDto.setName(region.getName());
        regionResponseDto.setCountry(region.getCountry());
        regionResponseDto.setBackgroundImage(region.getBackgroundImage());
        return regionResponseDto;
    }
}
