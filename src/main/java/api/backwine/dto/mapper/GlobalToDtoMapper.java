package api.backwine.dto.mapper;

public interface GlobalToDtoMapper<ENTITY, RESPONSE> {

    RESPONSE toDto(ENTITY entity);
}
