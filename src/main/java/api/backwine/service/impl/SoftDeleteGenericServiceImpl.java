package api.backwine.service.impl;

import api.backwine.model.abstraction.SoftDeleteModel;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;

public abstract class SoftDeleteGenericServiceImpl<M extends SoftDeleteModel<I>, I>
        extends GenericServiceImpl<M, I> {
    private final SoftDeleteRepository<M, I> repository;
    private final Class<M> clazz;

    protected SoftDeleteGenericServiceImpl(Class<M> clazz, SoftDeleteRepository<M, I> repository) {
        super(clazz, repository);
        this.clazz = clazz;
        this.repository = repository;
    }

    @Override
    public List<M> getAll() {
        return repository.findAllByIsDeletedFalse();
    }

    @Override
    @Transactional
    public M getById(I id) {
        return repository.findByIdAndIsDeletedFalse(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
    }

    @Override
    public boolean deleteById(I id) {
        M m = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
        m.setDeleted(true);
        repository.save(m);
        return true;
    }
}
