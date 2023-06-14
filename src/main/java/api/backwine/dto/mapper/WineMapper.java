package api.backwine.dto.mapper;

import aj.org.objectweb.asm.ModuleVisitor;
import api.backwine.dto.api.ApiResponseDto;
import api.backwine.model.Wine;
import org.springframework.stereotype.Component;

@Component
public class WineMapper {
    public Wine parseApiWineResponseDto(ApiResponseDto dto) {
        Wine wine = new Wine();
        wine.setDescription(dto.getDescription());
        wine.setName(dto.getName());
        return wine;
    }
}
