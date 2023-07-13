package api.backwine.service.impl;

import api.backwine.model.Taste;
import api.backwine.repository.TasteRepository;
import api.backwine.service.TasteService;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TasteServiceImpl implements TasteService {
    private final TasteRepository tasteRepository;

    public TasteServiceImpl(TasteRepository tasteRepository) {
        this.tasteRepository = tasteRepository;
    }

    @Override
    public Taste create(Taste taste) {
        return tasteRepository.save(taste);
    }

    @Override
    public Taste getById(Long id) {
        return tasteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get taste by id " + id));
    }

    @Override
    public List<Taste> getAll() {
        return tasteRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        tasteRepository.deleteById(id);
        return true;
    }

    @Override
    public Taste update(Long id, Taste taste) {
        taste.setId(id);
        return tasteRepository.save(taste);
    }
}
