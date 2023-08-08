package api.backwine.service.product.impl;

import api.backwine.model.product.Grape;
import api.backwine.repository.product.GrapeRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.product.GrapeService;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl extends GenericTimestampedServiceImpl<Grape, Long>
        implements GrapeService {

    public GrapeServiceImpl(GrapeRepository grapeRepository) {
        super(Grape.class, grapeRepository);
    }
}
