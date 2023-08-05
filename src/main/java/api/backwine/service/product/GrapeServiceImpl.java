package api.backwine.service.product;

import api.backwine.model.product.Grape;
import api.backwine.repository.product.GrapeRepository;
import api.backwine.service.impl.SoftDeleteGenericServiceImpl;
import api.backwine.service.product.GrapeService;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl extends SoftDeleteGenericServiceImpl<Grape, Long>
        implements GrapeService {

    public GrapeServiceImpl(GrapeRepository grapeRepository) {
        super(Grape.class, grapeRepository);
    }
}
