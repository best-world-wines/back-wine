package api.backwine.service.product.impl;

import api.backwine.model.product.WineStyle;
import api.backwine.repository.product.WineStyleRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.WineStyleService;
import org.springframework.stereotype.Service;

@Service
public class WineStyleServiceImpl
        extends GlobalProductService<WineStyle, Long> implements WineStyleService {

    public WineStyleServiceImpl(WineStyleRepository repository) {
        super(repository);
    }
}
