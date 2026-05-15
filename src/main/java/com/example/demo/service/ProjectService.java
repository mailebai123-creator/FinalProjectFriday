package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;
    public List<Project> getAll(){
        return repository.findAll();
    }
    public Project getById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));
    }
    public Project create(Project project){
        return repository.save(project);
    }
    public Project update(Long id,Project project){
        Project oldProject = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));
        oldProject.setName(project.getName());
        oldProject.setDescription(project.getDescription());
        return repository.save(oldProject);
    }
    public void delete(Long id){
        repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found"));
        repository.deleteById(id);
    }
}
