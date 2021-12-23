package com.cybertek.controller;

import com.cybertek.model.Teacher;
import com.cybertek.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final TeacherRepository teacherRepository;

    public ApiController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }
}
