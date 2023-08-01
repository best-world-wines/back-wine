package api.backwine.service.product;

import api.backwine.model.listener.GlobalTimestampedEntity;
import api.backwine.model.product.GlobalProductIdentifiable;
import api.backwine.repository.GlobalTimestampedRepository;
import api.backwine.service.GlobalGenericService;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;

public abstract class GlobalProductService<ENTITY extends GlobalProductIdentifiable<ID>, ID>
        implements GlobalGenericService<ENTITY, ID> {
    protected final GlobalTimestampedRepository<ENTITY, ID> repository;

    public GlobalProductService(GlobalTimestampedRepository<ENTITY, ID> repository) {
        this.repository = repository;
    }

    @Override
    public ENTITY create(ENTITY entity) {
        return repository.save(entity);
    }

    @Override
    public ENTITY getById(ID id) {
        return repository.findByIdAndDeletingDateIsNull(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get entity by ID: " + id));
    }

    @Override
    public List<ENTITY> getAll() {
        return repository.findAllByDeletingDateIsNull();
    }

    @Override
    public boolean deleteById(ID id) {
        ENTITY entity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get entity by ID: " + id + " for delete."));
        if (entity instanceof GlobalTimestampedEntity) {
            ((GlobalTimestampedEntity) entity).setDeletingDate(Instant.now());
        }
        repository.save(entity);
        return true;
    }

    @Override
    public ENTITY update(ID id, ENTITY entity) {
        entity.setId(id);
        if (entity instanceof GlobalTimestampedEntity) {
            ((GlobalTimestampedEntity) entity).setUpdatingDate(Instant.now());
        }
        return repository.save(entity);
    }
}
