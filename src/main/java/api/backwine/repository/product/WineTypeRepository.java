package api.backwine.repository.product;

import api.backwine.model.product.WineType;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends GlobalTimestampedRepository<WineType, Long> {
}
