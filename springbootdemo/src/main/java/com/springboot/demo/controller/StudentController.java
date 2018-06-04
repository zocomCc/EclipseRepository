package com.springboot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Student;
import com.springboot.demo.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping("/list")
    public List<Student> getStuList(){
        log.info("从数据库获取数据");
        return studentService.getStuList();
    }
    
    @RequestMapping("/info")
    public Student getInfo(@RequestParam Integer id) {
        log.info("根据ID获取信息");
        return studentService.getStuById(id);
    }
}
