package api.backwine.service.impl;

import api.backwine.model.Product;
import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import api.backwine.service.WineService;
import java.util.List;
import org.hibernate.Hibernate;
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
    public Wine getById(Long id) {
        Wine wine = super.getById(id);
        Hibernate.initialize(wine.getWineType());
        Hibernate.initialize(wine.getWineStyle());
        Hibernate.initialize(wine.getMeals());
        Hibernate.initialize(wine.getGrapes());
        Hibernate.initialize(wine.getRegions());
        Hibernate.initialize(wine.getWineStyle().getInterestingFacts());
        return wine;
    }

    @Override
    public Page<Wine> getAll(Pageable pageable) {
        return wineRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return super.getById(id);
    }

    @Override
    public boolean updateQuantity(Long id, Integer quantity) {
        return wineRepository.updateQuantity(id, quantity);
    }

    @Override
    public boolean updateAvailability(List<Long> ids, Boolean isAvailable) {
        return wineRepository.updateAvailability(ids, isAvailable);
    }

    @Override
    public Integer getActualQuantity(Long id) {
        return wineRepository.getActualQuantity(id);
    }

    @Override
    public Class<Wine> getType() {
        return Wine.class;
    }
}
