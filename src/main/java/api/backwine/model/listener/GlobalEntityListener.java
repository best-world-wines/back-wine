package api.backwine.model.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import java.time.Instant;

public abstract class GlobalEntityListener<ENTITY extends GlobalTimestampedEntity> {

    @PrePersist
    public void prePersist(ENTITY entity) {
        entity.setCreatingDate(Instant.now());
    }

    @PreUpdate
    public void preUpdate(ENTITY entity) {
        entity.setUpdatingDate(Instant.now());
    }

    @PreRemove
    public void preRemove(ENTITY entity) {
        entity.setDeletingDate(Instant.now());
    }
}
