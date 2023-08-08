package api.backwine.repository.product;

import api.backwine.model.product.WineType;
import api.backwine.repository.abstraction.TimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends TimestampedRepository<WineType, Long> {
}
