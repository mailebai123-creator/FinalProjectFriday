package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMaper {

    public Map<String,Object> toMap(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("email",user.getEmail());
        map.put("role",user.getRole());

        return map;
    }
}
