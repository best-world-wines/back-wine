package api.backwine.service.impl;

import api.backwine.model.wine.WineType;
import api.backwine.repository.WineTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class WineTypeServiceImpl extends SoftDeleteGenericServiceImpl<WineType, Long>
        implements api.backwine.service.WineTypeService {

    public WineTypeServiceImpl(WineTypeRepository wineTypeService) {
        super(WineType.class, wineTypeService);
    }
}
