/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.todo;

import java.util.*;
import com.example.todo.Todo;
import com.example.todo.TodoService;

import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    TodoService todoService = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getAllTodos() {
        return todoService.getAllTodos();

    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo toodo) {
        return todoService.addTodo(toodo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodoById(@PathVariable("id") int id, @RequestBody Todo toodo) {
        return todoService.updateTodoById(id, toodo);
    }
    @DeleteMapping("todos/{id}")
    public void deleteTodoById(@PathVariable("id") int id){
        todoService.deleteTodoById(id);
    }


}