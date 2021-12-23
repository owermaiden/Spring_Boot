package com.cybertek.controller;

import com.cybertek.model.*;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(teacher -> teacher.getAddress().setCurrentTemperature(new Address().consumeTemp(teacher.getAddress().getCity())));

        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.getAddress().setCurrentTemperature(new Address().consumeTemp(student.getAddress().getCity())));
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        List<Parent> parents = parentRepository.findAll();
        parents.forEach(parent -> parent.getAddress().setCurrentTemperature(new Address().consumeTemp(parent.getAddress().getCity())));
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved ",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()) throw new Exception("Address is not exist...");

        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);
    }


}
