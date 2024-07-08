package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;
    @GetMapping
    public List<Vegetable> getList(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@Positive(message = "id sıfırdan küçük olamaz") @PathVariable("id") Long id){
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getDescList(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{vegetable}")
    public List<Vegetable> findByName(@PathVariable("vegetable") String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable("id") long id){
        return vegetableService.delete(id);
    }
}
