package com.sprint.demo.services;

import com.sprint.demo.model.Todo;

import java.util.List;

public interface TodoService {

        List<Todo> findAll();

        Todo findTodoById(long id);

        void delete(long id);

        Todo save(Todo todo);

        Todo update(Todo todo,long id);

}
