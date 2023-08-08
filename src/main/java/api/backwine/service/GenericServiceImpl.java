package api.backwine.service;

import api.backwine.model.abstraction.GenericModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public abstract class GenericServiceImpl<ENTITY extends GenericModel<ID>, ID>
        implements GenericService<ENTITY,
        ID> {
    private final Class<ENTITY> clazz;
    private final ListCrudRepository<ENTITY, ID> repository;

    protected GenericServiceImpl(Class<ENTITY> clazz, ListCrudRepository<ENTITY, ID> repository) {
        this.clazz = clazz;
        this.repository = repository;
    }

    @Override
    public ENTITY create(ENTITY entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public ENTITY getById(ID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
    }

    @Override
    public List<ENTITY> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(ID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public ENTITY update(ID id, ENTITY entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
