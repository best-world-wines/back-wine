package api.backwine.model.abstraction;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Setter
@Getter
@MappedSuperclass
@EntityListeners({})
public abstract class GlobalTimestampedEntity<ID> implements GenericModel<ID> {
    @CreationTimestamp
    @Column(name = "creating_date", nullable = false, updatable = false)
    private Instant creatingDate;
    @Column(name = "updating_date")
    private Instant updatingDate;
    @Column(name = "deleting_date")
    private Instant deletingDate;
}
