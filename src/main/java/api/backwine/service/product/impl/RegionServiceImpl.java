package api.backwine.service.product.impl;

import api.backwine.model.product.Region;
import api.backwine.repository.product.RegionRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends GlobalProductService<Region, Long> implements RegionService {

    public RegionServiceImpl(RegionRepository repository) {
        super(repository);
    }
}
