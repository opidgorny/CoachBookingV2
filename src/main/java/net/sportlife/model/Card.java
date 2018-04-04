package net.sportlife.model;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.enums.CardStatusEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "card_status")
    @Enumerated(EnumType.STRING)
    private CardStatusEnum cardStatus;

    @OneToOne(mappedBy = "cardId")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(cardNumber, card.cardNumber) &&
                cardStatus == card.cardStatus &&
                Objects.equals(user, card.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cardNumber, cardStatus, user);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardStatus=" + cardStatus +
                '}';
    }
}
