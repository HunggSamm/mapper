package org.example.democrud.modules.mapper;


import org.apache.ibatis.annotations.Param;
import org.example.democrud.modules.entity.BaseResponse;
import org.example.democrud.modules.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StudentMapper {
    List<Student> getStudent(@Param("offset") int offset, @Param("size") int size);
    Student getStudentById(int id);
    int addStudent(Student student);
    int updateStudent( Student student);
    int deleteStudent(int id);
    int countStudents();
}
