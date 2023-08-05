package api.backwine.service.product;

import api.backwine.model.product.Grape;
import api.backwine.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public interface GrapeService extends GenericService<Grape, Long> {
}
