package com.example.demomyapp.AllControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demomyapp.models.Pizza;
import com.example.demomyapp.repositories.PizzaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Integer id) {
        return pizzaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Integer id, @RequestBody Pizza updatedPizza) {
        return pizzaRepository.findById(id)
                .map(pizza -> {
                    updatedPizza.setId(id);
                    return ResponseEntity.ok(pizzaRepository.save(updatedPizza));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer id) {
        return pizzaRepository.findById(id)
                .map(pizza -> {
                    pizzaRepository.delete(pizza);
                    return ResponseEntity.noContent().<Void>build(); // fix for ResponseEntity<Void>
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
