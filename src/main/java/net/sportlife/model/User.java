package net.sportlife.model;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.enums.RoleStatusEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleStatusEnum role;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card cardId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                role == user.role &&
                Objects.equals(cardId, user.cardId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, role, cardId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.getParamName() +
                ", cardId=" + cardId.toString() +
                ", userDetailedInfo=" +
                '}';
    }
}
