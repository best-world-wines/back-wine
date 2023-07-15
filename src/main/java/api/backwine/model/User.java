package api.backwine.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(unique = true)
    private String phone;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(secondName, user.secondName)
                && Objects.equals(phone, user.phone)
                && Objects.equals(birthDate, user.birthDate)
                && Objects.equals(registrationDate, user.registrationDate)
                && Objects.equals(roles, user.roles)
                && Objects.equals(isDeleted, user.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, secondName, phone, birthDate,
                registrationDate, roles, isDeleted);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id + '\''
                + ", email='" + email + '\''
                + ", password='" + "hidden" + '\''
                + ", firstName='" + firstName + '\''
                + ", secondName='" + secondName + '\''
                + ", phone='" + phone + '\''
                + ", birthDate=" + birthDate + '\''
                + ", registrationDate=" + registrationDate + '\''
                + ", roles=" + roles + '\''
                + ", isDeleted=" + isDeleted + '\''
                + '}';
    }
}
