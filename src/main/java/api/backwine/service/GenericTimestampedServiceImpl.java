package api.backwine.service;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import api.backwine.repository.abstraction.TimestampedRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;

public abstract class GenericTimestampedServiceImpl<ENTITY extends GlobalTimestampedEntity<ID>, ID>
        extends GenericServiceImpl<ENTITY, ID> {
    private final TimestampedRepository<ENTITY, ID> repository;
    private final Class<ENTITY> clazz;

    protected GenericTimestampedServiceImpl(Class<ENTITY> clazz,
                                            TimestampedRepository<ENTITY, ID> repository) {
        super(clazz, repository);
        this.clazz = clazz;
        this.repository = repository;
    }

    @Override
    public List<ENTITY> getAll() {
        return repository.findAllByDeletingDateIsNull();
    }

    @Override
    public ENTITY getById(ID id) {
        return repository.findByIdAndDeletingDateIsNull(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
    }

    @Override
    public boolean deleteById(ID id) {
        ENTITY entity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get " + clazz.getSimpleName() + " by id " + id));
        entity.setDeletingDate(Instant.now());
        repository.save(entity);
        return true;
    }

    @Override
    public ENTITY update(ID id, ENTITY entity) {
        entity.setUpdatingDate(Instant.now());
        return super.update(id, entity);
    }
}
