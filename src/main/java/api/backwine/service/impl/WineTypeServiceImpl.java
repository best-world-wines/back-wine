package api.backwine.service.impl;

import api.backwine.model.WineType;
import api.backwine.repository.WineTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class WineTypeServiceImpl extends SoftDeleteGenericServiceImpl<WineType, Long>
        implements api.backwine.service.WineTypeService {

    public WineTypeServiceImpl(WineTypeRepository wineTypeService) {
        super(WineType.class, wineTypeService);
    }

    @Override
    protected WineType putId(Long id, WineType wineType) {
        wineType.setId(id);
        return wineType;
    }

    @Override
    protected WineType setDeleted(WineType wineType) {
        wineType.setDeleted(true);
        return wineType;
    }
}
