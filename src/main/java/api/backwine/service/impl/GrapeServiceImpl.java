package api.backwine.service.impl;

import api.backwine.model.Grape;
import api.backwine.repository.GrapeRepository;
import api.backwine.service.GrapeService;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl extends SoftDeleteGenericServiceImpl<Grape, Long>
        implements GrapeService {

    public GrapeServiceImpl(GrapeRepository grapeRepository) {
        super(Grape.class, grapeRepository);
    }

    @Override
    protected Grape putId(Long id, Grape grape) {
        grape.setId(id);
        return grape;
    }

    @Override
    protected Grape setDeleted(Grape grape) {
        grape.setDeleted(true);
        return grape;
    }
}
