package net.sportlife.model;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.enums.CoachStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_coaches")
@Getter
@Setter
public class UserCoach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long id;

    @Column(name = "coach_rank")
    private String coachRank;
    @Column(name = "hour_price")
    private Integer hourPrice;

    @Column(name = "coach_status")
    @Enumerated(EnumType.STRING)
    private CoachStatusEnum coachStatus;

    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToMany
    @JoinTable(name = "coach_clubs", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
    private Set<Club> clubSet = new HashSet<>();

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    public UserCoach() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCoach userCoach = (UserCoach) o;
        return  Objects.equals(coachRank, userCoach.coachRank) &&
                Objects.equals(hourPrice, userCoach.hourPrice) &&
                coachStatus == userCoach.coachStatus &&
                Objects.equals(additionalInfo, userCoach.additionalInfo) &&
                Objects.equals(clubSet, userCoach.clubSet) &&
                Objects.equals(bookings, userCoach.bookings);
    }

    @Override
    public int hashCode() {

        return Objects.hash(coachRank, hourPrice, coachStatus, additionalInfo, clubSet, bookings);
    }

    @Override
    public String toString() {
        return "UserCoach{" +
                ", coachRank='" + coachRank + '\'' +
                ", hourPrice=" + hourPrice +
                ", coachStatus=" + coachStatus +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
