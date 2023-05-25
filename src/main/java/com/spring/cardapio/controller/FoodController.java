package com.spring.cardapio.controller;

import com.spring.cardapio.models.Food;
import com.spring.cardapio.models.dto.FoodRequestDTO;
import com.spring.cardapio.models.dto.FoodResponseDTO;
import com.spring.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Food saveFood(@RequestBody FoodRequestDTO data){
        Food food = new Food(data);
        foodRepository.save(food);
        return food;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> findAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        return foodList;
    }
}
