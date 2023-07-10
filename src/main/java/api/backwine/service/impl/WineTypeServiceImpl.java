package api.backwine.service.impl;

import api.backwine.model.WineType;
import api.backwine.repository.WineTypeRepository;
import api.backwine.service.AbstractService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class WineTypeServiceImpl implements AbstractService<WineType> {
    private final WineTypeRepository wineTypeRepository;

    public WineTypeServiceImpl(WineTypeRepository wineTypeRepository) {
        this.wineTypeRepository = wineTypeRepository;
    }

    @Override
    public WineType create(WineType wineType) {
        return wineTypeRepository.save(wineType);
    }

    @Override
    public WineType getById(Long id) {
        return wineTypeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get wine type by id " + id));
    }

    @Override
    public List<WineType> getAll() {
        return wineTypeRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        WineType wineType = wineTypeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't delete wine type by id" + id));
        wineType.setDeleted(true);
        wineTypeRepository.save(wineType);
        return true;
    }

    @Override
    public WineType update(Long id, WineType wineType) {
        wineType.setId(id);
        return wineTypeRepository.save(wineType);
    }
}
