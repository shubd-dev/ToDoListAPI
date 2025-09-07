package com.roadmap.ToDoListAPI.repository;

import com.roadmap.ToDoListAPI.entity.ToDoTask;

import com.roadmap.ToDoListAPI.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskRepository extends CrudRepository<ToDoTask, Long> {
    List<ToDoTask> findByOwner(User owner);
}
