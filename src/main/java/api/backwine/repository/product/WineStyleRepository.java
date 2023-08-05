package api.backwine.repository.product;

import api.backwine.model.product.WineStyle;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineStyleRepository extends SoftDeleteRepository<WineStyle, Long> {
}
