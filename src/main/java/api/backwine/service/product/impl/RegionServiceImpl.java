package api.backwine.service.product.impl;

import api.backwine.model.product.Region;
import api.backwine.repository.product.RegionRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.product.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends GenericTimestampedServiceImpl<Region, Long>
        implements RegionService {

    public RegionServiceImpl(RegionRepository regionRepository) {
        super(Region.class, regionRepository);
    }
}
