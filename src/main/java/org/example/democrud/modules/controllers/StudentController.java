package org.example.democrud.modules.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/students")
    public String getAllStudent() {
        return "index";
    }
    @GetMapping("/students/add")
    public String addStudent() {
        return "newStudent";
    }
}
