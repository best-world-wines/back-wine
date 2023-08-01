package api.backwine.service.product.impl;

import api.backwine.model.product.WineType;
import api.backwine.repository.product.WineTypeRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.WineTypeService;
import org.springframework.stereotype.Service;

@Service
public class WineTypeServiceImpl
        extends GlobalProductService<WineType, Long> implements WineTypeService {

    public WineTypeServiceImpl(WineTypeRepository repository) {
        super(repository);
    }
}
