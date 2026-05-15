package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
//
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
