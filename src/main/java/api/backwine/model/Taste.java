package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tastes")
@Setter
@Getter
@NoArgsConstructor
public class Taste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "taste_type")
    @Enumerated(EnumType.STRING)
    private TasteType tasteType;
    @Max(10)
    @Min(-10)
    //TODO clarify max and min values
    private Float value;

    public enum TasteType {
        ACIDITY,
        FIZZINESS,
        INTENSITY,
        SWEETNESS,
        TANNIN
    }
}
