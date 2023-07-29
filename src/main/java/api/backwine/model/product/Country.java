package api.backwine.model.product;

import api.backwine.model.listener.CountryListener;
import api.backwine.model.listener.GlobalTimestampedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
public class Country extends GlobalTimestampedEntity
        implements GlobalProductIdentifiable<CountryCode> {
    @Id
    @Column(name = "code", nullable = false)
    private CountryCode code;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "country_grapes",
            joinColumns = @JoinColumn(name = "country_code"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private List<Grape> mostUsedGrapes;

    public CountryCode getCode() {
        return code;
    }

    public void setCode(CountryCode code) {
        this.code = code;
    }

    @Override
    public CountryCode getId() {
        return null;
    }

    @Override
    public void setId(CountryCode id) {

    }
}
