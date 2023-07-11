package api.backwine.dto.mapper;

import api.backwine.dto.request.RegionRequestDto;
import api.backwine.dto.response.RegionResponseDto;
import api.backwine.model.Region;
import api.backwine.repository.RegionRepository;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {
    private final RegionRepository regionRepository;

    public RegionMapper(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region toModel(RegionRequestDto regionRequestDto) {
        Region region = new Region();
        region.setName(regionRequestDto.getName());
        region.setBackgroundImage(regionRequestDto.getBackgroundImage());
        return region;
    }

    public RegionResponseDto toDto(Region region) {
        RegionResponseDto regionResponseDto = new RegionResponseDto();
        regionResponseDto.setId(region.getId());
        regionResponseDto.setName(region.getName());
        regionResponseDto.setBackgroundImage(region.getBackgroundImage());
        return regionResponseDto;
    }
}
