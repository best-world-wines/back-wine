package api.backwine.service.impl;

import api.backwine.model.WineStyle;
import api.backwine.repository.WineStyleRepository;
import api.backwine.service.WineStyleService;
import org.springframework.stereotype.Service;

@Service
public class WineStyleServiceImpl extends SoftDeleteGenericServiceImpl<WineStyle, Long>
        implements WineStyleService {

    public WineStyleServiceImpl(WineStyleRepository wineStyleRepository) {
        super(WineStyle.class, wineStyleRepository);
    }

    @Override
    protected WineStyle putId(Long id, WineStyle wineStyle) {
        wineStyle.setId(id);
        return wineStyle;
    }

    @Override
    protected WineStyle setDeleted(WineStyle wineStyle) {
        wineStyle.setDeleted(true);
        return wineStyle;
    }
}
