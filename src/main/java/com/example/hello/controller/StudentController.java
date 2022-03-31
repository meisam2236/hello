package com.example.hello.controller;

import com.student.app.model.repr.StudentRepr;
import com.student.app.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {
    private StudentService amqpFactoryBean;

    public StudentController(StudentService amqpFactoryBean) {
        super();
        this.amqpFactoryBean = amqpFactoryBean;
    }

    @PostMapping
    public ResponseEntity<StudentRepr> saveStudent(@RequestBody StudentRepr student){
        return new ResponseEntity<StudentRepr>(amqpFactoryBean.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentRepr> getAllStudents(){
        return amqpFactoryBean.getAllStudents();
    }

    @GetMapping("{id}/")
    public StudentRepr getStudentById(@PathVariable("id") long id){
        return amqpFactoryBean.getStudentById(id);
    }

    @PutMapping("{id}/")
    public ResponseEntity<StudentRepr> updateStudentById(@PathVariable("id") long id, @RequestBody StudentRepr student){
        return new ResponseEntity<StudentRepr>(amqpFactoryBean.updateStudent(student, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id){
        amqpFactoryBean.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.ACCEPTED);
    }
    @GetMapping("above-15/")
    public Map<String, ArrayList<StudentRepr>> getStudentsByGrade() {
        return amqpFactoryBean.getStudentsAbove15();
    }
}
