package com.example.demomyapp.AllControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demomyapp.models.Todo;
import com.example.demomyapp.repositories.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Integer id) {
        return todoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Todo> getTodosByUserId(@PathVariable Integer userId) {
        return todoRepository.findByUserId(userId);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTodo(updatedTodo.getTodo());
                    existingTodo.setCompleted(updatedTodo.getCompleted());
                    existingTodo.setUserId(updatedTodo.getUserId());
                    return ResponseEntity.ok(todoRepository.save(existingTodo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        return todoRepository.findById(id)
                .<ResponseEntity<Void>>map(todo -> {
                    todoRepository.delete(todo);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
