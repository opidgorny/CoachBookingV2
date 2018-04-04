package net.sportlife.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "city_name")
    private String cityName;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private Integer streetNumber;

    @OneToOne(mappedBy = "address")
    private Club club;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(cityName, address.cityName) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(club, address.club);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cityName, streetName, streetNumber, club);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", club=" + club.toString() +
                '}';
    }
}
