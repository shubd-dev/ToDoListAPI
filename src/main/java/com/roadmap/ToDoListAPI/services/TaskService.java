package com.roadmap.ToDoListAPI.services;

import com.roadmap.ToDoListAPI.entity.ToDoTask;
import com.roadmap.ToDoListAPI.entity.User;
import com.roadmap.ToDoListAPI.exceptions.TaskNotFoundException;
import com.roadmap.ToDoListAPI.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<ToDoTask> getAllTasksByUser(User user){
        return taskRepository.findByOwner(user);
    }

    public ToDoTask createTaskByUser(ToDoTask task, User user){
        task.setOwner(user);
        return taskRepository.save(task);
    }

    public ToDoTask getTaskByIdByUser(Long id, User user){
        try {
            List<ToDoTask> tasks = getAllTasksByUser(user);
            tasks.stream().filter(task -> task.getOwner().equals(user));
            tasks.stream().filter(task -> task.getId().equals(id));
            return tasks.get(id.intValue());
        } catch (Exception e) {
            throw new TaskNotFoundException("Task not found with id: "+id);
        }


//        return taskRepository.findById(id)
//                .filter(task -> task.getOwner().equals(user))
//                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    public ToDoTask updateTask(Long id, ToDoTask taskDetails, User user) {
        ToDoTask task = getTaskByIdByUser(id, user);
        task.setTaskName(taskDetails.getTaskName());
        task.setTaskDescription(taskDetails.getTaskDescription());
        task.setDeadline(taskDetails.getDeadline());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id, User user) {
        ToDoTask task = getTaskByIdByUser(id, user);
        taskRepository.delete(task);
    }

}
