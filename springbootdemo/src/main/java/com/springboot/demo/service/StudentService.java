package com.springboot.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.Student;
import com.springboot.demo.mapper.StudentMapper;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StudentMapper studentMapper;
    
    public List<Student> getStuList(){
        String sql = "select * from student";
        List<Student> stuList = jdbcTemplate.query(sql, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setAge(rs.getInt("age"));
                stu.setName(rs.getString("name"));
                stu.setSumScore(rs.getString("sumScore"));
                stu.setAvgScore(rs.getString("avgScore"));
                return stu;
            }
            
        });
        return stuList;
    }
    
    public Student getStuById(Integer id) {
        return studentMapper.getStuById(id);
    }
}
