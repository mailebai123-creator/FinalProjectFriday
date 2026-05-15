package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    public List<Task> getAll(){
        return repository.findAll();
    }
    public Task getById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Task not found"));
    }
    public Task create(Task task){
        return repository.save(task);
    }
    public Task update(Long id,Task task){
        Task oldTask = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Task not found"));
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setTaskStatus(task.getTaskStatus());
        oldTask.setPriority(task.getPriority());
        oldTask.setDeadline(task.getDeadline());

        return repository.save(oldTask);
    }
    public void delete(Long id){
        repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Task not found"));
        repository.deleteById(id);
    }
}
