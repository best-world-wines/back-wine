package api.backwine.repository.product;

import api.backwine.model.product.Grape;
import api.backwine.repository.abstraction.TimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends TimestampedRepository<Grape, Long> {
}
