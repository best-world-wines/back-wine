package api.backwine.model;

import api.backwine.model.abstraction.SoftDeleteModel;
import api.backwine.model.wine.Grape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Setter
@Getter
@NoArgsConstructor
public class Country implements SoftDeleteModel<String> {
    @Id
    @Column(name = "code", nullable = false)
    private String id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "country_grapes",
            joinColumns = @JoinColumn(name = "country_code"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private List<Grape> mostUsedGrapes;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}
