package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repository;

    public List<Comment> getAll(){
        return repository.findAll();
    }
    public Comment create(Comment comment){
        return repository.save(comment);
    }
    public void delete(Long id){
        repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment not found"));
        repository.deleteById(id);
    }
}
