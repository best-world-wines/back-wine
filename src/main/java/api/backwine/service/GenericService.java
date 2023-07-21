package api.backwine.service;

import java.util.List;

public interface GenericService<M, I> {
    M create(M m);

    M getById(I id);

    List<M> getAll();

    boolean deleteById(I id);

    M update(I id, M m);
}
