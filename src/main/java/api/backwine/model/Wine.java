package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "wines")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(name = "bottle_volume")
    private Double bottleVolume;
    private String description;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    @Column(name = "interesting_facts")
    @ElementCollection
    @Cascade(CascadeType.ALL)
    private List<String> interestingFacts;
    @ManyToMany
    @JoinTable(
            name = "wine_taste",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "taste_id")
    )
    private List<Taste> tastes;
    @ManyToMany
    @JoinTable(
            name = "wine_meal",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;
    @ManyToMany
    @JoinTable(
            name = "wine_grapes",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private List<Grape> grapes;
}