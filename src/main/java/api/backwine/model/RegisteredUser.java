package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registered_users")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Setter
@Getter
public class RegisteredUser extends User {
    @Column(nullable = false)
    private String password;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
