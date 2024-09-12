package org.example.democrud.modules.controllers;

import org.example.democrud.modules.entity.BaseResponse;
import org.example.democrud.modules.entity.Student;
import org.example.democrud.modules.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class StudentAPIController {

    private final StudentService studentService;
    @Autowired
    public StudentAPIController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("students")
    public ResponseEntity<BaseResponse> getAllStudent(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(this.studentService.getAllStudents(page, size), HttpStatus.OK);

    }
    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getStudentById(@PathVariable int id) {
        return new ResponseEntity<>(this.studentService.getStudentById(id), HttpStatus.OK);
    }
    @PostMapping(value = "students")
    public ResponseEntity<BaseResponse> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(this.studentService.addStudent(student), HttpStatus.OK);
    }
    @PutMapping(value = "students/{id}")
    public ResponseEntity<BaseResponse> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        return new ResponseEntity<>(this.studentService.updateStudent(student), HttpStatus.OK);
    }
    @DeleteMapping(value = "students/{id}")
    public ResponseEntity<BaseResponse> deleteStudent(@PathVariable int id) {
        return new ResponseEntity<>(this.studentService.deleteStudent(id), HttpStatus.OK);
    }
}
