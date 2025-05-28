package com.example.demomyapp.AllControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demomyapp.models.Dessert;
import com.example.demomyapp.repositories.DessertRepository;

import java.util.List;

@RestController
@RequestMapping("/api/desserts")
public class DessertController {

    private final DessertRepository dessertRepository;

    public DessertController(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    @GetMapping
    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dessert> getDessertById(@PathVariable Integer id) {
        return dessertRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dessert createDessert(@RequestBody Dessert dessert) {
        return dessertRepository.save(dessert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dessert> updateDessert(@PathVariable Integer id, @RequestBody Dessert updatedDessert) {
        return dessertRepository.findById(id)
                .map(dessert -> {
                    updatedDessert.setId(id);
                    return ResponseEntity.ok(dessertRepository.save(updatedDessert));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDessert(@PathVariable Integer id) {
        return dessertRepository.findById(id)
                .map(dessert -> {
                    dessertRepository.delete(dessert);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
