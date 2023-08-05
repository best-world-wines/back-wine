package api.backwine.service.product;

import api.backwine.model.product.Region;
import api.backwine.repository.product.RegionRepository;
import api.backwine.service.impl.SoftDeleteGenericServiceImpl;
import api.backwine.service.product.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends SoftDeleteGenericServiceImpl<Region, Long>
        implements RegionService {

    public RegionServiceImpl(RegionRepository regionRepository) {
        super(Region.class, regionRepository);
    }
}
