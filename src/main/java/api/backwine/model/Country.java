package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "countries")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
public class Country {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "code", nullable = false)
    private String code;
    private String name;
    @OneToMany
    @JoinTable(
            name = "country_regions",
            joinColumns = @JoinColumn(name = "country_code"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    private Set<Region> regions;
    @JoinTable(
            name = "country_grapes",
            joinColumns = @JoinColumn(name = "country_code"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    @OneToMany
    private Set<Grape> grapes;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
