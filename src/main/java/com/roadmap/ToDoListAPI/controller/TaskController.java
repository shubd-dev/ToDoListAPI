package com.roadmap.ToDoListAPI.controller;

import com.roadmap.ToDoListAPI.entity.ToDoTask;
import com.roadmap.ToDoListAPI.entity.User;
import com.roadmap.ToDoListAPI.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoTask>> getAllTasks(@AuthenticationPrincipal User currentUser) {
        List<ToDoTask> tasks = taskService.getAllTasksByUser(currentUser);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<ToDoTask> createTask(@RequestBody ToDoTask task, @AuthenticationPrincipal User currentUser) {
        ToDoTask createdTask = taskService.createTaskByUser(task, currentUser);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoTask> getTaskById(@PathVariable Long id, @AuthenticationPrincipal User currentUser) {
        ToDoTask task = taskService.getTaskByIdByUser(id, currentUser);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoTask> updateTask(@PathVariable Long id, @RequestBody ToDoTask taskDetails, @AuthenticationPrincipal User currentUser) {
        ToDoTask updatedTask = taskService.updateTask(id, taskDetails, currentUser);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, @AuthenticationPrincipal User currentUser) {
        taskService.deleteTask(id, currentUser);
        return ResponseEntity.noContent().build();
    }
}
