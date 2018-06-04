package com.springboot.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.demo.entity.Student;

@Mapper
public interface StudentMapper {

    List<Student> getList();
    
    Student getStuById(Integer id);
    
    String getNameById(Integer id);
}
