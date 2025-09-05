package com.roadmap.ToDoListAPI.repository;

import com.roadmap.ToDoListAPI.entity.ToDotask;

import org.springframework.data.repository.CrudRepository;



public interface TaskRepository extends CrudRepository<ToDotask, Long> {
}
