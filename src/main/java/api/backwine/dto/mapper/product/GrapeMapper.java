package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.GrapeRequestDto;
import api.backwine.dto.response.product.GrapeResponseDto;
import api.backwine.model.product.Grape;
import org.springframework.stereotype.Component;

@Component
public class GrapeMapper implements GlobalMapper<Grape, GrapeRequestDto, GrapeResponseDto> {

    @Override
    public Grape toModel(GrapeRequestDto grapeRequestDto) {
        Grape grape = new Grape();
        grape.setName(grapeRequestDto.getName());
        return grape;
    }

    @Override
    public GrapeResponseDto toDto(Grape grape) {
        GrapeResponseDto grapeResponseDto = new GrapeResponseDto();
        grapeResponseDto.setId(grape.getId());
        grapeResponseDto.setName(grape.getName());
        return grapeResponseDto;
    }
}
