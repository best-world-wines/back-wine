package api.backwine.service.impl;

import api.backwine.model.wine.Wine;
import api.backwine.repository.product.WineRepository;
import api.backwine.service.WineService;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl extends GenericProductServiceImpl<Wine> implements WineService {

    public WineServiceImpl(WineRepository wineRepository) {
        super(Wine.class, wineRepository);
    }

    @Override
    @Transactional
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
}
