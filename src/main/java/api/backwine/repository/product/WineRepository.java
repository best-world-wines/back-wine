package api.backwine.repository.product;

import api.backwine.model.product.Wine;
import api.backwine.repository.GlobalPageableRepository;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends GlobalTimestampedRepository<Wine, Long>,
        GlobalPageableRepository<Wine, Long> {
}
