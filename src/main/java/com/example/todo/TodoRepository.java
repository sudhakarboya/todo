// Write your code here

package com.example.todo;

import java.util.*;
import com.example.todo.Todo;

public interface TodoRepository {
    ArrayList<Todo> getAllTodos();

    Todo getTodoById(int id);

    Todo addTodo(Todo toodo);

    Todo updateTodoById(int id, Todo toodo);

    void deleteTodoById(int id);
}