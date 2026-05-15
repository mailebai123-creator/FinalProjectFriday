package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public List<User> getAll(){
        return repository.findAll();
    }
    public User getById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));

    }
    public void delete(Long id){
        repository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
        repository.deleteById(id);
    }
}
