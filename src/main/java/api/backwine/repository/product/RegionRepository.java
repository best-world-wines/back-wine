package api.backwine.repository.product;

import api.backwine.model.product.Region;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends SoftDeleteRepository<Region, Long> {
}
