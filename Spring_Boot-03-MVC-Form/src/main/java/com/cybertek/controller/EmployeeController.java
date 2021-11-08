package com.cybertek.controller;

import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String showEmployee(Model model){

        model.addAttribute("employee", new Employee());

        List<String> states = Arrays.asList("Alaska","Virginia","Denver");
        model.addAttribute("states", states);

        return "employee/employee-register";

    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("employee") Employee employee){

        return "employee/employee-confirmation";
    }

}
