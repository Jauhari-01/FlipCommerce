package com.example.FlipCommerce.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="required_quantity")
    int requiredQuantity;

    /*Established child-parent relationship between item and product */
    @ManyToOne
    @JoinColumn
    Product product;

    /*Established child-parent relationship between item and Order */
    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;

    /*Established child-parent relationship between item and cart */
    @ManyToOne
    @JoinColumn
    Cart cart;
}
