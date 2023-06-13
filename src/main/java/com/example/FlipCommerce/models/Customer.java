package com.example.FlipCommerce.models;

import com.example.FlipCommerce.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "mob_no",nullable = false,unique = true)
    String mobNo;

    @Column(name = "email_id",nullable = false,unique = true)
    String emailId;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;
}
