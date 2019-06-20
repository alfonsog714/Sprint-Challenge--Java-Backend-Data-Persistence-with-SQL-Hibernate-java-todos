package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.ToDo;
import com.lambdaschool.starthere.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    private ToDoService toDoService;

    @PutMapping(value = "/todoid/{todoid}")
    public ResponseEntity<?> updateTodoById(@PathVariable long todoid, @RequestBody ToDo updateTodo)
    {
        toDoService.update(updateTodo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
