package api.backwine.model;

import jakarta.persistence.CollectionTable;
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
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "wines")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String varietal;
    private String mainImage;
    @ElementCollection
    @Column(name = "image")
    private Set<String> images;
    private Double price;
    @Column(name = "bottle_volume")
    private Double bottleVolume;
    private String description;
    private Integer year;
    @Column(name = "winery_name")
    private String wineryName;
    @ManyToOne
    @JoinTable(
            name = "region_wines",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    private Region region;
    @ElementCollection
    @CollectionTable(
            name = "wine_interesting_fact",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "interesting_facts")
    private Set<String> interestingFacts;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    @ManyToMany
    @JoinTable(
            name = "wine_meals",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private Set<Meal> meals;
    @ManyToMany
    @JoinTable(
            name = "wine_grapes",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private Set<Grape> grapes;
    @Column(name = "is_deleted")
    private boolean isDeleted;

}
