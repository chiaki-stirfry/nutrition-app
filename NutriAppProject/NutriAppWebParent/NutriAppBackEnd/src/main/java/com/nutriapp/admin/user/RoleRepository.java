package com.nutriapp.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nutriapp.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}