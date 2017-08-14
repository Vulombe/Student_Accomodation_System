package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.Student;
import za.ac.cput.studentaccommodation.services.StudentService;

import java.util.List;

/**
 * Created by student on 2015/04/25.
 */

@RestController
@RequestMapping("/api/**")
public class HomePage {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index() {
        return "This is a Home page, my Name is McDave";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Student getStudent() {
        Student student = new Student.Builder()
                .fName("Vulombe")
                .lName("Makhubele")
                .levelOfStudy("3rd")
                .build();
        return student;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}