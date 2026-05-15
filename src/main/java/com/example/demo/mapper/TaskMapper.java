package com.example.demo.mapper;

import com.example.demo.entity.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class TaskMapper {
    public Map<String, Object> tomap(Task task){
        Map<String,Object> map = new HashMap<>();
        map.put("id",task.getId());
        map.put("title",task.getTitle());
        map.put("description",task.getDescription());
        map.put("status",task.getTaskStatus());
        map.put("priority",task.getPriority());
        map.put("deadline",task.getDeadline());
        return map;
    }
}
