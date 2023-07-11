package api.backwine.dto.mapper;

import api.backwine.dto.request.GrapeRequestDto;
import api.backwine.dto.response.GrapeResponseDto;
import api.backwine.model.Grape;
import api.backwine.repository.GrapeRepository;
import org.springframework.stereotype.Component;

@Component
public class GrapeMapper {
    private final GrapeRepository grapeRepository;

    public GrapeMapper(GrapeRepository grapeRepository) {
        this.grapeRepository = grapeRepository;
    }

    public Grape toModel(GrapeRequestDto grapeRequestDto) {
        Grape grape = new Grape();
        grape.setName(grapeRequestDto.getName());
        return grape;
    }

    public GrapeResponseDto toDto(Grape grape) {
        GrapeResponseDto grapeResponseDto = new GrapeResponseDto();
        grapeResponseDto.setId(grape.getId());
        grapeResponseDto.setName(grape.getName());
        return grapeResponseDto;
    }
}
