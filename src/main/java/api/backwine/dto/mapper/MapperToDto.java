package api.backwine.dto.mapper;

public interface MapperToDto<M, D> {
    D toDto(M m);
}
