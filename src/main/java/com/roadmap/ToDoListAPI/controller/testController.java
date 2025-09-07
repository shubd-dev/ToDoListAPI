package com.roadmap.ToDoListAPI.controller;

import com.roadmap.ToDoListAPI.entity.ToDoTask;
import com.roadmap.ToDoListAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class testController {

        @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private com.roadmap.ToDoListAPI.repository.UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<com.roadmap.ToDoListAPI.entity.User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create-task")
    public @ResponseBody String createTask(@RequestParam String taskName, @RequestParam String taskDescription, @RequestParam Boolean status ){
        ToDoTask t = new ToDoTask();
        t.setTaskName(taskName);
        t.setTaskDescription(taskDescription);
        t.setStatus(status);

        taskRepository.save(t);
        return "Saved";
    }

    @GetMapping("/")
    public String greet(){
        return "Hello from my To List Application App";
    }


}
