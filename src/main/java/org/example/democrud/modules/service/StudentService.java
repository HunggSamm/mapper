package org.example.democrud.modules.service;

import org.example.democrud.modules.entity.BaseResponse;
import org.example.democrud.modules.mapper.StudentMapper;
import org.example.democrud.modules.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentDao;
    @Autowired
    public StudentService(StudentMapper studentDao) {
        this.studentDao = studentDao;
    }

    public BaseResponse getAllStudents(int page, int size) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            int offset = (page - 1) * size;
            List<Student> students = studentDao.getStudent(offset, size);
            int totalRecord = studentDao.countStudents();

            if (students != null && !students.isEmpty()) {
                baseResponse = new BaseResponse(students, "0", "Retrieve Successfully", totalRecord);
            } else {
                baseResponse = new BaseResponse("1", "No Students Found");
            }
        } catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed to Retrieve Students");
        }
        return baseResponse;
    }

    public BaseResponse getStudentById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            Student result = this.studentDao.getStudentById(id);

            if(result.getId() >= 0) {
                baseResponse = new BaseResponse(result, "0", "Find Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Find failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }


    public BaseResponse addStudent(Student student) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = this.studentDao.addStudent(student);
            int totalRecord = this.studentDao.countStudents();

            if(result >= 0) {
                baseResponse = new BaseResponse(result, "0", "Add Successfully",totalRecord);
            }else {
                baseResponse = new BaseResponse("1", "Add failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateStudent( Student student) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            Student check = this.studentDao.getStudentById(student.getId());

            int result = this.studentDao.updateStudent(student);

            if(result >= 0 && check.getId() >= 0) {
                baseResponse = new BaseResponse(result, "0", "Update Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Update failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteStudent(int id) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = this.studentDao.deleteStudent(id);

            if(result >= 0) {
                baseResponse = new BaseResponse(result, "0", "Delete Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Delete failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
