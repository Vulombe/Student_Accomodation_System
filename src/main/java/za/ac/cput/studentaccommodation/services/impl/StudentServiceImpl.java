package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Student;
import za.ac.cput.studentaccommodation.repository.StudentRepository;
import za.ac.cput.studentaccommodation.restapi.student.StudentAPI;
import za.ac.cput.studentaccommodation.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2015/04/25.
 */
@Service
public class StudentServiceImpl implements StudentService
{
    private static StudentServiceImpl studentService=null;

    private StudentServiceImpl(){}

    public  static StudentServiceImpl getInstance(){
        if(studentService==null) {
            return new StudentServiceImpl();
        }
        return studentService;
    }

    @Override
    public Student findById(String s) {
        return StudentAPI.findById(s);
    }

    @Override
    public Student save(Student entity) {
        return StudentAPI.save(entity);
    }

    @Override
    public Student update(Student entity) {
        return StudentAPI.update(entity);
    }

    @Override
    public void delete(Student entity) {
        StudentAPI.update(entity);
    }

    @Override
    public Set<Student> findAll() {
        return StudentAPI.findAll();
    }
}
