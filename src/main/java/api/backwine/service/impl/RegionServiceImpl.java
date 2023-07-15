package api.backwine.service.impl;

import api.backwine.model.Region;
import api.backwine.repository.RegionRepository;
import api.backwine.service.RegionService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region getById(Long id) {
        return regionRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get region by id " + id));
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        regionRepository.deleteById(id);
        return true;
    }

    @Override
    public Region update(Long id, Region region) {
        region.setId(id);
        return regionRepository.save(region);
    }
}
