package com.sprint.demo.repos;

import com.sprint.demo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Todo, Long> {

}
