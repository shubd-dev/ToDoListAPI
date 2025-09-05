package com.roadmap.ToDoListAPI.controller;

import com.roadmap.ToDoListAPI.entity.ToDotask;
import com.roadmap.ToDoListAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class testController {

    @Autowired
    private TaskRepository taskRepository;


    @PostMapping("/create-task")
    public @ResponseBody String createTask(@RequestParam String taskName, @RequestParam String taskDescription, @RequestParam Boolean status ){
        ToDotask t = new ToDotask();
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
