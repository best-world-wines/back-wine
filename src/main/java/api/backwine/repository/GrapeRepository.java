package api.backwine.repository;

import api.backwine.model.wine.Grape;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends SoftDeleteRepository<Grape, Long> {
}
