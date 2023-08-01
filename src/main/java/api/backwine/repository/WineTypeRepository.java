package api.backwine.repository;

import api.backwine.model.wine.WineType;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends SoftDeleteRepository<WineType, Long> {
}
