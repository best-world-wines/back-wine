package api.backwine.dto.mapper;

public interface MapperToModel<M, R> {
    M toModel(R r);
}
