package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentControler {

    @GetMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name", "Ower");   // attribute name, attribute value

        String course = "MVC";
        model.addAttribute("course", course);

        // create some userid ramdomly and show it in UI;
        int studentId = new Random().nextInt(1000);
        model.addAttribute("id",studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        model.addAttribute("numbers", numbers);

        //print your birthday

        LocalDate birthday = LocalDate.now().minusYears(41);
        model.addAttribute("birthday", birthday);

        Student student = new Student(1,"Mike", "Smith");
        model.addAttribute("student", student);


        return "student/welcome";
    }


    @GetMapping("/register")
    public String homePage2(Model model){
        return "student/register";
    }
}
