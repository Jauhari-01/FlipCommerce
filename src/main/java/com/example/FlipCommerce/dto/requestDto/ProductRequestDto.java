package com.example.FlipCommerce.dto.requestDto;


import com.example.FlipCommerce.Enum.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {
    String sellerEmailId;
    String name;
    Integer price;
    Integer quantity;
    Category category;
}