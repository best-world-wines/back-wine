package api.backwine.repository.product;

import api.backwine.model.product.Region;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends GlobalTimestampedRepository<Region, Long> {
}
