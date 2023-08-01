package api.backwine.service.impl;

import api.backwine.model.abstraction.GenericModel;
import api.backwine.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public abstract class GenericServiceImpl<M extends GenericModel<I>, I> implements GenericService<M,
        I> {
    private final Class<M> clazz;
    private final ListCrudRepository<M, I> repository;

    protected GenericServiceImpl(Class<M> clazz, ListCrudRepository<M, I> repository) {
        this.clazz = clazz;
        this.repository = repository;
    }

    @Override
    public M create(M m) {
        return repository.save(m);
    }

    @Override
    @Transactional
    public M getById(I id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
    }

    @Override
    public List<M> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(I id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public M update(I id, M m) {
        m.setId(id);
        return repository.save(m);
    }
}
