package api.backwine.model.wine;

import api.backwine.model.Country;
import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "regions")
@Setter
@Getter
@NoArgsConstructor
public class Region implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinTable(
            name = "country_regions",
            joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Country country;
    private String backgroundImage;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}
