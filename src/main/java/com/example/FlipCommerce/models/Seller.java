package com.example.FlipCommerce.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="seller")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name ="name")
    String name;

    @Column(name="mob_no",unique = true, nullable = false)
    String mobNo;

    @Column(name="email_id",unique = true, nullable = false)
    String emailId;

    /*Established parent-child relationship between Seller to Product*/
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();
 }
