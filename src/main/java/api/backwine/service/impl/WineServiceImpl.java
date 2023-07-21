package api.backwine.service.impl;

import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import api.backwine.service.WineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl extends SoftDeleteGenericServiceImpl<Wine, Long>
        implements WineService {
    private final WineRepository wineRepository;

    public WineServiceImpl(WineRepository wineRepository) {
        super(Wine.class, wineRepository);
        this.wineRepository = wineRepository;
    }

    @Override
    protected Wine putId(Long id, Wine wine) {
        wine.setId(id);
        return wine;
    }

    @Override
    protected Wine setDeleted(Wine wine) {
        wine.setDeleted(true);
        return wine;
    }

    @Override
    public Page<Wine> getAll(Pageable pageable) {
        return wineRepository.findAllByIsDeletedFalse(pageable);
    }
}
