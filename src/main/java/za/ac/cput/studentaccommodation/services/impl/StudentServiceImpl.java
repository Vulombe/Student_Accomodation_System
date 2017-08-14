package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Student;
import za.ac.cput.studentaccommodation.repository.StudentRepository;
import za.ac.cput.studentaccommodation.services.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepository repository;
    public List<Student> getStudents(){
        List<Student> allstudents = new ArrayList<Student>();
        Iterable<Student> students = repository.findAll();
        for (Student student : students)
        {
            allstudents.add(student);
        }

        return allstudents;
    }

    public Student getStudent(Long studentID)
    {
        return repository.findOne(studentID);
    }
}
