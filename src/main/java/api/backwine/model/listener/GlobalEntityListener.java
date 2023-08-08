package api.backwine.model.listener;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import java.time.Instant;

//TODO: check for how works preUpdate and preRemove and consider about add annotation to model.
public abstract class GlobalEntityListener<ENTITY extends GlobalTimestampedEntity<?>> {

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
