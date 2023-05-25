package com.spring.cardapio.models.dto;

import com.spring.cardapio.models.Food;

public record FoodResponseDTO(Long id, String title, String image, Float price) {

    public FoodResponseDTO (Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
