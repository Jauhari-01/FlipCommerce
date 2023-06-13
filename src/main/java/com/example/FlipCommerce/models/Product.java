package com.example.FlipCommerce.models;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.ProductStatus;
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
    @Column(name="product_status")
    ProductStatus productStatus;

    /*Established child-parent relationship between product and Seller*/
    @ManyToOne
    @JoinColumn
    Seller seller;

    /*Established parent-child relationship between product and item*/
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
