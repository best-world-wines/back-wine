package api.backwine.dto.mapper;

public interface GlobalToModelMapper<ENTITY, REQUEST> {

    ENTITY toModel(REQUEST request);
}
