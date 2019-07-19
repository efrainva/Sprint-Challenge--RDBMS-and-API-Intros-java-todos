package com.sprint.demo.repos;

import com.sprint.demo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Todo findTodoById(int id);
}
