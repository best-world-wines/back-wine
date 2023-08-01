package api.backwine.service.impl;

import api.backwine.model.wine.Region;
import api.backwine.repository.RegionRepository;
import api.backwine.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends SoftDeleteGenericServiceImpl<Region, Long>
        implements RegionService {

    public RegionServiceImpl(RegionRepository regionRepository) {
        super(Region.class, regionRepository);
    }
}
