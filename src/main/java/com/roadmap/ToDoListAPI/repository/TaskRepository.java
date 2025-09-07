package com.roadmap.ToDoListAPI.repository;

import com.roadmap.ToDoListAPI.entity.ToDoTask;

import org.springframework.data.repository.CrudRepository;



public interface TaskRepository extends CrudRepository<ToDoTask, Long> {
}
