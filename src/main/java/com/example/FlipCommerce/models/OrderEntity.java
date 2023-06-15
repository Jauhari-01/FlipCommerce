package com.example.FlipCommerce.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="order_info")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="order_no")
    String orderNo;

    @Column(name="total_value")
    int totalValue;

    @CreationTimestamp
    @Column(name="date_of_order")
    Date dateOfOrder;

    @Column(name="card_used")
    String cardUsed;

    /*Established child-parent relationship between Customer and Order */
    @ManyToOne
    @JoinColumn
    Customer customer;

    /*Established parent-child relationship between Customer and Order */
    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
