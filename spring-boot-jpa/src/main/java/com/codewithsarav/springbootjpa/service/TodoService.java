package com.codewithsarav.springbootjpa.service;

import com.codewithsarav.springbootjpa.model.Todo;
import com.codewithsarav.springbootjpa.model.User;
import com.codewithsarav.springbootjpa.repository.TodoRepository;
import com.codewithsarav.springbootjpa.repository.UserRepository;
import com.codewithsarav.springbootjpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Todo> findAll(int id) {
        return todoRepository.findAll().stream()
                .filter(todo-> todo.getUser().getId()==id)
                .collect(Collectors.toList());
    }

    public List<Todo> insertItem(TodoRequest todoRequest) {
        Todo orginalTodo = new Todo();
        orginalTodo.setTodo(todoRequest.getTodo());
        User tempUser = userRepository.findById(todoRequest.getUserId()).get();
        orginalTodo.setUser(tempUser);
        todoRepository.save(orginalTodo);
        return findAll(todoRequest.getUserId());
    }

    public List<Todo> update(TodoRequest todoRequest) {
        Todo orginalTodo = new Todo();
        orginalTodo.setId(todoRequest.getId());
        orginalTodo.setTodo(todoRequest.getTodo());
        User tempUser = userRepository.findById(todoRequest.getUserId()).get();
        orginalTodo.setUser(tempUser);
        todoRepository.save(orginalTodo);
        return findAll(todoRequest.getUserId());
    }

    public List<Todo> deleteById(int id) {
        Todo deleteTodo = todoRepository.findById(id).get();
        User user = deleteTodo.getUser();
        todoRepository.deleteById(id);
        return findAll(user.getId());
    }
}
