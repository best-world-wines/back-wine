package api.backwine.service.impl;

import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import api.backwine.service.WineService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;


    @Override
    public Wine save(Wine wine) {
        return wineRepository.save(wine);
    }
}
