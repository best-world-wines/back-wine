package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class UserDetailed extends User {
    @Column(nullable = false)
    private String password;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
