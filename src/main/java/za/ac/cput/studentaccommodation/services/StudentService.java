package za.ac.cput.studentaccommodation.services;

import za.ac.cput.studentaccommodation.domain.Student;

import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
public interface StudentService
{
    List<Student> getStudents();

    Student getStudent(Long studentID);

}
