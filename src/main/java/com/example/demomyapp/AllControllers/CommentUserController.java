package com.example.demomyapp.AllControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demomyapp.models.CommentUser;
import com.example.demomyapp.repositories.CommentUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/commentusers")
@RequiredArgsConstructor
public class CommentUserController {

    private final CommentUserRepository commentUserRepository;

    @GetMapping
    public List<CommentUser> getAllUsers() {
        return commentUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentUser> getUserById(@PathVariable Integer id) {
        return commentUserRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CommentUser createUser(@RequestBody CommentUser user) {
        return commentUserRepository.save(user);
    }
}
