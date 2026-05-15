package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class BeksultanCommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAll();
    }
    @PostMapping
    public Comment create(@RequestBody Comment comment){
        return commentService.create(comment);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        // update 2
        commentService.delete(id);
        return "Comment deleted";
    }
}
