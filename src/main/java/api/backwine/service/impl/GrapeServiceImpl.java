package api.backwine.service.impl;

import api.backwine.model.Grape;
import api.backwine.repository.GrapeRepository;
import api.backwine.service.GrapeService;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl implements GrapeService {
    private final GrapeRepository grapeRepository;

    public GrapeServiceImpl(GrapeRepository grapeRepository) {
        this.grapeRepository = grapeRepository;
    }

    @Override
    public Grape create(Grape grape) {
        return grapeRepository.save(grape);
    }

    @Override
    public Grape getById(Long id) {
        return grapeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get grape by id " + id));
    }

    @Override
    public List<Grape> getAll() {
        return grapeRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        grapeRepository.deleteById(id);
        return true;
    }

    @Override
    public Grape update(Long id, Grape grape) {
        grape.setId(id);
        return grapeRepository.save(grape);
    }
}
