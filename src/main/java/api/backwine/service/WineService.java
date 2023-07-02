package api.backwine.service;

import api.backwine.model.Wine;

public interface WineService extends AbstractService<Wine> {
    boolean deleteById(Long wineId);
}
