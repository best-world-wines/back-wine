package api.backwine.model.shop;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class User implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(unique = true)
    private String phone;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private boolean isDeleted = false;

    @Override
    public String toString() {
        return "User{"
                + "id=" + id + '\''
                + ", email='" + email + '\''
                + ", firstName='" + firstName + '\''
                + ", secondName='" + secondName + '\''
                + ", phone='" + phone + '\''
                + ", registrationDate=" + registrationDate + '\''
                + ", roles=" + roles + '\''
                + ", cart=" + cart + '\''
                + ", isDeleted=" + isDeleted + '\''
                + '}';
    }
}
