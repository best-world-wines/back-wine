package api.backwine.repository.product;

import api.backwine.model.product.WineStyle;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineStyleRepository extends GlobalTimestampedRepository<WineStyle, Long> {
}
