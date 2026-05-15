package com.example.demo.mapper;

import com.example.demo.entity.Project;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Projectmapper {
    public Map<String,Object> toMap(Project project){
        Map<String,Object> map = new HashMap<>();
        map.put("id",project.getId());
        map.put("name",project.getName());
        map.put("description",project.getDescription());
        return map;
    }
}
