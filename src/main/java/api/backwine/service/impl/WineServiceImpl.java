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
    public List<Wine> getAll() {
        return wineRepository.findAllByIsDeletedFalse();
    }

    @Override
    public Wine create(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public Wine getById(Long id) {
        return wineRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() ->
                new NoSuchElementException("Can't get wine by id " + id));
    }

    @Override
    public boolean deleteById(Long id) {
        Wine wine = wineRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't delete wine by id" + id));
        wine.setDeleted(true);
        wineRepository.save(wine);
        return true;
    }

    @Override
    public Wine update(Long id, Wine wine) {
        wine.setId(id);
        return wineRepository.save(wine);
    }
}


