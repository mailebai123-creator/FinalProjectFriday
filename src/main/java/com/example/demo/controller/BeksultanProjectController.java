package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class BeksultanProjectController {
    private final ProjectService projectService;
    @GetMapping
    public List<Project> getAll(){
        return projectService.getAll();
    }
    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id){
        return projectService.getById(id);
    }
    @PostMapping
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }
    @PutMapping("/{id}")
    public Project update(@PathVariable Long id,@RequestBody Project project){
        return projectService.update(id,project);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        // update 4
        projectService.delete(id);
        return "Project deleted";
    }
}
