package api.backwine.service;

import api.backwine.model.Wine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WineService extends GenericService<Wine, Long> {
    Page<Wine> getAll(Pageable pageable);
}
