package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class BeksultanTaskController {
    private final TaskService taskService;
    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.getById(id);
    }
    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);

    }
    @PutMapping("/{id}")
    public Task update(
            @PathVariable Long id,
            @RequestBody Task task
    ) {

        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ) {

        taskService.delete(id);

        return "Task deleted";
    }
}
