package api.backwine.service.impl;

import api.backwine.model.Grape;
import api.backwine.repository.GrapeRepository;
import api.backwine.service.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GrapeServiceImpl implements AbstractService<Grape> {
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
        Grape grape = grapeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't delete grape by id" + id));
        grape.setDeleted(true);
        grapeRepository.save(grape);
        return true;
    }

    @Override
    public Grape update(Long id, Grape grape) {
        grape.setId(id);
        return grapeRepository.save(grape);
    }
}
