package api.backwine.repository;

import api.backwine.model.wine.Region;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends SoftDeleteRepository<Region, Long> {
}
