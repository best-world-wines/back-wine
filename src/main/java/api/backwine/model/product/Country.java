package api.backwine.model.product;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import api.backwine.model.listener.CountryListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@EntityListeners(CountryListener.class)
public class Country extends GlobalTimestampedEntity<CountryCode> {
    @Id
    @Column(name = "code", nullable = false)
    @Enumerated(EnumType.STRING)
    private CountryCode id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "countries_grapes",
            joinColumns = @JoinColumn(name = "country_code"),
            inverseJoinColumns = @JoinColumn(name = "grape_id"))
    private List<Grape> mostUsedGrapes;
}
