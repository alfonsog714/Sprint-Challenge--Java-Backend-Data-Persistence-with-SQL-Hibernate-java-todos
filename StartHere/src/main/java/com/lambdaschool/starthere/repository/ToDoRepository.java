package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{
}
