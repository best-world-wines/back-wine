package api.backwine.repository.product;

import api.backwine.model.product.Grape;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends GlobalTimestampedRepository<Grape, Long> {
}
