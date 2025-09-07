package com.roadmap.ToDoListAPI.repository;

import com.roadmap.ToDoListAPI.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
