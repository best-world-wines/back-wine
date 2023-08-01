package api.backwine.service;

import api.backwine.model.wine.Grape;
import org.springframework.stereotype.Service;

@Service
public interface GrapeService extends GenericService<Grape, Long> {
}
