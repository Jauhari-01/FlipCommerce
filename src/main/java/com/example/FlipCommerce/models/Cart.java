package com.example.FlipCommerce.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="cart_total")
    int cartTotal;

    /*Established child-parent relationship */
    @OneToOne
    @JoinColumn
    Customer customer;

    /*Established parent-child relationship */
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
