package api.backwine.service.impl;

import api.backwine.model.RegionImage;
import api.backwine.repository.RegionImageRepository;
import api.backwine.service.RegionImageService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RegionImageServiceImpl implements RegionImageService {
    private final RegionImageRepository regionImageRepository;

    public RegionImageServiceImpl(RegionImageRepository regionImageRepository) {
        this.regionImageRepository = regionImageRepository;
    }

    @Override
    public RegionImage create(RegionImage regionImage) {
        return regionImageRepository.save(regionImage);
    }

    @Override
    public RegionImage getById(Long id) {
        return regionImageRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get region image by id " + id));
    }

    @Override
    public List<RegionImage> getAll() {
        return regionImageRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        regionImageRepository.deleteById(id);
        return true;
    }

    @Override
    public RegionImage update(Long id, RegionImage regionImage) {
        regionImage.setId(id);
        return regionImageRepository.save(regionImage);
    }
}
