package com.example.FlipCommerce.models;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="card_no",unique = true,nullable = false)
    String cardNo;

    @Column(name="card_type")
    @Enumerated(EnumType.STRING)
    CardType cardType;

    @Column(name="cvv")
    int cvv;

    @Column(name="valid_till")
    Date validTill;

    /*Established child-parent relationship */

    @ManyToOne
    @JoinColumn
    Customer customer;

}
