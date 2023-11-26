/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here

    int uniqueId = 6;

    @Override
    public ArrayList<Todo> getAllTodos() {
        Collection<Todo> todosCollection = todoList.values();
        ArrayList<Todo> allTodos = new ArrayList<>(todosCollection);
        return allTodos;
    }

    @Override
    public Todo getTodoById(int id) {
        Todo toodo = todoList.get(id);
        if (toodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return toodo;
        }
    }

    @Override
    public Todo addTodo(Todo toodo) {
        toodo.setId(uniqueId);
        todoList.put(uniqueId, toodo);
        uniqueId += 1;
        return toodo;
    }

    @Override
    public Todo updateTodoById(int id, Todo toodo) {
        Todo existTodo = todoList.get(id);
        if (existTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (toodo.getTodo() != null) {
            existTodo.setTodo(toodo.getTodo());
        }
        if (toodo.getPriority() != null) {
            existTodo.setPriority(toodo.getPriority());
        }
        if (toodo.getStatus() != null) {
            existTodo.setStatus(toodo.getStatus());
        }
        return existTodo;
    }
    @Override 
    public void deleteTodoById(int id){
        Todo todo=todoList.get(id);
        if(todo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
