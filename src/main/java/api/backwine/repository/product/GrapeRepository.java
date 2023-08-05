package api.backwine.repository.product;

import api.backwine.model.product.Grape;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends SoftDeleteRepository<Grape, Long> {
}
