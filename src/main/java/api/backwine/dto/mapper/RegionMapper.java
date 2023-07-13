package api.backwine.dto.mapper;

import api.backwine.dto.request.RegionRequestDto;
import api.backwine.dto.response.RegionResponseDto;
import api.backwine.model.Country;
import api.backwine.model.Region;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {

    public Region toModel(RegionRequestDto regionRequestDto) {
        Region region = new Region();
        region.setName(regionRequestDto.getName());
        Country country = new Country();
        country.setCode(regionRequestDto.getCountryCode());
        region.setCountry(country);
        region.setBackgroundImage(regionRequestDto.getBackgroundImage());
        return region;
    }

    public RegionResponseDto toDto(Region region) {
        RegionResponseDto regionResponseDto = new RegionResponseDto();
        regionResponseDto.setId(region.getId());
        regionResponseDto.setName(region.getName());
        regionResponseDto.setCountry(region.getCountry());
        regionResponseDto.setBackgroundImage(region.getBackgroundImage());
        return regionResponseDto;
    }
}
