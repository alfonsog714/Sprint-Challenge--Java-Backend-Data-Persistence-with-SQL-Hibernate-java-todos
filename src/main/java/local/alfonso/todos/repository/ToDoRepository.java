package local.alfonso.todos.repository;

import local.alfonso.todos.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{
}
