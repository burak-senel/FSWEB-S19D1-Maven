package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> getFruitList(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit get(@Positive(message = "id sıfırdan küçük olamaz") @PathVariable("id") Long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitOrderDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{fruit}")
    public List<Fruit> nameFilter(@PathVariable("fruit") String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable("id") long id){
        return fruitService.delete(id);
    }
}
