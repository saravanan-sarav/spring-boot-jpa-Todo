package com.codewithsarav.springbootjpa.controller;

import com.codewithsarav.springbootjpa.model.Todo;
import com.codewithsarav.springbootjpa.model.User;
import com.codewithsarav.springbootjpa.request.TodoRequest;
import com.codewithsarav.springbootjpa.service.TodoService;
import com.codewithsarav.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
   @GetMapping("/all/{id}")
    public List<Todo> findAll(@PathVariable int id){
        return todoService.findAll(id);
    }
    @PostMapping
    public List<Todo> insert(@RequestBody TodoRequest todo){
        return todoService.insertItem(todo);
    }
    @PutMapping
    public List<Todo> update(@RequestBody TodoRequest todo){
        return todoService.update(todo);
    }
    @DeleteMapping("/{id}")
    public List<Todo> deleteById(@PathVariable int id){
        return todoService.deleteById(id);
    }


}
