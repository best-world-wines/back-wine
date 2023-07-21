package api.backwine.service;

import java.util.List;

public interface AbstractService<T> {
    T create(T t);

    T getById(Long id);

    List<T> getAll();

    boolean deleteById(Long id);

    T update(Long id, T t);
}

