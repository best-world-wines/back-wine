package api.backwine.service.product.impl;

import api.backwine.model.product.Grape;
import api.backwine.repository.product.GrapeRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.GrapeService;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl extends GlobalProductService<Grape, Long> implements GrapeService {

    public GrapeServiceImpl(GrapeRepository repository) {
        super(repository);
    }
}
