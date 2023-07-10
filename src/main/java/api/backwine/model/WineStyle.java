package api.backwine.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "wine_styles")
@Where(clause = "is_deleted = false")
@Setter
@Getter
@NoArgsConstructor
public class WineStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "regional_name")
    private String regionalName;
    @Column(name = "varietal_name")
    private String varietalName;
    @ElementCollection
    @CollectionTable(
            name = "style_interesting_fact",
            joinColumns = @JoinColumn(name = "wine_style_id")
    )
    @Column(name = "interesting_facts")
    private Set<String> interestingFacts;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private WineType wineType;
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
