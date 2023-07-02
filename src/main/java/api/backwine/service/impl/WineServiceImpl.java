package api.backwine.service.impl;

import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import api.backwine.service.WineService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @Override
    public Wine getWineById(Long id) {
        return wineRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get wine by id " + id));
    }

    @Override
    public Wine createWine(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public void deleteWine(Long id) {
        wineRepository.deleteById(id);
    }
}


