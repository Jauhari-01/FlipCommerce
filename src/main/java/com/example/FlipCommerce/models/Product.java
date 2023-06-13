package com.example.FlipCommerce.models;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="name")
    String name;

    @Column(name="price")
    Integer price;

    @Column(name="quantity")
    Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    Category category;

    @Enumerated(EnumType.STRING)
    @Column(name="procuct_status")
    ProductStatus productStatus;
}
