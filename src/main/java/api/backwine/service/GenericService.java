package api.backwine.service;

import java.util.List;

public interface GenericService<ENTITY, ID> {
    ENTITY create(ENTITY entity);

    ENTITY getById(ID id);

    List<ENTITY> getAll();

    boolean deleteById(ID id);

    ENTITY update(ID id, ENTITY entity);
}
