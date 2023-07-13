package api.backwine.service.impl;

import api.backwine.model.WineImage;
import api.backwine.repository.WineImageRepository;
import api.backwine.service.WineImageService;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WineImageServiceImpl implements WineImageService {
    private final WineImageRepository wineImageRepository;

    public WineImageServiceImpl(WineImageRepository wineImageRepository) {
        this.wineImageRepository = wineImageRepository;
    }

    @Override
    public WineImage create(WineImage wineImage) {
        return wineImageRepository.save(wineImage);
    }

    @Override
    public WineImage getById(Long id) {
        return wineImageRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get wine image by id " + id));
    }

    @Override
    public List<WineImage> getAll() {
        return wineImageRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        wineImageRepository.deleteById(id);
        return true;
    }

    @Override
    public WineImage update(Long id, WineImage wineImage) {
        wineImage.setId(id);
        return wineImageRepository.save(wineImage);
    }
}
