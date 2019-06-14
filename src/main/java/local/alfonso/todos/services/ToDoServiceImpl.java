package local.alfonso.todos.services;

import local.alfonso.todos.models.ToDo;
import local.alfonso.todos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class ToDoServiceImpl implements ToDoService
{
    @Autowired
    ToDoRepository trepos;

    @Override
    public List<ToDo> findAll()
    {
        List<ToDo> list = new ArrayList<>();

        trepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ToDo findTodoById(long id)
    {
        return trepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        trepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        trepos.deleteById(id);

    }

    @Override
    public ToDo save(ToDo todo)
    {
        ToDo newTodo = new ToDo();
        newTodo.setCompleted(todo.getCompleted());
        newTodo.setDescription(todo.getDescription());
        newTodo.setUsertodo(todo.getUsertodo());

        return trepos.save(newTodo);
    }

    @Override
    public ToDo update(ToDo todo, long id)
    {
        ToDo currentTodo = trepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }

        if (todo.getCompleted() != null)
        {
            currentTodo.setCompleted(todo.getCompleted());
        }

        return trepos.save(currentTodo);
    }
}
