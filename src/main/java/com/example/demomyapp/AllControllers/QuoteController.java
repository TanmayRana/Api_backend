package com.example.demomyapp.AllControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demomyapp.models.Quote;
import com.example.demomyapp.repositories.QuoteRepository;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteRepository quoteRepository;

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Integer id) {
        return quoteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Integer id, @RequestBody Quote updatedQuote) {
        return quoteRepository.findById(id)
                .map(existing -> {
                    existing.setQuote(updatedQuote.getQuote());
                    existing.setAuthor(updatedQuote.getAuthor());
                    return ResponseEntity.ok(quoteRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Integer id) {
        return quoteRepository.findById(id)
                .<ResponseEntity<Void>>map(quote -> {
                    quoteRepository.delete(quote);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
