package api.backwine.service.product.impl;

import api.backwine.model.product.Wine;
import api.backwine.repository.product.WineRepository;
import api.backwine.repository.product.specification.SpecificationManager;
import api.backwine.repository.product.pageable.PageManager;
import api.backwine.service.product.WineService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WineServiceImpl extends GenericProductServiceImpl<Wine> implements WineService {
    public WineServiceImpl(WineRepository wineRepository, PageManager pageManager,
                           SpecificationManager<Wine> specificationManager) {
        super(Wine.class, pageManager, wineRepository, specificationManager);
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
