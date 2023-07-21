package api.backwine.service.impl;

import api.backwine.model.WineType;
import api.backwine.repository.WineTypeRepository;
import api.backwine.service.WineTypeService;
import org.springframework.stereotype.Service;

@Service
public class WineTypeServiceImpl extends SoftDeleteGenericServiceImpl<WineType, Long>
        implements WineTypeService {

    public WineTypeServiceImpl(WineTypeRepository wineTypeRepository) {
        super(WineType.class, wineTypeRepository);
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
