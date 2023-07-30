package api.backwine.repository;

import api.backwine.model.WineType;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends SoftDeleteRepository<WineType, Long> {
}
