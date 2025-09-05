package com.klef.fsd.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.klef.fsd.springboot.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
