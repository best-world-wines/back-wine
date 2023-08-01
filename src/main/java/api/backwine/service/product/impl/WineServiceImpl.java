package api.backwine.service.product.impl;

import api.backwine.model.product.Wine;
import api.backwine.repository.product.WineRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.WineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl extends GlobalProductService<Wine, Long> implements WineService {
    private final WineRepository repository;

    public WineServiceImpl(WineRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<Wine> getAll(Pageable pageable) {
        return repository.findAllByDeletingDateIsNull(pageable);
    }
}
