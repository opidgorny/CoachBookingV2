package net.sportlife.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clubs")
@Getter
@Setter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id")
    private Long id;

    @Column(name = "club_name")
    private String clubName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "clubSet")
    private Set<UserCoach> coaches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) &&
                Objects.equals(clubName, club.clubName) &&
                Objects.equals(address, club.address) &&
                Objects.equals(coaches, club.coaches);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, clubName, address, coaches);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", clubName='" + clubName + '\'' +
                '}';
    }
}
