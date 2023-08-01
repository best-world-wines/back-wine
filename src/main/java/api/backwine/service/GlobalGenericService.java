package api.backwine.service;

import java.util.List;

public interface GlobalGenericService<ENTITY, ID> {

    ENTITY create(ENTITY t);

    ENTITY getById(ID id);

    List<ENTITY> getAll();

    boolean deleteById(ID id);

    ENTITY update(ID id, ENTITY t);
}
