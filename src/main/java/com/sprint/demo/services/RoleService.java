package com.sprint.demo.services;

import com.sprint.demo.model.Role;

import java.util.List;

public interface RoleService {

        List<Role> findAll();

        Role findRoleById(long id);

        void delete(long id);

        Role save(Role role);

        Role update(Role role, long id);


}
