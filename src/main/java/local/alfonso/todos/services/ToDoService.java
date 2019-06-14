package local.alfonso.todos.services;

import local.alfonso.todos.models.ToDo;

import java.util.List;

public interface ToDoService
{
    List<ToDo> findAll();

    ToDo findTodoById(long id);

    void delete(long id);

    ToDo save(ToDo todo);

    ToDo update(ToDo todo, long id);
}
