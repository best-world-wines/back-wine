package api.backwine.service.impl;

import api.backwine.model.wine.Grape;
import api.backwine.repository.GrapeRepository;
import api.backwine.service.GrapeService;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl extends SoftDeleteGenericServiceImpl<Grape, Long>
        implements GrapeService {

    public GrapeServiceImpl(GrapeRepository grapeRepository) {
        super(Grape.class, grapeRepository);
    }
}
