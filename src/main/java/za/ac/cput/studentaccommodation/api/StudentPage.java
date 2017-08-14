package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.Student;
import za.ac.cput.studentaccommodation.model.StudentResource;
import za.ac.cput.studentaccommodation.services.StudentService;
import za.ac.cput.studentaccommodation.services.impl.StudentServiceImpl;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping("api/student/**")
public class StudentPage
{
    @Autowired
    private StudentService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Student details";
    }

    @RequestMapping(value = "/{studentID}", method = RequestMethod.GET)
    public StudentResource getResAdmin(@PathVariable Long studentID)
    {
        StudentResource hateoas;
        Student student = service.getStudent(studentID);
        StudentResource resource = new StudentResource
                .Builder()
                .levelOfStudy(student.getLevelOfStudy())
                .fName(student.getfName())
                .lName(student.getlName())
                .contactAddress(student.getContactAddress())
                .address(student.getAddress())
                .payments(student.getPayments())
                .rooms(student.getRooms())
                .build();

        Link StudentsDetails = new
                Link("http://localhost:8080/api/student/" + resource.getStudentID().toString())
                .withRel("students");

        resource.add(StudentsDetails);
        hateoas = resource;

        return hateoas;
    }
}
