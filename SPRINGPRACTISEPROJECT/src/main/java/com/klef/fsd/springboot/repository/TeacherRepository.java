package com.klef.fsd.springboot.repository;


import org.springframework.data.repository.CrudRepository;

import com.klef.fsd.springboot.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
