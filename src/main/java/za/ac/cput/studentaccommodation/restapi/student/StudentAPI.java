package za.ac.cput.studentaccommodation.restapi.student;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.Student;

import java.util.Set;

public class StudentAPI
{
    public static Student save(Student student){
        return RestUtil.save(StudentBaseUrl.Student.POST, student, Student.class);
    }

    public static Student findById(String id){
        return RestUtil.getById(StudentBaseUrl.Student.GET,id,Student.class);
    }
    public static Student update(Student student){
        return RestUtil.update(StudentBaseUrl.Student.PUT,student);
    }
    public static Set<Student> findAll(){
        return RestUtil.getAll(StudentBaseUrl.Student.GET_ALL,Student.class);
    }
}
