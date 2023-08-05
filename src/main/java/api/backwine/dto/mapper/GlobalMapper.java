package api.backwine.dto.mapper;

public interface GlobalMapper<ENTITY, REQUEST, RESPONSE>
        extends GlobalToDtoMapper<ENTITY, RESPONSE>, GlobalToModelMapper<ENTITY, REQUEST> {
}
