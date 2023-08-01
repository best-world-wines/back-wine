package api.backwine.repository;

import api.backwine.model.wine.WineStyle;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineStyleRepository extends SoftDeleteRepository<WineStyle, Long> {
}
